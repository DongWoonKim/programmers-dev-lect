
// 회원 관리자

public class N_member_manager {

    private N_member[] members;
    private int memberCount;

    public N_member_manager(int capacity) {
        members = new N_member[capacity];
        memberCount = 0;
    }

    // 회원추가
    public void add(N_member m) {
        members[memberCount++] = m;
    }

    // 전체출력
    public void printAll() {
        if (memberCount == 0) {
            System.out.println("등록된 회원이 없습니다.");
            return;
        }

        for (int i = 0; i < memberCount; i++) {
            members[i].printInfo();
        }
    }

    // 이름으로 찾기
    public N_member findByName(String name) {
        for ( int i = 0; i < memberCount; i++ ) {
            if ( name.equals(members[i].getName()) ) {
                return members[i];
            }
        }

        return null;
    }

    // 이메일로 찾기
    public N_member findByEmail(String email) {
        for ( int i = 0; i < memberCount; i++ ) {
            if ( email.equals(members[i].getEmail()) ) {
                return members[i];
            }
        }

        return null;
    }

    // 현재 회원수
    public int getMemberCount() {
        return memberCount;
    }

    // 현재 요금제
    public int getCapacity() {
        return members.length;
    }


}
