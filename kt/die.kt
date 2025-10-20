import kotlin.random.Random

class Die(private val sides: Int = 6) {
    fun roll() = Random.nextInt(1, sides + 1)
}

fun main() {
    val die = Die()
    println("You rolled: ${die.roll()}")
}
