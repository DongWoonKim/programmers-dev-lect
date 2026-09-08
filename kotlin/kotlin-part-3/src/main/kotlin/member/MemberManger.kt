package member

class MemberManger(planNo: Int) {

    val totalCnt = planNo * 10
    // val : 요소를 추가하고 삭제할 수 있다. 단 주소참조 변경은 불가능
    private val members = mutableListOf<Member>()
    // 커스텀 getter : 값을 저장해 두지 않고 읽을 때마다 계산한다
    val memberCnt: Int
        get() = members.size
    val isFull: Boolean
        get() = totalCnt <= members.size

    // 이메일 조회
//    fun findByEmail(email: String): Member? = members.find { member -> member.email == email }
    fun findByEmail(email: String): Member? = members.find { it.email == email }

    // 이름 조회
//    fun findByName(name: String): Member? = members.find { member -> member.name == name }
    fun findByName(name: String): Member? = members.find { it.name == name }


}