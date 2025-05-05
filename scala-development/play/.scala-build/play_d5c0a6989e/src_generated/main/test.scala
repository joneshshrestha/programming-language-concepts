

final class test$_ {
def args = test_sc.args$
def scriptPath = """test.sc"""
/*<script>*/
def printCounterAux(xs: List[String], counter: Int): Unit =
  xs match
    case Nil => ()
    case x :: xt =>
      println(s"[00$counter] $x")
      printCounterAux(xt, counter + 1)

def printCounter(xs: List[String]): Unit =
  printCounterAux(xs, 1)

/*</script>*/ /*<generated>*//*</generated>*/
}

object test_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new test$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export test_sc.script as `test`

