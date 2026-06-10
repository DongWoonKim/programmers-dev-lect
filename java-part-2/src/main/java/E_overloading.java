
// * 오버로딩
// 같은 이름의 메서드를 여러 개 정의할 수 있게 해주는 자바의 기능이다.
// 단, 이 메서드들은 매개변수의 타입, 갯수, 또는 순서가 달라야 된다.
// 메서드 오버로딩은 같은 기능을 수행하지만 입력이 다른 경우에 사용되며,
// 이를 통해 코드의 가독성과 유지보수성을 높일 수 있다.

// * 오버로딩의 규칙


class Calculator {

    // 두 정수의 합을 반환하는 메서드
    public int add(int a, int b) {
        return a + b;
    }

    // 세 정수의 합을 반환하는 메서드
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // 여러 개의 정수를 더하는 메서드 (가변인자 사용)
    public int add(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}

public class E_overloading {
    static void main(String[] args) {
    }
}
