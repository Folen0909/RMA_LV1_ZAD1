package checker

import Hand

class PokerChecker : HandChecker {

    override fun checkHand(hand: Hand): String {
        val numbers = mutableListOf<Int>()
        hand.hand.forEach{ numbers.add(it.number) }
        numbers.sort()
        numbers.fold(mutableListOf<MutableList<Int>>()) { acc, i ->
            if (acc.isEmpty() || acc.last().last() != i) {
                acc.add(mutableListOf(i))
            } else acc.last().add(i)
            acc
        }.forEach{
            if (it.size >= 4) return "Poker"
        }
        return "nothing"
    }

}