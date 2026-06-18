import java.util.*;

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

        // 같은 날짜가 이미 있으면 기존 목록에 이어서 추가
        List<F_item> list = data.getOrDefault(date, new ArrayList<>());

        while (true) {
            
        }

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
