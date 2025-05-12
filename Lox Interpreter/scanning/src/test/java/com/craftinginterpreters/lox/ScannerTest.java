package com.craftinginterpreters.lox;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

class ScannerTest {
  private void run(String source, boolean expectError, int expectedSize, String expectedTokenString) {
    Lox.hadError = false;
    Scanner scanner = new Scanner(source);
    List<Token> tokens = scanner.scanTokens();
    assertEquals(expectedTokenString, tokens.toString());
    //assertEquals(expectedSize, tokens.size());
    assertEquals(expectError, Lox.hadError);
  }

  @Test
  void twoSingleLineComments() {
    run("""
          /* this is a comment */
          hi mom
          // this is a comment
          /* this is a comment */
        """,
        false, 3,
        "[IDENTIFIER hi null, IDENTIFIER mom null, EOF  null]");
  }

  @Test
  void singleLineCommentWithTwoAsterisks() {
    run("""
          hi mom
          // this is a comment
          /* this is a comment **/
          1 + 3;
        """,
        false, 7,
        "[IDENTIFIER hi null, IDENTIFIER mom null, NUMBER 1 1.0, PLUS + null, NUMBER 3 3.0, SEMICOLON ; null, EOF  null]");
  }

  @Test
  void twoCommentsOnOneLine() {
    run("""
          /* this is a comment */ 1+ 3 /*another comment*/
        """,
        false, 4,
        "[NUMBER 1 1.0, PLUS + null, NUMBER 3 3.0, EOF  null]");
  }

  @Test
  void twoCommentsOnOneLineAdjacent() {
    run("""
          1+/* this is a comment *//*another comment*/3
        """,
        false, 4,
        "[NUMBER 1 1.0, PLUS + null, NUMBER 3 3.0, EOF  null]");
  }

  @Test
  void nestedComments() {
    run("""
          1 +
          /* this is a comment
            /* another comment
             * /* yet another comment */
            */
          */
          3
        """,
        false, 4,
        "[NUMBER 1 1.0, PLUS + null, NUMBER 3 3.0, EOF  null]");
  }

  @Test
  void nestedAmbiguity() {
    run("""
          1
          /* this could be an open comment or a close comment: /*/
          2
          /* the rule is that we will take it as close comment.  Same here: //*/
          3
        """,
        false, 4,
        "[NUMBER 1 1.0, NUMBER 2 2.0, NUMBER 3 3.0, EOF  null]");
  }

  @Test
  void commentInComment() {
    run("""
          4.1 /*//*/ + 3.dog()
        """,
        false, 8,
        "[NUMBER 4.1 4.1, PLUS + null, NUMBER 3 3.0, DOT . null, IDENTIFIER dog null, LEFT_PAREN ( null, RIGHT_PAREN ) null, EOF  null]");
  }

  @Test
  void unterminatedComment() {
    run("""
          4.1 /*
        """,
        true, 2,
        "[NUMBER 4.1 4.1, EOF  null]");
  }
}
