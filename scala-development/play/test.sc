def printCounterAux(xs: List[String], counter: Int): Unit =
  xs match
    case Nil => ()
    case x :: xt =>
      println(s"[00$counter] $x")
      printCounterAux(xt, counter + 1)

def printCounter(xs: List[String]): Unit =
  printCounterAux(xs, 1)
