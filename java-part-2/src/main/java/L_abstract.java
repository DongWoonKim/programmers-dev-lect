
// * 추상 클래스
// 추상 클래스는 인스턴스화할 수 없는 클래스이다.
// 즉, 추상클래 자체로 객체를 생성할 수 없으며, 반드시 이 클래스를 상속받은 자식 클래스를 통해서만 객체를 생성할 수 있다.
// 추상 클래스는 추상 메서드뿐만 아니라 일반 메서드도 포함할 수 있으며, 필드(멤버 변수)를 가질 수도 있다.

// * 추상 메서드
// 추상 메서드는 메서드의 선언만 존재하고, 구현(메서드이 몸체)이 없는 메서드이다.
// 추상 메서드는 추상 클래스 내에서 정의되며, 이 메서드를 상속받은 자식 클래스는 반드시 이 메서드를 오버라이딩하여 구현해야 한다.

// * 요약
// 추상 클래스 : 인스턴스화할 수 없으며, 공통된 속성이나 메서드를 정의하고, 일부 메서드는 자식 클래스에서 구현하도록 강제한다.
// 추상 메서드 : 선언만 있고, 구현은 없으며, 반드시 자식 클래스에서 오버라이딩되어야 한다.

// * 단점

abstract class L_animal {

    // 추상 메서드 : 하위 클래스가 이 메서드를 구현해야함(오버라이딩, 재정의) -> 강제
    abstract void makeSound();

    // 일반 메서드 : 모든 하위 클래스에서 동일하게 동작함
    void breathe() {
        System.out.println("animal breathing");
    }
}

class L_dog extends L_animal {
    @Override
    void makeSound() {
        System.out.println("dog sound");
    }
}

class L_cat extends L_animal {
    @Override
    void makeSound() {
        System.out.println("cat sound");
    }
}

public class L_abstract {
    static void main(String[] args) {
        // 오류 : 추상 클래스는 인스턴스화할 수 없음
//        L_animal temp = new L_animal();

        L_animal dog = new L_dog();
        L_animal cat = new L_cat();

        dog.makeSound();
        dog.breathe();

        cat.makeSound();
        cat.breathe();

    }
}
