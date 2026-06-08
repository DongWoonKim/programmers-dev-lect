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

    static void main(String[] args) {

    }
}
