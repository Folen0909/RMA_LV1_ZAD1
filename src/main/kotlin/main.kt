fun main(args: Array<String>) {

    var gameOver = false
    var appInput: String
    while(!gameOver) {
        println("1: New roles")
        println("anything else: Quit")
        appInput = readLine() ?: ""
        when(appInput) {
            "1" -> {
                var rolesOver = false
                var gameInput: String
                val game = Game()
                game.seeHand()
                game.checkHand()
                while(!rolesOver) {
                    println()
                    println("1: Role hand")
                    println("2: See hand")
                    println("3: Lock dice")
                    println("anything else: back")
                    gameInput = readLine() ?: ""
                    when(gameInput) {
                        "1" -> {
                            println()
                            game.roleHand()
                            game.seeHand()
                            game.checkHand()
                            if (game.isOver()) {
                                println("Roles over")
                                println()
                                rolesOver = true
                            }
                        }
                        "2" -> {
                            println()
                            game.seeHand()
                        }
                        "3" -> {
                            println()
                            println("Enter dice number to lock: ")
                            game.hand.lockDice((readLine() ?: "0").toInt())
                        }
                        else -> rolesOver = true
                    }
                }
            }
            else -> gameOver = true
        }
    }
}
