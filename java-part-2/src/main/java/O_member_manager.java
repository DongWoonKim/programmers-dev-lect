public class O_member_manager {

    private O_member[] members;
    private int memberCount;

    public O_member_manager(int capacity) {
        members = new O_member[capacity];
        memberCount = 0;
    }

    public boolean isFull() {
        return memberCount == members.length;
    }

    // 이메일 중복 검사
    public boolean existsEmail(String email) {
        for (int i = 0; i < memberCount; i++) {
            if (email.equals(members[i].getEmail())) {
                return true;
            }
        }

        return false;
    }

    // 이메일로 찾기
    public O_member findByEmail(String email) {
        for ( int i = 0; i < memberCount; i++ ) {
            if ( email.equals(members[i].getEmail()) ) {
                return members[i];
            }
        }

        return null;
    }

    // 이름으로 찾기
    public O_member findByName(String name) {
        for ( int i = 0; i < memberCount; i++ ) {
            if ( name.equals(members[i].getName()) ) {
                return members[i];
            }
        }

        return null;
    }

    // 전체 출력
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
