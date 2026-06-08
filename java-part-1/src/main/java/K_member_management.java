import java.util.Scanner;

public class K_member_management {

    static int totalCnt = 0; // 이프로그램에서 저장할 수 있는 회원수
    static int memberCnt = 0; // 실제 회원수

    // 1. 요금제를 사용자한테 받는 함수를 완성해주세요.
    // [1]Lite : 10명 [2]Basic : 20명 [3]Premium : 30명
    public static int printPricePlan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[요금제를 선택하세요]");
        System.out.println("[1]Lite : 10명 [2]Basic : 20명 [3]Premium : 30명");

        return sc.nextInt();
    }

    // 2. 완성해주세요.
    /*
        System.out.println("[수행할 업무를 선택하세요 - 현재 회원수 : " + memberCnt + "/" + totalCnt  + "]");
        System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)");
        System.out.println("[4]회원전체조회 [5]회원정보 수정 [6]회원삭제");
        System.out.println("[7]프로그램 종료");
     */
    public static int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("[수행할 업무를 선택하세요 - 현재 회원수 : " + memberCnt + "/" + totalCnt  + "]");
        System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)");
        System.out.println("[4]회원전체조회 [5]회원정보 수정 [6]회원삭제");
        System.out.println("[7]프로그램 종료");

        return sc.nextInt();
    }

    // 1. 회원추가
    public static void addMember(String[][] members) {
        // 1-1. 회원이 꽉찼을 때 -> 추가 x '회원이 꽉 찼습니다' 를 사용자한테 안내하고 종료
        if (memberCnt == totalCnt) {
            System.out.println("회원이 꽉찼습니다.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("이름을 입력하세요.");
        String name = sc.nextLine();
        System.out.println("이메일을 입력하세요.");
        String email = sc.nextLine();
        System.out.println("연락처를 입력하세요.");
        String phone = sc.nextLine();

        members[memberCnt][0] = null;
        members[memberCnt][1] = null;
        members[memberCnt][2] = null;
        if ( checkEmail(members, email) ) {
            System.out.println("이미 존재하는 회원입니다.");
            return;
        }

        // 저장
        members[memberCnt][0] = name;
        members[memberCnt][1] = email;
        members[memberCnt][2] = phone;

        memberCnt++;
    }
    // 1-2. checkEmail -> 이메일은 중복을 받지 않음. 기존에 이미 있는 경우 '이미 존재하는 회원입니다.'를 사용자한테 안내 종료
    public static boolean checkEmail(String[][] members, String email) {
        // members 10행 3열
        // String str = "Hello";
        // null.equals(str) -> false
        // "hello".equals(str) -> true"
        for (int i = 0; i < members.length; i++) {
            if ( email.equals(members[i][1]) ) {
                return true;
            }
        }

        return false;
    }
    // 2. 회원조회(메일)
    public static void selectEmail(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[조회] 이메일을 입력하세요.");
        String email = sc.nextLine();

        for (int i = 0; i < members.length; i++) {
            if ( email.equals(members[i][1]) ) {
                System.out.println("[이름] " + members[i][0] + ", [메일] " + members[i][1] + ", [연락처] " + members[i][2]);
                return;
            }
        }

        System.out.println("찾으시는 정보가 없습니다.");
    }

    // 3. 회원조회(이름) -> selectName
    // 완성해주세요.
    public static void selectName(String[][] members) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[조회] 이름을 입력하세요.");
        String name = sc.nextLine();

        for (int i = 0; i < members.length; i++) {
            if ( name.equals(members[i][0]) ) {
                System.out.println("[이름] " + members[i][0] + ", [메일] " + members[i][1] + ", [연락처] " + members[i][2]);
                return;
            }
        }

        System.out.println("찾으시는 정보가 없습니다.");
    }

    // 4. 회원전체조회
    public static void selectAll(String[][] members) {
        for (int i = 0; i < members.length; i++) {
            System.out.println("[이름] " + members[i][0] + ", [메일] " + members[i][1] + ", [연락처] " + members[i][2]);
        }
    }

    // 5. 회원정보 수정
    // -> 이메일을 입력 -> 수정 : 이름, 이메일, 연락처

    static void main(String[] args) {

        // printPricePlan을 실행 -> 2차원 저장공간이 생성되어야한다.
        // 이름, 이메일, 연락처 - 3열
        int pricePlan = printPricePlan();
        totalCnt = pricePlan * 10;
        String[][] members = new String[totalCnt][3];
        System.out.println(totalCnt);
        // printMenu를 구성해주세요.
        // loop문 -> 7번, 메뉴값을 잘못 눌렀을 경우 사용자한테 안내 멘트를 남겨주세요.
        while ( true ) {
            int menu = printMenu();
            System.out.println(menu);
            switch (menu) {
                case 1:
                    addMember(members);
                    break;
                case 2:
                    selectEmail(members);
                    break;
                case 3:
                    selectName(members);
                    break;
                case 4:
                    selectAll(members);
                    break;
                case 7:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("잘 못 눌렀습니다.");
                    break;
            }
        }

    }
}
