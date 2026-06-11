
// * 다형성
// 동일한 인터페이스나 부모 클래스를 공유하는 여러 객체들이 각자 다른 방식으로 동작하도록 할 수 있는 기능을 말한다.
// 다형성은 "하나의 인터페이스로 여러 형태의 객체를 처리할 수 있다"는 의미를 가지고 있다.
// 이를 통해 코드의 유연성과 확장성을 크게 향상시킬 수 있다.

class K_animal {
    // 부모클래스에서 정의된 메서드
    public void sound() {
        System.out.println("Animal sound");
    }
}

class K_dog extends K_animal {

    public void fetch() {
        System.out.println("Dog fetches a ball");
    }

    @Override
    public void sound() {
        System.out.println("Dog sound");
    }
}

class K_cat extends K_animal {

    @Override
    public void sound() {
        System.out.println("Cat sound");
    }
}

public class K_polymorphism {
    static void main(String[] args) {

    }
}
