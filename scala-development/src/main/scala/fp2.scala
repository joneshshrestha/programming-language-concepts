// GENERATED
/* INSTRUCTIONS
 *
 * Complete the exercises below.  For each "EXERCISE" comment, add code
 * immediately below the comment.
 *
 * Please see README.md for instructions, including compilation and testing.
 * See fp2tests.scala for examples of the expected behavior.  Note that the
 * tests are not exhaustive -- your code may still be incorrect even if all
 * tests pass.  But passing the tests is a good sign that you are on the right
 * track.
 *
 * GRADING
 *
 * 1. Submissions MUST compile using SBT with UNCHANGED configuration and tests
 *    with no compilation errors.  Submissions with compilation errors will
 *    receive 0 points.  Note that refactoring the code will cause the tests to
 *    fail.
 *
 * 2. You MUST NOT edit the SBT configuration and tests.  Altering it in your
 *    submission will result in 0 points for this assignment.
 *
 * 3. You MUST NOT use while loops or (re)assignment to variables (you can use
 *    "val" declarations, but not "var" declarations).  You must use recursion
 *    instead.  You may declare auxiliary functions if you like.
 *
 * 4. You MUST NOT alter any of the provided code, except for the parts explicitly
 *    marked ???.  You may ADD methods (including a main method, if you like).
 *    But don't change the signature of provided functions, or remove them.
 *
 * SUBMISSION
 *
 * 1. Submit this file on D2L before the deadline.
 *
 * 2. Late submissions will not be permitted.
 *
 * 3. You may submit multiple times.  I will grade the LAST submission.
 *
 */

import java.util.NoSuchElementException
object fp2:

  // Feel free to copy the log function from the fp1.

  // EXERCISE 1: complete the following recursive definition of a "map"
  // function for Scala's builtin List type.  You must not use the builtin
  // "map" method.
  //
  // Your implementation of "map" MUST be recursive.
  def map[A, B](xs: List[A], f: A => B): List[B] =
    xs match
      case Nil     => Nil
      case x :: xt => f(x) :: map(xt, f)

  // EXERCISE 2: complete the following recursive definition of a "filter"
  // function for Scala's builtin List type.  You must not use the builtin
  // "filter" method.
  //
  // Your implementation of "filter" MUST be recursive.
  def filter[A](xs: List[A], f: A => Boolean): List[A] =
    xs match
      case Nil => Nil
      case x :: xt =>
        if f(x) then x :: filter(xt, f)
        else filter(xt, f)

  // EXERCISE 3: complete the following recursive definition of an "append"
  // function for Scala's builtin List type.  You must not use the builtin
  // ":::" method.
  //
  // Your implementation of "append" MUST be recursive.
  //
  // HINT: use "::" in the body of the cons-cell case.
  def append[A](xs: List[A], ys: List[A]): List[A] =
    xs match
      case Nil     => ys
      case x :: xt => x :: append(xt, ys)

  // EXERCISE 4: complete the following recursive definition of a "flatten"
  // function for Scala's builtin List type.  You must not use the builtin
  // "flatten" method.
  //
  // Your implementation of "flatten" MUST be recursive.
  //
  // HINT: use either ":::" or your definition of "append" in the body of the
  // cons-cell case.
  //
  // EXAMPLE:
  // - flatten (List ((1 to 5).toList, (6 to 10).toList, (11 to 15).toList)) == (1 to 15).toList
  def flatten[A](xss: List[List[A]]): List[A] =
    xss match
      case Nil       => Nil
      case xs :: xtt => xs ::: flatten(xtt)

  // EXERCISE 5: complete the following recursive definition of a "foldLeft"
  // function for Scala's builtin list type.  You must not use the builtin
  // "foldLeft" method.
  //
  // Your implementation of "foldLeft" MUST be recursive.
  //
  // HINT:   foldLeft (  Nil, z, f) == z
  //         foldLeft (y::ys, z, f) == foldLeft (ys, f (z, y), f)
  def foldLeft[A, B](xs: List[A], z: B, f: (B, A) => B): B =
    xs match
      case Nil     => z
      case x :: xt => foldLeft(xt, f(z, x), f)

  // EXERCISE 6: complete the following recursive definition of a "foldRight"
  // function for Scala's builtin list type.  You must not use the builtin
  // "foldRight" method.
  //
  // Your implementation of "foldRight" MUST be recursive.
  //
  // HINT:   foldRight (  Nil, z, f) == e
  //         foldRight (y::ys, z, f) == f (y, foldRight (ys, z, f))
  def foldRight[A, B](xs: List[A], z: B, f: (A, B) => B): B =
    xs match
      case Nil     => z
      case x :: xt => f(x, foldRight(xt, z, f))

  // EXERCISE 7: complete the following definition of a "joinTerminateRight"
  // function to take a list of strings "xs" and concatenate all strings
  // using a string "term" as a terminator (not delimiter) between strings.
  //
  // You MUST use your foldRight defined above.
  //
  // You MAY NOT use recursion.
  //
  // EXAMPLES:
  // - joinTerminateRight (Nil, ";") == ""
  // - joinTerminateRight (List ("a"), ";") == "a;"
  // - joinTerminateRight (List ("a","b","c","d"), ";") == "a;b;c;d;"
  def joinTerminateRight(xs: List[String], term: String): String =
    foldRight(xs, "", (x, z) => x + term + z)

  // EXERCISE 8: complete the following definition of a "joinTerminateLeft"
  // function to take a list of strings "xs" and concatenate all strings
  // using a string "term" as a terminator (not delimiter) between strings.
  //
  // You MUST use your foldLeft defined above.
  //
  // You MAY NOT use recursion.
  //
  // EXAMPLES:
  // - joinTerminateLeft (Nil, ";") == ""
  // - joinTerminateLeft (List ("a"), ";") == "a;"
  // - joinTerminateLeft (List ("a","b","c","d"), ";") == "a;b;c;d;"
  def joinTerminateLeft(xs: List[String], term: String): String =
    foldLeft(xs, "", (z, x) => z + x + term)

  // EXERCISE 9: complete the following recursive definition of a
  // "firstNumGreaterOrEqual" function to find the first number greater than or
  // equal to "a" in a list of integers "xs".
  //
  // If the list is empty or there is no number greater than or equal to "a",
  // throw a java.util.NoSuchElementException (with no argument).
  //
  // Your implementation of "firstNumGreaterOrEqual" MUST be recursive.
  //
  // EXAMPLES:
  // - firstNumGreaterOrEqual (5, List (4, 6, 8, 5)) == 6
  def firstNumGreaterOrEqual(a: Int, xs: List[Int]): Int =
    xs match
      case Nil => throw new java.util.NoSuchElementException
      case x :: xt =>
        if x >= a then x
        else firstNumGreaterOrEqual(a, xt)

  // EXERCISE 10: complete the following recursive definition of a
  // "firstIndexNumGreaterOrEqual" function to find the index (position) of the
  // first number greater than or equal to "a" in a list of integers "xs".
  //
  // The first index should be zero (not one).
  //
  // If the list is empty or there is no number greater than or equal to "a",
  // throw a java.util.NoSuchElementException (with no argument).
  //
  // Your implementation of "firstIndexNumGreaterOrEqual" MUST be recursive.
  //
  // EXAMPLES:
  // - firstIndexNumGreaterOrEqual (5, List (4, 6, 8, 5)) == 1
  //
  // HINT: this is a bit easier to write if you use an auxiliary function.
  def firstIndexNumGreaterOrEqual(a: Int, xs: List[Int]): Int =
    def firstIndex(xs: List[Int], z: Int): Int =
      xs match
        case Nil => throw new java.util.NoSuchElementException
        case x :: xt =>
          if x >= a then z
          else firstIndex(xt, z + 1)
    firstIndex(xs, 0)
