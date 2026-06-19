import java.io.File;
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

    }

    @Override
    public void showAccount() {

    }

    @Override
    public void deleteAccount() {

    }
}
