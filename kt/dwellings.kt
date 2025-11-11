import kotlin.math.PI

open class Dwelling(val capacity: Int) {
    open fun floorArea(): Double = 0.0
    fun capacity() = capacity
}

open class RoundHut(val radius: Double, capacity: Int): Dwelling(capacity) {
    override fun floorArea(): Double = PI * radius * radius
}

class SquareCabin(val side: Double, capacity: Int): Dwelling(capacity) {
    override fun floorArea(): Double = side * side
}

class RoundTower(val floors: Int, radius: Double, capacity: Int): RoundHut(radius, capacity) {
    override fun floorArea(): Double = super.floorArea() * floors
}

fun main() {
    val hut = RoundHut(2.0, 3)
    val cabin = SquareCabin(4.0, 4)
    val tower = RoundTower(4, 2.5, 3)

    println("Hut area: ${hut.floorArea()}")
    println("Cabin area: ${cabin.floorArea()}")
    println("Tower area: ${tower.floorArea()}")
}
