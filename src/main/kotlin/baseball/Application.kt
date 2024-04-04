package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf as mutableListOf
import camp.nextstep.edu.missionutils.Console
import java.lang.Error
import java.util.Collections

const val INTRO_MESSAGE = "숫자 야구 게임을 시작합니다."
const val NOTHING_MESSAGE = "낫싱"
const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! "
const val END_MESSAGE = "게임 종료"
const val COMPUTER_RANDOM_SIZE = 3

fun main() {
    println(INTRO_MESSAGE)
    val computer = randomComputer().toList()
    inputUser(computer)
}

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

fun inputUser(computer: List<String>): Unit {
    print(INPUT_MESSAGE)
    val request: String = Console.readLine()
    val user = request.map { i -> i.toString() }
    validation(user)
    checkBaseballGameResult(computer, user)


}

fun checkBaseballGameResult(computer: List<String>, user: List<String>) {
    val result: Pair<Int, Int> = compareNumbersOf(computer, user)
    if (result == Pair(0, 0)) {
        println(NOTHING_MESSAGE)
        inputUser(computer)
    }
    if (result == Pair(0, 3)) {
        println("${result.second}스트라이크")
        print(SUCCESS_MESSAGE)
        println(END_MESSAGE)
        gameRestart()
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
        inputUser(computer)
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

fun gameRestart() {
    println(RETRY_MESSAGE)
    val request: Int = Console.readLine().toInt()
    when (request) {
        1 -> {
            inputUser(randomComputer())
        }

        2 -> {

        }

        else -> throw IllegalArgumentException("1 또는 2를 입력하세요")
    }
}
