import java.io.File;
import java.time.LocalDate;
import java.util.Scanner;

public class G_account_book_impl implements G_account_book {

    private final String DIR = System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "/accountbook";
    private Scanner sc;

    public G_account_book_impl(Scanner sc) {
        this.sc = sc;
        File folder = new File(DIR);
        if (!folder.exists()) folder.mkdir(); // 폴더 생성
    }

    @Override
    public void addAccount() {

        String today = LocalDate.now().toString();
        File file = new File(DIR, today + ".txt");

        int total = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {

            System.out.println("항목 이름 : ");
            String name = sc.nextLine().trim();
            System.out.println("가격 : ");
            int price = readInt();
            sb.append(name).append(" : ").append(price).append("원\n");
            total += price;

            System.out.println("더 추가할까요? (y/n) ");
            String more = sc.nextLine().trim();
            if (more.equals("n")) break;
        }

    }

    @Override
    public void showAccount() {

    }

    @Override
    public void deleteAccount() {

    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자로 다시 입력");
            }
        }
    }
}
