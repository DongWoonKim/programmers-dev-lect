
var totalCnt = 0
var memberCnt = 0

fun printPricePlan(): Int {
    println("[요금제를 선택하세요]")
    println("[1] Lite : 10명 [2] Basic : 20명 [3] Premium : 30명")
    print("> ")

    return readln().toInt()
}

fun main() {

    val num = printPricePlan()
    totalCnt = num * 10

    val members = Array( totalCnt ) { Array( 3 ) {""} }

}
