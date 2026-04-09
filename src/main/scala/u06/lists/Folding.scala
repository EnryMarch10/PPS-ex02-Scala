package u06.lists

import scala.annotation.tailrec

object Folding:

  // List as a pure interface
  enum List[A]:
    case ::(h: A, t: List[A])
    case Nil()
    def ::(h: A): List[A] = List.::(h, this)

    // foldLeft capturing left-to-right accumulation, typical of reductions
    @tailrec final def foldLeft[B](init: B)(f: (B, A) => B): B = this match
      case h :: t => t.foldLeft(f(init, h))(f)
      case _ => init

    def size(init: Int = 0): Int = foldLeft(init)((acc, _) => acc + 1)

    override def toString: String = foldLeft("|")((acc, h) => acc + h.toString + "|")

    // foldRight capturing right-to-left construction
    def foldRight[B](init: B)(op: (A, B) => B): B = this match
      case h :: t => op(h, t.foldRight(init)(op))
      case _ => init

    def map[B](f: A => B): List[B] = foldRight(Nil())(f(_) :: _)

    def concat(l: List[A]): List[A] = foldRight(l)(_ :: _)

    // right-to-left construction with tail recursion, needs reverse
    def reverse: List[A] = foldLeft(Nil[A]())((acc, h) => h :: acc)

    def mapTail[B](f: A => B): List[B] =
      foldLeft(Nil[B]())((acc, h) => f(h) :: acc).reverse

  // Factories
  object List:
    def apply[A](elems: A*): List[A] =
      var list: List[A] = Nil()
      for e <- elems.reverse do list = e :: list
      list

  // Factories
  @main def play =
    val l = List(10, 20, 31, 40, 50)
    println(l.size())
    println(l.toString)
    println(l.reverse)
    println(l.mapTail(_ + 1))
    println(l.map(_ + 1))
    println(l.concat(l))
    println(l.foldLeft(0)((b, a) => b + a))
    println(l.foldLeft(false)((b, a) => b || a == 30))
    

end Folding
