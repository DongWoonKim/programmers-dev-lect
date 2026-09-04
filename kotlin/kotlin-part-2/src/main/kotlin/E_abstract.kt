
// * abstract

// 1. 왜 필요한가
// D_polymorphism 의 Shape 를 떠올려 보자.
//
//   open class Shape(val shapeName: String) {
//       open fun area(): Double = 0.0      // 부모는 넓이를 구할 방법이 없다
//   }
//
// 문제가 두 가지 있다.
//   1) Shape("무언가") 처럼 실체 없는 도형 객체를 만들 수 있다.
//   2) 자식이 area() 재정의를 깜빡해도 컴파일이 되고, 넓이가 0.0 으로 나온다.
//
// abstract 를 쓰면 둘 다 막을 수 있다.

// 2. 사용법
/*
abstract class Shape(val name: String) {
    abstract fun area(): Double // 자식이 반드시 구현
    fun describe() { // 본문이 있는 메서드도 가질 수 있다.

    }
}
*/

// 3. 객체를 만들 수 없다.
// val v = Vehicle("무언가") // 컴파일에러!
// 실체를 만들 수 없다.

// 4. 추상 프로퍼티도 만들 수 있다.
/*
abstract class Vehicle {
    abstract val wheels: Int // 값 없이 선언만
}

class Car() : Vehicle() {
    override val wheels: Int = 4
}
 */

// 5. 정리 : 일반 클래스 / open 클래스 / 추상 클래스
//   class Vehicle          : 상속 불가. 객체 생성 가능.
//   open class Vehicle     : 상속 가능. 객체 생성 가능. 재정의는 선택.
//   abstract class Vehicle : 상속 가능. 객체 생성 불가. abstract 멤버는 재정의 필수.















