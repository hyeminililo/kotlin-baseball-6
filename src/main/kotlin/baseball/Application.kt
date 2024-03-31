package baseball
import camp.nextstep.edu.missionutils.Randoms
import kotlin.collections.mutableListOf as mutableListOf
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val computer = mutableListOf<String>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9).toString()
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    // ["1","2","3"]를 "123"으로 하려면
    //    var computerToString = ""
    //    for (i in computer) {
    //        computerToString += i
    //    } // "123"
    print("숫자를 입력해주세요 : ")
    val request:String = Console.readLine()
    val user = mutableListOf(String)
    while (user.size < 3){

    }

}
