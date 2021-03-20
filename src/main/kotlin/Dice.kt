import kotlin.random.Random

class Dice {
    var number: Int
    var locked: Boolean

    init {
        this.number = Random.nextInt(1, 6)
        this.locked = false;
    }

    fun roleDice() {
        this.number = Random.nextInt(1, 6)
    }

    fun lockDice() {
        this.locked = true
    }

    fun unlockDice() {
        this.locked = false
    }

    fun isLocked() = this.locked

    fun checkValue() = this.number
}
