import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class F_account_book_impl implements F_account_book {

    private Map<String, List<F_item>> data = new HashMap<>();
    private Scanner sc;

    public F_account_book_impl(Scanner sc) {
        this.sc = sc;
    }

    // 1. 내역 추가
    @Override
    public void addAcound() {
        System.out.println("날짜 입력 (예: 2026-06-18)");
        String date = sc.nextLine().trim();

    }

    @Override
    public void showAccount() {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteItem() {

    }
}
