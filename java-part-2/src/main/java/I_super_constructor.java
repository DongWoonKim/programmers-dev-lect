
// * super() : 조상 클래스의 생성자
// this()와 마찬가지로 super()역시 생성자이다.
// this()는 같은 클래스의 다른 생성자를 호출하는데 사용되지만,
// super()는 조상클래스의 생성자를 호출하는데 사용된다.

class SuperPoint {
    int x = 10;
    int y = 20;
}

class SubPoint3D extends SuperPoint {
    int z = 30;
}

public class I_super_constructor {
    static void main(String[] args) {

    }
}
