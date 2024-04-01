package baseball

fun checkExceptionOnInput(input: String) {
    isInteger(input)
    isContainsDuplicated(input)
    isCorrectNumberOfDigit(input)
}

fun isInteger(input: String) {
    try{
        input.toInt()
    } catch (e: Exception) {
        throw IllegalArgumentException("문자를 입력하였습니다. 숫자를 입력해주세요.")
    }
}

fun isContainsDuplicated(input: String) {
    for (i in input) {
       if (input.count { it == i } > 1) {
           throw IllegalArgumentException("중복된 숫자를 입력하였습니다.")
       }
    }
}

fun isCorrectNumberOfDigit(input: String) {
    if (input.length != NUMBER_OF_DIGITS) {
        throw IllegalArgumentException("규칙에 맞지 않는 길이의 숫자를 입력하였습니다.")
    }
}