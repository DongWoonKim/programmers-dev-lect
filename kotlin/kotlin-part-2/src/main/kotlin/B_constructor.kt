
// * 생성자 - 주 생성자, init 블록, 부 생성자

// 1. 주 생성자
// 클래스 이름 바로 뒤에 괄호를 붙여서 쓴다.
// class Person(name: String, age: Int) {...}

// val/var을 붙이면 프로퍼티까지 한 번에 선언된다.
// class Person(val name: String, var age: Int) {...}
// -> "자바의 필드 2개 + getter 2개, setter 2개"와 같다.

// val/var 아무것도 붙이지 않으면 프로퍼티가 되지 않고 생성자 안에서만 쓰는 값이 된다.

// 2. init 블록

// 3. 매개변수 기본 값

// 4. 부 생성자