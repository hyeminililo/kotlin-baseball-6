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
    val computer = mutableListOf<String>()
     input(computer)

}

/**
 * 컴퓨터의 결과값과 사용자의 입출력 받기
 * */
fun input(computer: MutableList<String>) :Unit{
    print(INPUT_MESSAGE)   // 게임 시작
    println(computer)
    if(computer.isEmpty()){
        while (computer.size < COMPUTER_RANDOM_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
    }
    print(computer)
    val request:String = Console.readLine()
    val user = request.map{i -> i.toString()}
    print(user is MutableList)
    validation(user)
    checkBaseballGameResult(computer, user)



}
// 게임에 대한 결과를 반환하는 메소드
fun checkBaseballGameResult(computer: MutableList<String>, user:List<String> ) {
        val result: Pair<Int, Int> = compare(computer, user)
        if(result ==Pair(0,0)){
            println(NOTHING_MESSAGE)
            input(computer)
        }
        if(result ==Pair(0,3)){
            println("${result.second}스트라이크")
            print(SUCCESS_MESSAGE)
            println(END_MESSAGE)
            println(RETRY_MESSAGE)
            val request: String = Console.readLine()
            try {
                if (request == "1"){
                   computer.remove("")
                    input(computer)
                }
                if (request == "2"){
                    return
                }
            }catch (e: Error){
                throw  IllegalArgumentException()
            }
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
fun compare(computer: MutableList<String>, user: List<String>): Pair<Int, Int>{
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

