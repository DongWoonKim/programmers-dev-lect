import java.util.Scanner;

public class D_start {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 요금제 선택
        System.out.println("[요금제] [1]Lite:10 [2]Basic:20 [3]Premium:30");
        D_price_plan plan = null;
        while (plan == null) {
            plan = D_price_plan.from( raedInt(sc) );
            if (plan == null) {
                System.out.println("1~3 중에서 선택하세요.");
            }
        }
        D_member_manager manager = new D_member_manager(plan.getCapacity());
        System.out.println("선택: " + plan + " (정원 " + plan.getCapacity() + ")");

        // 메뉴 루프
        while (true) {
            System.out.println("\n[현재 " + manager.size() + "/" + manager.capacity() + "]");
            System.out.println("[1]추가 [2]메일조회 [3]이름조회 [4]전체 [5]수정 [6]삭제 [7]종료");

            int choice = raedInt(sc);

            switch (choice) {
                case 1:

                    if ( manager.isFull() ) {
                        System.out.println("정원이 꽉 찼습니다.");
                        break;
                    }

                    System.out.println("등급 [1]일반 [2]VIP");
                    int grade = raedInt(sc);
                    System.out.println("이름");
                    String name = sc.nextLine();
                    System.out.println("이메일");
                    String email = sc.nextLine();
                    System.out.println("연락처");
                    String phone = sc.nextLine();

                    if (manager.existsEmail(email)) {
                        System.out.println("이미 있는 회원입니다.");
                        break;
                    }

                    D_member memeber = ( grade == 2 )
                            ? new D_vip_member(name, email, phone)
                            : new D_normal_member(name, email, phone);

                    manager.add(memeber);
                    System.out.println("추가되었습니다.");
                    break;
                case 7:
                    System.out.println("이용해주셔서 감사합니다.");
                    return;
                default:
                    System.out.println("1~7번 중에서 선택하세요.");
            }

        }

    }

    // 숫자를 안전하게 읽는다. 숫자가 아니면 -1 반환
    static int raedInt(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

}
