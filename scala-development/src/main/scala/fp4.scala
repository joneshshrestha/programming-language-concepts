  // GENERATED
/* INSTRUCTIONS
 *
 * Complete the exercises below.  For each "EXERCISE" comment, add code
 * immediately below the comment.
 *
 * Please see README.md for instructions, including compilation and testing.
 * See fp3tests.scala for examples of the expected behavior.  Note that the 
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
 * 3. You MUST NOT use while loops. You must use recursion
 *    instead.  You may declare auxiliary functions if you like. This assignment
 *    requires mutable state, so you MAY use "var" declarations.
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

object fp4:

  // Feel free to copy the log function from the fp1.
  
  // EXERCISE 1: Complete the following definition, so that "constant5" is a
  // function that returns 5 whenever it is invoked.
  val constant5: () => Int =
    // TODO: Replace ??? your answer.
    () => ???

  // EXERCISE 2: Complete the following definition, so that "constant" is a
  // function that when invoked with integer n returns a function that
  // returns n whenever it is invoked.
  val constant: Int => () => Int =
    // TODO: Replace ??? your answer.
    (n: Int) => ???

  // EXERCISE 3: Complete the following definition, so that "counter0" is a
  // (stateful) function that returns 0 when it is first invoked, then 1,
  // then 2, etc.
  //
  // REMEMBER: you can use "var" but everything you add has to be inside the
  // "{...}" body of "counter0".

  // This rule applies throughout this assignment.
  val counter0: () => Int =
    // TODO: Replace ??? your answer.
    () => ???

  // EXERCISE 4: Complete the following definition, so that "counter" is a
  // (stateless) function that when invoked with integer n returns a
  // (stateful) function that returns n when it is first invoked, then n+1,
  // then n+2, etc.
  //
  // The counters must be independent, i.e., running "counter (0)" twice
  // should yield two functions that do not interfere with one another's
  // state.
  val counter: Int => () => Int =
    // TODO: Replace ??? your answer.
    (n: Int) => ???

  // EXERCISE 5: Complete the following definition, so that "getAndSet" is a
  // (stateless) function that when invoked with integer n returns a pair of
  // functions (that share state) that allow reading and writing a var that
  // is initialized with integer n.
  //
  // The first function in the pair should be the reader.  The second
  // function in the pair should be the writer.
  //
  // For example, the following expression should return 10:
  // { val (get, set) = getAndSet (5); set (10); get () }
  //
  // Multiple calls to "getAndSet" should yield independent pairs, i.e., the
  // first pair returned should not share any state with the second pair
  // returned.
  val getAndSet: Int => (() => Int, Int => Unit) =
    // TODO: Replace ??? your answer.
    (n: Int) => ???

  // EXERCISE 6: Complete the following definition, so that "getAndSetSpy" is
  // a (stateful) function that when invoked it returns a pair.
  //
  // The second component of the pair should behave like "getAndSet" above
  // (with the exception noted next).
  //
  // The first component of the pair is a function that, when invoked,
  // returns the total number of times that a "set" call has been made.
  //
  // That number should cover all calls to "set" made in all pairs created
  // via "getAndSetSpy".  That is, the total number is a piece of state
  // that is shared all "set" functions created via "getAndSetSpy".
  //
  // For example:
  // val (spy1, getAndSet1) = getAndSetSpy ()
  // val (spy2, getAndSet2) = getAndSetSpy ()
  // val (get1a, set1a) = getAndSet1 (0)
  // val (get2a, set2a) = getAndSet2 (0)
  // set1a(10)
  // set2a(20)
  // spy1()
  //   val res1: Int = 2
  //
  // The result is 2, not 1.
  //
  val getAndSetSpy: () => (() => Int, Int => (() => Int, Int => Unit)) =
    // TODO: Replace ??? your answer.
    () => ???


  class RefInt(initial: Int):
    private var n: Int = initial
    def get(): Int = n
    def set(m: Int): Unit = { n = m }

  // EXERCISE 7: complete the following higher-order function.  It has one
  // parameter f: a function that takes an instance of RefInt (see above for
  // the definition of the class RefInt) and returns Unit (i.e., nothing
  // interesting).
  //
  // Your code must create ONLY ONE instance of RefInt, then call f three times.
  // f will update the integer stored in the instances of RefInt it is given.
  //
  // Your code must return a tuple of the three integers provided by f in the
  // order that they came back from calls, i.e., the integer from the first
  // call to f is the first integer in the returned tuple.
  def refint1(f: RefInt => Unit): (Int, Int, Int) =
    // TODO: Replace ??? your answer.
    // Example call:
    // val r = RefInt (0)
    // f (r)
    // val n : Int = r.get()
    ???

  // EXERCISE 8: complete the following higher-order function.  It has one
  // parameter f: a function that takes an instance of RefInt (see above for
  // the definition of the class RefInt) and returns Unit (i.e., nothing
  // interesting).
  //
  // Your code must create EXACTLY THREE instances of RefInt, then call f
  // three times.  f will update the integer stored in the instances of
  // RefInt it is given.  However, f will not do this update immediately.  It
  // will only do it after the third call to f: at that point it updates all
  // three instances of RefInt that it has received as arguments so far.
  //
  // Your code must return a tuple of the three integers provided by f in the
  // order that they came back from calls, i.e., the integer from the first
  // call to f is the first integer in the returned tuple.
  def refint2(f: RefInt => Unit): (Int, Int, Int) =
    // TODO: Replace ??? your answer.
    ???

  // EXERCISE 9: complete the following function.  It has one parameter r: (a
  // reference to) an instance of RefInt (see above for the definition of the
  // class RefInt) and returns (a reference to) an instance of RefInt.
  //
  // Your code must increment (add 1 to) the RefInt it receives and return
  // double the original value (stored in a separate RefInt instance) as the
  // result.
  def refint3(r: RefInt): RefInt =
    // TODO: Replace ??? your answer.
    ???

  // EXERCISE 10: complete the following function.
  // It has two parameters
  // - r: (a reference to) an instance of RefInt (see above for the
  //      definition of the class RefInt); AND
  // - f: a function that accepts (a reference to) an instance of RefInt.
  //
  // Your code must call f with a *copy* of the RefInt r, i.e., it must make
  // a new instance of RefInt with the same Int.
  //
  // Your code should return true if f has NOT changed the Int stored in the
  // copy of r.  Otherwise it should return false.
  def refint4(r: RefInt, f: RefInt => Unit): Boolean =
    // TODO: Replace ??? your answer.
    ???
