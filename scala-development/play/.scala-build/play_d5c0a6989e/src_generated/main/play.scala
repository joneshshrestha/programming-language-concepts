

final class play$_ {
def args = play_sc.args$
def scriptPath = """play.sc"""
/*<script>*/
// The src directory is meant for code that will be run with automated tests.
// Put other code in this directory.
//
// sbt requires that all files in src/main/scala must compile.
// That can be a pain when you want to experiment.
//
// In the scala console, you can load this file by typing
//    scala> :load play/README.scala
//    scala> length1(xs)
// 
val xs = List(11, 21, 31)
val xss = List(List(11, 21), List(), List(31), List(41, 51, 61))

def log[X](prefix: String, d:Int=0)(computeResult: => X) =
  val indent = "  " * d
  println(s"${indent}${prefix}")
  val result = computeResult
  println(s"${indent}${prefix} : ${result}")
  result

// This is the length function from the first lecture on scala, with logging
// This version is right recursive, computing the operator with the RESULT of
// recursive call.
def length1[X](xs:List[X], d:Int = 0): Int =
  log(s"length($xs)", d):
    xs match
      case Nil     => 0
      case _ :: xt => 1 + length1(xt, d + 1)

// Here is a version that recurs into the parameter instead of the result. This
// version is left recursive, AKA tail recursive, computing the operator into a
// PARAMETER of the recursive call.
//
// This version also uses the optional parameter d to indicate the call depth.
def length2[X](xs:List[X], accumulator:Int = 0, d:Int = 0): Int = 
  log(s"length($xs, $accumulator)", d):
    xs match
      case Nil     => accumulator
      case _ :: xt => length2(xt, 1 + accumulator, d + 1)

// Try this:
//    scala> :load play/play.sc
//    scala> length1(xs)
//    scala> length2(xs)
// Try changing length1 to use a depth parameter for indentation.


// End of file
/*</script>*/ /*<generated>*//*</generated>*/
}

object play_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new play$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export play_sc.script as `play`

