package baseball

/* 예외 처리에 대한 함수 */
fun validation(list: List<String>):Unit{
    if(list.isEmpty())
        throw IllegalArgumentException("값이 비어있습니다.")
    else if(list.size !=3)
        throw IllegalArgumentException("3자리 수 양수를 입력해주세요.")
    else if(list.distinct() != list)
        throw IllegalArgumentException("1~9 까지의 각각 다른 3자리 수로 이루어진 양수로 입력해주세요.")
    try {
        for (i in 0..2){
            if(list[i].toInt()<0){
                throw IllegalArgumentException("음수가 아닌 양수를 입력해주세요.")
            }
        }

    }catch (e :NumberFormatException){
        throw IllegalArgumentException("숫자를 입력해주세요.")
    }



}