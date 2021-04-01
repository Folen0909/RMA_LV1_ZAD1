import kotlin.random.Random

class Dice {
    var number: Int = Random.nextInt(1, 7)

    fun roleDice() {
        this.number = Random.nextInt(1, 7)
    }
}
