package u05

object Apply:

  // another, important application: factories hiding implementation
  trait Person:
    def name: String
    def surname: String

  object Person: // the companion object of trait/class Person
    def apply(name: String, surname: String): Person =
      PersonImpl(name,surname)

    private class PersonImpl(override val name: String,
                             override val surname:String) extends Person:
      assert(name != null && surname != null)

  @main def showcase =
    // Showcasing apply
    val p: Person = Person("mario", "rossi")  // Hiding PersonImpl
    println(s"$p, $p.name, $p.surname")
