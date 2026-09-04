package member

// 회원 목록을 보관하고 규칙을 담당하는 클래스

class MemberManger(planNo : Int) {

    val totalCnt = planNo * 10

    var memberCnt = 0
        private set

    // Array<Member>
    private val members = Array(totalCnt) { Member() }

}