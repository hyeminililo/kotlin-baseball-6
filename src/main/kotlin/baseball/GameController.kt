package baseball

import camp.nextstep.edu.missionutils.Console

const val INTRO_MESSAGE = "숫자 야구 게임을 시작합니다."
const val NOTHING_MESSAGE = "낫싱"
const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! "
const val END_MESSAGE = "게임 종료"
const val COMPUTER_RANDOM_SIZE = 3

class GameController {
    private val gameFun = GameFun()
    fun inputUser(computer: List<String>): Unit {
        print(INPUT_MESSAGE)
        val request: String = Console.readLine()
        val user = request.map { i -> i.toString() }
        validation(user)

        gameFun.checkBaseballGameResult(computer, user)


    }
    fun gameRestart() {
        println(RETRY_MESSAGE)
        val request: Int = Console.readLine().toInt()
        when (request) {
            1 -> {
                inputUser(gameFun.randomComputer())
            }

            2 -> {

            }

            else -> throw IllegalArgumentException("1 또는 2를 입력하세요")
        }
    }
    fun validation(list: List<String>): Unit {

        if (list.isEmpty())
            throw IllegalArgumentException("값이 비어있습니다.")

        if (list.size != 3)
            throw IllegalArgumentException("3자리 수 양수를 입력해주세요.")

        if (list.distinct() != list)
            throw IllegalArgumentException("1~9 까지의 각각 다른 3자리 수로 이루어진 양수로 입력해주세요.")

        try {
            for (i in 0..2) {
                if (list[i].toInt() < 0) {
                    throw IllegalArgumentException("음수가 아닌 양수를 입력해주세요.")
                }
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자를 입력해주세요.")
        }
    }
}