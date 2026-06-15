import java.util.Scanner;

public class O_start {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("[요금제를 선택하세요]");
        System.out.println("[1]Lite : 10명 [2]Basic : 20명 [3]Premium : 30명");

        int plan = Integer.parseInt(sc.nextLine());
        O_member_manager manager = new O_member_manager(plan * 10);

        while (true) {
            System.out.println("\n[수행할 업무 - 현재 회원수 : "
                    + manager.getMemberCount() + "/" + manager.getCapacity() + "]");
            System.out.println("[1]회원추가 [2]회원조회(메일) [3]회원조회(이름)");
            System.out.println("[4]전체조회 [5]수정 [6]삭제 [7]종료");

            int menu = Integer.parseInt(sc.nextLine());
            switch (menu) {
                case 1:
                    if (manager.isFull()) {
                        System.out.println("회원이 꽉 찼습니다.");
                        break;
                    }
                    break;
                case 2:
                    break;
                case 7:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("잘 못 입력하셨습니다.");
            }

        }

    }
}
