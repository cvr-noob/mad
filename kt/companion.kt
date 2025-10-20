class Person private constructor(var name: String, age: Int) {
    var age: Int = age
        get() = field
        set(value) {
            field = if (value >= 0) value else 0
        }

    companion object {
        fun create(name: String, age: Int): Person = Person(name, age)
    }

    fun show() = println("Person($name, $age)")
}

fun main() {
    val p = Person.create("John", 32)
    p.show()
    p.age = -5
    p.show()
}
