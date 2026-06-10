
// * 캡슐화
// 객체지향프로그래밍의 기본 원칙 중 하나로, 데이터를 숨기고(은닉) 그 데이터를 조작하는 메서드만 외부에 노출하여
// 객체 내부의 상태를 보호 하는 개념이다.
// 캡슐화의 핵심 목표는 외부에서 객체의 내부 구조를 직접적으로 접근하거나 수정하지 못하게 하고,
// 이를 통해 데이터의 무결성과 보안성을 유지하는 것이다.

// 캡슐화의 주요 특징
// 1. 데이터 은닉

// 2. 접근 제어자

// 3. Getter와 Setter

public class J_encapsulation {
    // private 필드로 선언하여 외부에서 직접 접근할 수 없도록 함.
    private String name;
    private int age;

    // setter 메서드 : 외부에서 name 필드의 값을 설정할 수 있도록 허용
    public void setName(String name) {
        this.name = name;
    }

    // getter 메서드 : 외부에서 name 필드의 값을 접근할 수 있도록 허용
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // setter 메서드 : 외부에서 age 필드 값을 설정할 수 있도록 허용
    // 유효성 검사를 추가하여 올바른 값만 설정되도록 할 수 있다.
    public void setAge(int age) {

        if (age < 0) {
            System.out.println("올바른 값이 압니다.");
            return;
        }

        this.age = age;
    }
}
