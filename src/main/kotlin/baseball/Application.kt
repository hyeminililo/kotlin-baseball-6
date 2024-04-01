package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val NUMBER_OF_DIGITS = 3

const val WORD_OF_RESTART = "1"
const val WORD_OF_END = "2"
const val WORD_OF_BALL = "볼"
const val WORD_OF_STRIKE = "스트라이크"
const val WORD_OF_NOTHING = "낫싱"

const val NUMBER_OF_BALL = "numberOfBall"
const val NUMBER_OF_STRIKE = "numberOfStrike"

const val MESSAGE_OF_START = "숫자 야구 게임을 시작합니다"
const val MESSAGE_OF_INPUT  = "숫자를 입력해주세요 : "
const val MESSAGE_OF_ASK_RESTART = "게임을 새로 시작하려면 ${WORD_OF_RESTART}, 종료하려면 ${WORD_OF_END}를 입력하세요."
const val MESSAGE_OF_WIN = "${NUMBER_OF_DIGITS}개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val MESSAGE_OF_END = "게임을 종료합니다."

fun main() {
    var isPlaying = true
    println(MESSAGE_OF_START)
    while (isPlaying) {
        playGame()
    }

    println(MESSAGE_OF_END)
}

fun playGame() {
    val computerNumberList = makeRandomNumbersOfList()
    var result:MutableMap<String, Int> = mutableMapOf(NUMBER_OF_BALL to 0, NUMBER_OF_STRIKE to 0)

    while (result[NUMBER_OF_STRIKE] != NUMBER_OF_DIGITS) {
        print(MESSAGE_OF_INPUT)
        val playerNumberList = Console.readLine()?.let { makePlayerNumbersOfList(it) }

        if (playerNumberList != null) {
            result = getResult(computerNumberList, playerNumberList)
        }
        printResult(result)
    }

}

fun makeRandomNumbersOfList(): MutableList<Int> {
    val computerNumberList = mutableListOf<Int>()
    while (computerNumberList.size < NUMBER_OF_DIGITS) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumberList.contains(randomNumber)) {
            computerNumberList.add(randomNumber)
        }
    }
    return computerNumberList
}

fun makePlayerNumbersOfList(input: String):MutableList<Int> {
    checkExceptionOnInput(input)

    val userNumbers = mutableListOf<Int>()
    for (i in 0 until NUMBER_OF_DIGITS) {
        userNumbers.add(input[i].digitToInt())
    }

    return userNumbers
}

fun getResult(
    computerNumberList: MutableList<Int>,
    userNumberList: MutableList<Int>
): MutableMap<String, Int> {

    val numberOfStrike: Int =
        userNumberList.count { computerNumberList.indexOf(it) == userNumberList.indexOf(it)}

    val numberOfBall: Int =
        userNumberList.count { computerNumberList.contains(it) } - numberOfStrike


    val result = mutableMapOf(NUMBER_OF_BALL to numberOfBall, NUMBER_OF_STRIKE to numberOfStrike)
    return result
}

fun printResult(result: MutableMap<String, Int>) {
    if (result[NUMBER_OF_STRIKE] == NUMBER_OF_DIGITS) {
        println("${ NUMBER_OF_DIGITS}${WORD_OF_STRIKE}")
        println(MESSAGE_OF_WIN)
    }

    if (result[NUMBER_OF_BALL] != 0) {
        print("${result[NUMBER_OF_BALL]}$WORD_OF_BALL ")
    }

    if (result[NUMBER_OF_STRIKE] != 0) {
        print("${result[NUMBER_OF_STRIKE]}$WORD_OF_STRIKE")
    }

    if (result[NUMBER_OF_STRIKE] == 0 && result[NUMBER_OF_BALL] == 0) {
        println(WORD_OF_NOTHING)
    }
    println()
}
