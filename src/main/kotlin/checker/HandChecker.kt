package checker

import Hand

interface HandChecker {

    fun checkHand(hand: Hand): String
}