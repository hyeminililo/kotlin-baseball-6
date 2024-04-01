package baseball
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

const val NUM_OF_DIGITS = 3

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
const val MESSAGE_OF_WIN = "${NUM_OF_DIGITS}개의 숫자를 모두 맞히셨습니다! 게임 종료"
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
}

fun makeRandomNumbersOfList() {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < NUM_OF_DIGITS) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
}

