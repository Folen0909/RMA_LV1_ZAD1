package checker

import Hand

class BigStraightChecker : HandChecker {

    override fun checkHand(hand: Hand): String {
        val numbers = mutableListOf<Int>()
        hand.hand.forEach{ numbers.add(it.number) }
        numbers.sort()
        val straight = numbers.distinct()
        straight.fold(mutableListOf<MutableList<Int>>()) { acc, i ->
            if (acc.isEmpty() || acc.last().last() != i - 1) {
                acc.add(mutableListOf(i))
            } else acc.last().add(i)
            acc
        }.forEach{ if (it.containsAll(listOf(2, 3, 4, 5, 6))) return "Big Straight" }
        return "nothing"
    }
}