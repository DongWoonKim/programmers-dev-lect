

public class M_vending_machine {

    private int totalMoney;
    private M_drink[] drinks;

    public M_vending_machine() {
        totalMoney = 0;
        // 부모 타입 (Drink) 배열에 자식 객체들을 담는다 (다형성)
        drinks = new M_drink[] {
                new M_coke(),  // 0
                new M_drink(), // 1
                new M_drink(), // 2
                new M_drink()  // 3
        };
    }
}
