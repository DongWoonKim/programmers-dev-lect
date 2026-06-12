
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

}
