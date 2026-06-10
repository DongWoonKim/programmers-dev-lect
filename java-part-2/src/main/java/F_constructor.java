
// * 생성자(Constructor)
// 객체가 생성될 때 호출되는 특수한 메서드이다.
// 생성자는 객체의 초기 상태를 설정하는 데 사용되며,
// 클래스 이름과 동일한 이름을 가져야 한다.
// 생성자는 반환 타입이 없으며, 객체가 생성될 때 자동으로 호출된다.

// * 생성자의 주요 특징
// 1. 클래스 이름과 동일 : 생성자는 클래스 이름과 동일한 이름을 가져야 한다.
// 2. 반환 타입 없음 : 생성자는 반환 타입을 명시하지 않는다. 반환 타입을 명시하면 일반메서드로 인식한다.
// 3.


public class F_constructor {
    static void main(String[] args) {

        // 기본 생성자를 사용하여 객체 생성
        F_person1 person1 = new F_person1();
        person1.display();

        // 매개변수가 있는 생성자를 사용하여 객체 생성
        F_person2 person2 = new F_person2("Allice", 30);
        person2.display();

    }
}
