package baseball

fun main() {
    val gameLogic = GameFun()
    val gameController = GameController()
    println(INTRO_MESSAGE)
    val computer = gameLogic.randomComputer().toList()
    gameController.inputUser(computer)
}








