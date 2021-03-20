class Game {
    val dices = mutableListOf<Dice>()

    init {
        for (i in 1..6) {
            this.dices.add(Dice())
        }
    }
    fun role() {
        this.dices.filter{ !it.isLocked() }.forEach{ it.roleDice() }
    }

    fun printValues() = this.dices.forEachIndexed { index, dice ->
        println("Dice ${index + 1}: ${dice.checkValue()}, locked: ${dice.isLocked()}") }

    fun checkResult(): String {
        val numbers = mutableListOf<Int>()
        dices.forEach{ numbers.add(it.number) }
        numbers.sort()
        numbers.fold(mutableListOf<MutableList<Int>>()) { acc, i ->
            if (acc.isEmpty() || acc.last().last() == i) {
                acc.add(mutableListOf(i))
            } else acc.last().add(i)
            acc
        }.forEach{
            if (it.size >= 5) return "Jamb"
            if (it.size >= 4) return "Poker"
        }
        numbers.fold(mutableListOf<MutableList<Int>>()) { acc, i ->
            if (acc.isEmpty() || acc.last().last() != i - 1) {
                acc.add(mutableListOf(i))
            } else acc.last().add(i)
            acc
        }.forEach{ if (it.size >= 4) return "Straight" }
        return "Nothing"
    }

    fun lockDice(index: Int) {
        if (index <= 0 || index > 6) return
        this.dices[index - 1].lockDice()
    }

    fun unlockDice(index: Int) {
        this.dices[index - 1].unlockDice()
    }
}