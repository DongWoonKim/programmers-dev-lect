package member

// 메뉴와 입력, 출력을 담당하는 클래스

class MemberApp(private val manager: MemberManger) {

    fun start() {

        while (true) {

        }

    }

    private fun printMenu(): Int {
        println("\n[수행할 업무를 선택하세요 - 현재 회원수 : ${manager.memberCnt}/${manager.totalCnt}]")
        println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)")
        println("[4]회원전체조회 [5]회원정보 수정 [6]회원삭제")
        println("[7]프로그램 종료")
        print("> ")

        return readln().toInt()
    }


}