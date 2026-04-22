package u07.exports

object Exports extends App:

  trait Counter:
    def value: Int
    def increment(): Unit

  class BasicCounter extends Counter:
    private[Exports] var counterValue = 0
    def value: Int = counterValue
    def increment(): Unit = counterValue = counterValue + 1
    def reset(): Unit = counterValue = 0

  class MultiCounter extends Counter: // no inheritance, just substitutability
    private val counter = new BasicCounter() // no inheritance, just delegation
    export counter.*  // export value, increment, reset
    def decrement(): Unit = counterValue -= 1

  class FancyCounter extends Counter: // no inheritance, just substitutability
    private val counter = new BasicCounter() // no inheritance, just delegation
    private val initDate = java.util.Calendar.getInstance();
    export counter.{reset as _, *}  // export all but reset
    export initDate.getTime as creationTime // export with alias
    //def creationTime(): String = initDate.toString

  val c: Counter = new FancyCounter() // no inheritance, just substitutability
  println(c.value)
  println(c.increment())
  val c2 = new FancyCounter()
  // println(c2.decrement()) // won't work
  println(c2.creationTime())