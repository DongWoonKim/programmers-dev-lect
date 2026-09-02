
// 상수 선언.
const val COKE = 500
const val CIDER = 500
const val FANTA = 300
const val WATER = 200

fun printMenu(totalMoney: Int) {
    println("================== 자판기 ==================")
    println("[1]콜라 : $COKE, [2]사이다 : $CIDER, [3]환타 : $FANTA, [4]물 : $WATER, [5]돈 넣기, [6]종료")
    println("현재 금액 : $totalMoney")
    println("============================================")
}

fun getChoice(): Int {
    println("원하는 메뉴를 선택하시오.")

    // Scanner.nextInt()
    return readln().toInt()
}

fun main() {

    var totalMoney = 0

    while (true) {

        printMenu(totalMoney)

        val choice = getChoice()

        when (choice) {
            6 -> {
                println("\n잔돈 ${totalMoney}원이 반환되었습니다.")
                return
            }
            else -> println("잘 못 입력하셨습니다. 다시 입력해주세요.")
        }

    }

}

















