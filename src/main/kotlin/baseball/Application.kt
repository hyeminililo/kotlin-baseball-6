package baseball
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf as mutableListOf
import camp.nextstep.edu.missionutils.Console

const val INTRO_MESSAGE = "숫자 야구 게임을 시작합니다"
const val NOTHING_MESSAGE = "낫싱"
const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
fun main() {
    println(INTRO_MESSAGE)
    val computer = mutableListOf<String>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    print(INPUT_MESSAGE)
    val request = Console.readLine()
    val user = listOf(request)
    val result: Pair<Int, Int> = compare(computer, user)
    if(result == Pair(0,0)){
        println(NOTHING_MESSAGE)
    }
}

/**
 * 두 배열을 받아서 볼과 스트라이크 개수 반환
 */
fun compare(computer: MutableList<String>, user: List<String>): Pair<Int, Int>{
    var countStrike = 0
    var countBall = 0

    for (i in 0..2) {
        // i가 컴퓨터 배열 중 존재한다면
        val res:Boolean = computer.contains("${user[i]}")
        if (res == true) {
            // 근데 위치까지 같다면
            if (user[i] == computer[i]) {
                countStrike++
            }
            // 위치는 다르다면
            else {
                countBall++
            }
        }
    }

    return Pair(countStrike, countBall)
}

