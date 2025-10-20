fun main() {
    print("Enter a number: ")
    val a: Int? = readln().toIntOrNull()
    if (a == null)
        println("Input is null")
    else
        println(a * a)
}
