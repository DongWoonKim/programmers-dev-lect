
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

// 회원 추가
fun addMember( members: Array<Array<String>> ) {

    if ( memberCnt == totalCnt ) {
        println("회원이 꽉 찼습니다.")
        return
    }

    println("이름을 입력하세요.")
    val name = readln()
    println("이메일을 입력하세요.")
    val email = readln()
    println("연락처를 입력하세요.")
    val phone = readln()

    if ( findIndex(members, 1, email) != -1 ) {
        println("이미 존재하는 회원입니다.")
        return
    }

    members[memberCnt][0] = name
    members[memberCnt][1] = email
    members[memberCnt][2] = phone

    memberCnt++
    println("회원이 등록되었습니다.")
}

fun selectEmail(members: Array<Array<String>>) {
    println("이메일을 입력하세요.")
    val email = readln()

    val idx = findIndex(members, 1, email)
    if ( idx == -1 ) {
        println("찾으시는 정보가 없습니다.")
        return
    }

    printMember( members[idx] )
}

fun selectName(members: Array<Array<String>>) {
    println("이름을 입력하세요.")
    val name = readln()

    val idx = findIndex(members, 0, name)
    if ( idx == -1 ) {
        println("찾으시는 정보가 없습니다.")
        return
    }

    printMember( members[idx] )
}

fun printMember(member: Array<String>) {
    println("[이름] ${member[0]}, [이메일] ${member[1]}, [연락처] ${member[3]}")
}

fun findIndex(members: Array<Array<String>>, col: Int, value: String): Int {

    for ( idx in 0 until memberCnt ) {
        if ( value == members[idx][col] ) {
            return idx
        }
    }

    return -1
}

fun main() {

    val num = printPricePlan()
    totalCnt = num * 10

    val members = Array( totalCnt ) { Array( 3 ) {""} }

    while (true) {

        when (printMenu()) {
            1 -> addMember(members)
            2 -> selectEmail(members)
            3 -> selectName(members)
            7 -> {
                println("이용해주셔서 감사합니다.")
                return
            }
            else -> println("올바른 번호를 입력하세요.")
        }

    }

}
