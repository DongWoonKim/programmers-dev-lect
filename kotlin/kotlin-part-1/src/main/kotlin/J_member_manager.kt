
var totalCnt = 0
var memberCnt = 0

fun printPricePlan(): Int {
    println("[요금제를 선택하세요]")
    println("[1] Lite : 10명 [2] Basic : 20명 [3] Premium : 30명")
    print("> ")

    return readln().toInt()
}

fun printMenu(): Int {
    println("[수행할 업무를 선택하세요 - 현재 회원수 : $memberCnt/$totalCnt]")
    println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)")
    println("[4]회원전체조회 [5]회원정보수정 [6]회원삭제")
    println("[7]프로그램 종료")

    return readln().toInt()
}

fun main() {

    val num = printPricePlan()
    totalCnt = num * 10

    val members = Array( totalCnt ) { Array( 3 ) {""} }

    while (true) {

        when (printMenu()) {
            7 -> {
                println("이용해주셔서 감사합니다.")
                return
            }
            else -> println("올바른 번호를 입력하세요.")
        }

    }

}
