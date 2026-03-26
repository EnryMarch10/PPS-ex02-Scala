package u05

class Lamp(on: Boolean):  // a class with two constructors

  private var state: Boolean = on
  private val firstUse: java.util.Date = new java.util.Date()

  // floating code is executed as part of the primary constructor
  println("primary constr. of: " + this)

  // auxiliary constructor, necessarily calling the primary one
  def this() = 
    this(false)
    println("auxiliary constr. of: "+this)

  def isOn: Boolean = state

  def switchOn(): Unit = state = true

  def switchOff(): Unit = state = false

  override def toString(): String =
    s"Lamp {state} first use {firstUse}; identity {super.toString}"

@main def tryLamp =
  println("starting..")
  val v = new Lamp(false)
  println(v)
  println(v.isOn) // omitting () at the call site, for getters
  v.switchOn()
  println(v.isOn)

  val v2 = new Lamp(true)
  println(v2.isOn)
  val v3 = new Lamp  // omitting () at the call site, for constructors
  println(v3.isOn)

  val v4 = new JLamp  // Java interoperability
  println(v4.isOn)
