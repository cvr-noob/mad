fun greet(name: String = "Boss") = println("Hello $name!")

fun main() {
    print("Enter name: ")
    greet(readln())
}
