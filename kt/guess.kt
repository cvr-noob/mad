fun main() {
    val ans = Random.nextInt(1, 101)

    var n: Int = -1
    while (n != ans) {
        n = readln().toInt()
        if (n < ans) {
            println("Too low!")
        } else if (n > ans) {
            println("Too high!")
        }
    }

    println("Correct!")
}
