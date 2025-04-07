file://<WORKSPACE>/scala-development/play/experiment.scala
### java.lang.IndexOutOfBoundsException: 0

occurred in the presentation compiler.

presentation compiler configuration:


action parameters:
offset: 4293
uri: file://<WORKSPACE>/scala-development/play/experiment.scala
text:
```scala
import java.util.NoSuchElementException
object fp1:

  // Here is a utility function for logging recursive functions.
  // It may be helpful while debugging.
  var doLog = true
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
  val factTest: List[Int] = (for (i <- 1 to 5) yield fact(i)).toList

  // EXERCISE 2: complete the following definition of the Fibonacci function.
  // You can use the mathematical definition of Fib:
  // https://en.wikipedia.org/wiki/Fibonacci_number
  //
  // fib(0) == 0
  // fib(1) == 1
  // fib(n) == fib(n-1) + fib(n-2), if n>1
  def fib(n: Int): Int = {
    n match
      case 0          => 0
      case 1          => 1
      case n if n > 1 => fib(n - 1) + fib(n - 2)
  }

  // EXERCISE 3: write a function "sum" that takes a list of integers and
  // sums them.  If the list is empty, the sum is zero.
  def sum(xs: List[Int]): Int = {
    xs match
      case Nil     => 0
      case y :: ys => y + sum(ys)
  }

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
    sumTailAux(xs, 0)

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
    xs match
      case Nil     => throw new java.util.NoSuchElementException
      case y :: ys => 
        case Nil => y
        case _@@y max (maxList(ys))

```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:131)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.pc.InterCompletionType$.inferType(InferExpectedType.scala:98)
	dotty.tools.pc.InterCompletionType$.inferType(InferExpectedType.scala:66)
	dotty.tools.pc.completions.Completions.advancedCompletions(Completions.scala:523)
	dotty.tools.pc.completions.Completions.completions(Completions.scala:122)
	dotty.tools.pc.completions.CompletionProvider.completions(CompletionProvider.scala:139)
	dotty.tools.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:150)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 0