import org.scalatest.*
import org.scalatest.prop.TableDrivenPropertyChecks.*

class fp1tests extends UnitSpec:
  val EX : Map[Int, Tag] =
    (for i <- (1 to 10).toList yield {
      object T extends Tag ("fp1ex%02d".format (i))
      (i, T)
    }).toMap

  import fp1.*

  property ("EX01 - factTest", EX (1)) {
    assert (factTest === List (1, 2, 6, 24, 120))
  }

  property ("EX02 - fib", EX (2)) {
    val fibTable = Table (
      ("n", "fib (n)"),
      ( 0,  0),
      ( 1,  1),
      ( 2,  1),
      ( 3,  2),
      ( 4,  3),
      ( 5,  5),
      ( 6,  8),
      ( 7, 13),
      ( 8, 21),
      ( 9, 34),
      (10, 55),
      (11, 89)
    )
    forAll (fibTable) { (n : Int, res : Int) =>
      assert (fib (n) ===  res)
    }
  }

  val sumTable = Table (
    ("xs", "sum (xs)"),
    (Nil,  0),
    (List (15),  15),
    ((0 to 100).toList,  5050)
  )

  property ("EX03 - sum", EX (3)) {
    forAll (sumTable) { (xs : List[Int], res : Int) =>
      assert (sum (xs) ===  res)
    }
  }

  property ("EX04 - sumTail", EX (4)) {
    forAll (sumTable) { (xs : List[Int], res : Int) =>
      assert (sumTail (xs) ===  res)
    }
  }

  val maxTable = Table (
    ("xs", "max (xs)"),
    (List (15),  15),
    ((0 to 100).toList,  100),
    ((0 to 100).toList.reverse,  100),
    ((0 to 50).toList ::: ((30 to 70).toList.reverse),  70)
  )
  val maxEmptyTable = Table (
    ("xs"),
    Nil
  )

  property ("EX05 - maxList", EX (5)) {
    forAll (maxTable) { (xs : List[Int], res : Int) =>
      assert (maxList (xs) ===  res)
    }
    forAll (maxEmptyTable) { (xs : List[Int]) =>
      a [NoSuchElementException] `should` be thrownBy { maxList(xs) }
    }
  }


  property ("EX06 - maxTailAux", EX (6)) {
    forAll (maxTable) { (xs : List[Int], res : Int) =>
      assert (maxTail (xs) ===  res)
    }
    forAll (maxEmptyTable) { (xs : List[Int]) =>
      a [NoSuchElementException] `should` be thrownBy { maxTail(xs) }
    }
  }

  property ("EX07 - zip", EX (7)) {
    val zipTable = Table (
      ("xs", "ys", "zip (xs, ys)"),
      (List (1, 2, 3), List ("a", "b", "c"), List ((1, "a"), (2, "b"), (3, "c"))),
      (List (1, 2, 3), List ("a", "b"), List ((1, "a"), (2, "b"))),
      (List (1, 2), List ("a", "b", "c"), List ((1, "a"), (2, "b"))),
      (Nil, Nil, Nil)
    )
    forAll (zipTable) { (xs : List[Int], ys : List[String], res : List[(Int, String)]) =>
      assert (zip (xs, ys) ===  res)
    }
  }

  property ("EX08 - insert", EX (8)) {
    val insertTable = Table (
      ("x", "xs", "insert (x, xs)"),
      ( 5, Nil, List (5)),
      ( 5, List (1, 2, 3), List (1, 2, 3, 5)),
      ( 5, List (5, 5, 5), List (5, 5, 5, 5)),
      ( 5, List (1, 2, 3, 4), List (1, 2, 3, 4, 5)),
      ( 5, List (6, 7, 8, 9), List (5, 6, 7, 8, 9))
    )
    forAll (insertTable) { (x : Int, xs : List[Int], res : List[Int]) =>
      assert (insert (x, xs) ===  res)
    }
  }

  property ("EX09 - merge", EX (9)) {
    val mergeTable = Table (
      ("xs", "ys", "merge (xs, ys)"),
      (Nil, Nil, Nil),
      (Nil, List (1, 2, 3), List (1, 2, 3)),
      (List (1, 2, 3), Nil, List (1, 2, 3)),
      (List (1, 2, 3), List (4, 5, 6), List (1, 2, 3, 4, 5, 6)),
      (List (4, 5, 6), List (1, 2, 3), List (1, 2, 3, 4, 5, 6)),
      (List (1, 3, 5), List (2, 4, 6), List (1, 2, 3, 4, 5, 6)),
      (List (2, 4, 6), List (1, 3, 5), List (1, 2, 3, 4, 5, 6))
    )
    forAll (mergeTable) { (xs : List[Int], ys : List[Int], res : List[Int]) =>
      assert (merge (xs, ys) ===  res)
    }
  }

  property ("EX10 - reverseTail", EX (10)) {
    val reverseTable = Table (
      ("xs", "reverseTail (xs)"),
      (Nil, Nil),
      (List (1), List (1)),
      (List (1, 2, 7, 3), List (3, 7, 2, 1)),
      ((1 to 100).toList, (100 to 1 by -1).toList)
    )
    forAll (reverseTable) { (xs : List[Int], res : List[Int]) =>
      assert (reverseTail (xs) ===  res)
    }
  }
