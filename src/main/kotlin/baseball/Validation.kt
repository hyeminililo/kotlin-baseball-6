package baseball


/* 예외 처리에 대한 함수 */
fun Valiadation(list: List<String>):Unit{
    if(list.isEmpty())
        throw IllegalArgumentException()
    else if(list.size !=3)
        throw IllegalArgumentException()
    else if(list.distinct() != list)
        throw IllegalArgumentException()
    try {
        for (i in 0..2){
           if(list[i].toInt()<0){
               throw IllegalArgumentException()
           }
        }

    }catch (e :NumberFormatException){
       throw IllegalArgumentException()
    }



}