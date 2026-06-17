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
