error id: 
file://<WORKSPACE>/scala-development/src/main/scala/fp1.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 338
uri: file://<WORKSPACE>/scala-development/src/main/scala/fp1.scala
text:
```scala
// GENERATED
/* INSTRUCTIONS
 *
 * Complete the exercises below.  For each "EXERCISE" comment, add code
 * immediately below the comment.
 *
 * Please see README.md for instructions, including compilation and testing.
 * See fp1tests.scala for examples of the expected behavior.  Note that the
 * tests are not exhaustive -- your code may@@ still be incorrect even if all
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
object fp1:

  // Here is a utility function for logging recursive functions.
  // It may be helpful while debugging.
  var doLog = false
  def log[X](prefix: String, d: Int = 0)(computeResult: => X) =
    if doLog then
      val indent = "  " * d
      println(s"${indent}${prefix}")
      val result = computeResult
      println(s"${indent}${prefix} : ${result}")
      result
    else computeResult
  // Note: computeResult is a "by-name" parameter.  We will discuss these
  // later in the course.  Short version: a by-name parameter is non-strict;
  // it is reevaluated every time it is used in the function body.

  // EXAMPLE: here is the definition of the factorial function.
  def fact(n: Int): Int =
    if n <= 1 then 1
    else n * fact(n - 1)

  // EXAMPLE: factorial with logging
  def factLog(n: Int): Int =
    log(s"fact($n)"):
      if n <= 1 then 1
      else n * factLog(n - 1)

  // EXAMPLE: factorial with indented logging
  def factLogIndent(n: Int, d: Int = 0): Int =
    log(s"fact($n)", d):
      if n <= 1 then 1
      else n * factLogIndent(n - 1, d + 1)

  // Note that the fact computes as follows (leaving out some steps):
  //
  // fact (5)
  // --> if 5 <= 1 then 1 else 5 * fact (5 - 1)
  // --> if false then 1 else 5 * fact (5 - 1)
  // --> 5 * fact (5 - 1)
  // --> 5 * fact (4)
  // --> 5 * (if 4 <= 1 then 1 else 4 * fact (4 - 1))
  // --> 5 * (4 * fact (3))
  // --> 5 * (4 * (3 * fact (2))
  // --> 5 * (4 * (3 * (2 * fact (1)))
  // --> 5 * (4 * (3 * (2 * (if 1 <= 1 then 1 else 1 * fact (1 - 1)))))
  // --> 5 * (4 * (3 * (2 * (if true then 1 else 1 * fact (1 - 1)))))
  // --> 5 * (4 * (3 * (2 * 1)))
  // --> 5 * (4 * (3 * 2))
  // --> 5 * (4 * 6)
  // --> 5 * 24
  // --> 120
  //
  // We can get the same answer with less work by starting at the base case and
  // computing up:
  //
  // fact (1) --> 1
  // fact (2) --> 2 * fact (1) --> 2 * 1 --> 2
  // fact (3) --> 3 * fact (2) --> 3 * 2 --> 6
  // fact (4) --> 4 * fact (3) --> 4 * 6 --> 24
  // fact (5) --> 5 * fact (4) --> 5 * 24 --> 120

  // EXERCISE 1: complete the following definition, so that factTest is the list
  // of integers List(1,2,6,24,120).
  //
  // You must call the "fact" function (five times) defined above instead of
  // hardcoding the numbers 1,2,6,24,120.
  val factTest: List[Int] =
    // TODO: Replace Nil your answer.
    Nil

  // EXERCISE 2: complete the following definition of the Fibonacci function.
  // You can use the mathematical definition of Fib:
  // https://en.wikipedia.org/wiki/Fibonacci_number
  //
  // fib(0) == 0
  // fib(1) == 1
  // fib(n) == fib(n-1) + fib(n-2), if n>1
  def fib(n: Int): Int =
    // TODO: Replace ??? your answer.
    ???

  // EXERCISE 3: write a function "sum" that takes a list of integers and
  // sums them.  If the list is empty, the sum is zero.
  def sum(xs: List[Int]): Int =
    // TODO: Replace ??? your answer.
    ???

  // EXERCISE 4: given the definition of the function "sumTailAux" below,
  // complete the definition of the function "sumTail" so that it also sums a
  // list of integers.  The parameter "z" is an accumulator, that keeps track
  // of the sum of the elements seen so far.
  //
  // You must not alter the definition of "sumTailAux".
  //
  // Your definition for "sumTail" must call "sumTailAux" directly, and must
  // not call "sum"
  def sumTailAux(xs: List[Int], z: Int): Int =
    // log(s"sumTailAux($xs, $z)"):
    xs match
      case Nil     => z
      case x :: xt => sumTailAux(xt, z + x)

  def sumTail(xs: List[Int]): Int =
    // TODO: Replace ??? your answer.
    ???

  // EXERCISE 5: complete the following definition of the function "max" that
  // finds the maximum integer in a list of integers.
  //
  // If the list is empty, throw a java.util.NoSuchElementException (with no
  // argument).
  //
  // You MUST NOT use the "max" method on lists, but can use the "max" method
  // on integers: That is, you cannot use (xs.max) or similar.  But you can
  // use (1 max 2).
  def maxList(xs: List[Int]): Int =
    // TODO: Replace ??? your answer.
    ???

  // EXERCISE 6: given the definition of the function "maxTail" below,
  // complete the definition of the function "maxTailAux" so that "maxTail"
  // also finds the maximum of a list of integers.
  //
  // You must not alter the definition of "maxTail".
  def maxTailAux(xs: List[Int], z: Int): Int =
    // TODO: Replace ??? your answer.
    ???

  def maxTail(xs: List[Int]): Int =
    xs match
      case Nil     => throw NoSuchElementException()
      case x :: xt => maxTailAux(xt, x)

  // EXERCISE 7: Write a function "zip" that takes two lists and creates a new
  // list by pairing up elements from the two input lists.  If one input list
  // is longer than the other, the extra elements should be ignored.
  def zip(xs: List[Int], ys: List[String]): List[(Int, String)] =
    // TODO: Replace ??? your answer.
    ???

  // EXERCISE 8: Write a function "insert" that takes an integer "i" and a
  // list of integers "xs", and returns a new list with "i" inserted into "xs".
  // Assume that "xs" is sorted in increasing order.  The resulting list
  // should also be sorted in increasing order.
  def insert(i: Int, xs: List[Int]): List[Int] =
    // TODO: Replace ??? your answer.
    ???

  // EXERCISE 9: Write a function "merge" that takes two lists of integers
  // that are sorted in increasing order, and returns a new list that merges
  // the two lists into a single list that is sorted in increasing order.
  def merge(xs: List[Int], ys: List[Int]): List[Int] =
    // TODO: Replace ??? your answer.
    ???

  // EXERCISE 10: given the definition of the function "reverseTail" below,
  // complete the definition of the function "reverseTailAux" so that "reverseTail"
  // returns the reverse of xs.
  //
  // You must not alter the definition of "reverseTail".
  def reverseTailAux(xs: List[Int], zs: List[Int]): List[Int] =
    // TODO: Replace ??? your answer.
    ???

  def reverseTail(xs: List[Int]) =
    reverseTailAux(xs, Nil)

```


#### Short summary: 

empty definition using pc, found symbol in pc: 