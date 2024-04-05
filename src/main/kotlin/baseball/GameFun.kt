package baseball


import camp.nextstep.edu.missionutils.Randoms

class GameFun {
    private val gameController = GameController()
    fun randomComputer(): List<String> {
        val computer = mutableListOf<String>()
        while (computer.size < COMPUTER_RANDOM_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }
    fun checkBaseballGameResult(computer: List<String>, user: List<String>) {
        val result: Pair<Int, Int> = compareNumbersOf(computer, user)
        if (result == Pair(0, 0)) {
            println(NOTHING_MESSAGE)
           gameController.inputUser(computer)
        }
        if (result == Pair(0, 3)) {
            println("${result.second}스트라이크")
            print(SUCCESS_MESSAGE)
            println(END_MESSAGE)
            gameController.gameRestart()
        }
        if (result != Pair(0, 0) && result != Pair(0, 3)) {
            if (result.first == 0) {
                println("${result.second}스트라이크")
            }
            if (result.second == 0) {
                println("${result.first}볼")
            }
            if (result.first != 0 && result.second != 0) {
                println("${result.first}볼 ${result.second}스트라이크")
            }
            gameController.inputUser(computer)
        }

    }
    fun compareNumbersOf(computer: List<String>, user: List<String>): Pair<Int, Int> {
        var countStrike = 0
        var countBall = 0

        for (i in user.indices) {
            val res: Boolean = computer.contains(user[i])
            if (res) {
                if (user[i] == computer[i]) {
                    countStrike++
                }
                else {
                    countBall++
                }
            }
        }

        return Pair(countBall, countStrike)
    }

}