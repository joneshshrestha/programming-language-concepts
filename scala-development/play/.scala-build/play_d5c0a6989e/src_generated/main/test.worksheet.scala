

final class test$u002Eworksheet$_ {
def args = test$u002Eworksheet_sc.args$
def scriptPath = """test.worksheet.sc"""
/*<script>*/
// This file is a scala worksheet.
// If you load it in vscode with metals, you will get output generated automatically

val x = 2
x * x
val f = (_: Int) + 3
f(5)
val ps = List(11 -> "a", 21 -> "b", 31 -> "c")
ps filter ((k, v) => k > 12)

/*</script>*/ /*<generated>*//*</generated>*/
}

object test$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new test$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export test$u002Eworksheet_sc.script as `test.worksheet`

