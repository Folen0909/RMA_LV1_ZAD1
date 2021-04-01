class Game {

    var roles = 3
    val hand = Hand()

    fun seeHand() = this.hand.hand.forEachIndexed { index, dice ->
        println("Dice ${index + 1}: ${dice.number}, locked: ${hand.locked[index]}") }

    fun roleHand() {
        roles--
        this.hand.roleHand()
    }

    fun checkHand() = println(this.hand.checkHand())


    fun isOver() = roles == 0

}