import checker.*

class Hand {
    var hand = mutableListOf<Dice>()
    var locked = mutableListOf<Boolean>()
    var handCheckers = mutableListOf<HandChecker>()

    init {
        for(dice in 1..6)  {
            this.hand.add(Dice())
            this.locked.add(false)
        }
        this.handCheckers.add(JambChecker())
        this.handCheckers.add(PokerChecker())
        this.handCheckers.add(BigStraightChecker())
        this.handCheckers.add(SmallStraightChecker())
    }

    fun lockDice(index: Int) {
        this.locked[index - 1] = true
    }

    fun checkHand(): String {
        for (handChecker in handCheckers) {
            val result = handChecker.checkHand(this)
            if (result != "nothing") return result
        }
        return "nothing"
    }

    fun roleHand() = hand.forEachIndexed { index, dice -> if(!locked[index]) dice.roleDice() }
}