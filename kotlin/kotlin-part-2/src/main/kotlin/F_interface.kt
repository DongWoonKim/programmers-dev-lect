
// * 인터페이스

// 1. 사용법
// 상속과 구현 모두 콜론(:) 하나로 쓴다. 즉 extends/implements가 없다.
// 부모 클래스와 인어페이스를 함께 쓸 때는 부모 클래스를 먼저 적는다.
// class A : Parent(), Printable, Loggable

// 2. 여러 개를 동시에 구현할 수 있다.

// 3. 자바 인터페이스와 다른 점
// * 프로퍼티를 선언할 수 있다. (자바는 상수만 가능)
//   interface Loggable {
//       val logTag: String            // 값 없이 선언만. 구현하는 쪽이 채운다.
//   }
//
// * 본문이 있는 메서드를 그냥 쓸 수 있다. (자바 8 의 default 메서드에 해당하지만 키워드가 없다)
//   interface Printable {
//       fun printInfo()
//       fun printTwice() {            // 기본 구현. 필요하면 구현하는 쪽에서 재정의한다.
//           printInfo(); printInfo()
//       }
//   }
