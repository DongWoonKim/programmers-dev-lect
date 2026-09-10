package member

class MemberApp(private val manager: MemberManager) {

    fun start() {

        while (true) {

            when(printMenu()) {
                1 -> addMember()
                9 -> {
                    println("이용해주셔서 감사합니다.")
                    return
                }
                else -> println("올바른 번호를 입력하세요.")
            }

        }

    }

    private fun printMenu(): Int {

        println("[수행할 업무를 선택하세요. - 현재 회원수 : ${manager.memberCnt} / ${manager.totalCnt}]")
        println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)")
        println("[4]전체조회 [5]정보수정 [6]회원삭제")
        println("[7]이름검색 [8]도메인별통계 [9]프로그램 종료")

        return readln().toInt()
    }

    private fun addMember() {

        if ( manager.isFull ) {
            println("회원이 꽉 찼습니다.")
            return
        }

        println("이름을 입력하세요.")
        val name = readln()
        println("이메일을 입력하세요.")
        val email = readln()
        println("연락처를 입력하세요.")
        val phone = readln()

        if ( manager.addMember( Member(name, email, phone) ) ) {
            println("회원이 등록되었습니다.")
        } else {
            println("이미 존재하는 회원입니다.")
        }

    }

}






















