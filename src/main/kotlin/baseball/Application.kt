package baseball
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf as mutableListOf
import camp.nextstep.edu.missionutils.Console
import java.lang.Error
import java.util.Collections

const val INTRO_MESSAGE = "숫자 야구 게임을 시작합니다"
const val NOTHING_MESSAGE = "낫싱"
const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
const val RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! "
const val END_MESSAGE = "게임 종료"
const val COMPUTER_RANDOM_SIZE = 3

fun main() {
    println(INTRO_MESSAGE)
    val computer = randomComputer().toList()
    input(computer)

}

fun randomComputer():List<String>{
    val computer = mutableListOf<String>()
        while (computer.size < COMPUTER_RANDOM_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
    return computer
}
fun input(computer: List<String>) :Unit{
    print(INPUT_MESSAGE)// 게임 시작




    println(computer)
    val request:String = Console.readLine()
    val user = request.map{i -> i.toString()}
    print(user is MutableList)
    validation(user)
    checkBaseballGameResult(computer, user)



}
fun checkBaseballGameResult(computer: List<String>, user:List<String> ) {
        val result: Pair<Int, Int> = compareNumbersOf(computer, user)
        if(result ==Pair(0,0)){
            println(NOTHING_MESSAGE)
            input(computer)
        }
        if(result ==Pair(0,3)){
            println("${result.second}스트라이크")
            print(SUCCESS_MESSAGE)
            gameRestart()
        }
       else {
           if(result.first ==0){
               println("${result.second}스트라이크")
           }
            if (result.second==0){
                println("${result.first}볼")
            }
            else {
                println("${result.first}볼 ${result.second}스트라이크")

            }
            input(computer)
        }

}

/**
 * 두 배열을 받아서 볼과 스트라이크 개수 반환
 */
fun compareNumbersOf(computer: List<String>, user: List<String>): Pair<Int, Int>{
    var countStrike = 0
    var countBall = 0

    for (i in user.indices) {
        // i가 컴퓨터 배열 중 존재한다면
        val res:Boolean = computer.contains(user[i])
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

    return Pair( countBall,countStrike)
}
fun gameRestart(){
    println(RETRY_MESSAGE)
    val request: String = Console.readLine()
    when(request){
        "1"->{
            println("새 게임을 시작합니다.")
            input(randomComputer())

        }
        "2"-> {
            println(END_MESSAGE)
            return }
        else -> throw IllegalArgumentException("잘못된 입력입니다.")
    }
}

