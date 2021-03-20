fun main(args: Array<String>) {
    var gameOver = false
    var appInput: String
    while(!gameOver) {
        while(true) {
            println("1: New game")
            println("exit: Quit")
            appInput = readLine() ?: "Try again"
            if (appInput == "1" || appInput == "exit") break
        }
        when(appInput) {
            "1" -> {
                var done = false
                var gameInput: String
                val game = Game()
                game.printValues()
                println(game.checkResult())
                while(!done) {
                    while(true) {
                        println()
                        println("1: Role all unlocked dice")
                        println("2: Show dice values")
                        println("3: Option to lock dice")
                        println("back: go back")
                        gameInput = readLine() ?: "Try again"
                        if (gameInput == "1" || gameInput == "2" || gameInput == "3" || gameInput == "back") break
                    }
                    when(gameInput) {
                        "1" -> {
                            println()
                            game.role()
                            game.printValues()
                            println(game.checkResult())
                        }
                        "2" -> {
                            println()
                            game.printValues()
                        }
                        "3" -> {
                            println()
                            println("Enter dice number to lock: ")
                            game.lockDice((readLine() ?: "0").toInt())
                        }
                        "back" -> done = true
                    }
                }
            }
            "exit" -> gameOver = true
        }
    }
}
