package u05

object CountersScala3:
  trait Counter:
    def increment(): Unit
    def value: Int

  class CounterImpl extends Counter:
    private var v: Int = 0
    override def increment(): Unit = v = v + 1
    override def value: Int = v

  @main def tryCounters() = 
    val counter: Counter = new CounterImpl  // "()" typically always optional
    counter.increment()
    counter.increment()
    counter.increment()
    println("Result is " + counter.value) // 3
