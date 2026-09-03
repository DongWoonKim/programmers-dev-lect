
// * 생성자 - 주 생성자, init 블록, 부 생성자

// 1. 주 생성자
// 클래스 이름 바로 뒤에 괄호를 붙여서 쓴다.
// class Person(name: String, age: Int) {...}

// val/var을 붙이면 프로퍼티까지 한 번에 선언된다.
// class Person(val name: String, var age: Int) {...}
// -> "자바의 필드 2개 + getter 2개, setter 2개"와 같다.

// val/var 아무것도 붙이지 않으면 프로퍼티가 되지 않고 생성자 안에서만 쓰는 값이 된다.

// 2. init 블록
// 객체가 만들어질 때 실행할 코드를 담는다. 주 생성자에는 코드를 넣을 자리가 없기 때문.
// 값 검사나 초기 처리 같은 일은 init 블록에서 한다.
/*
class Person(val name: String) {
    init {
        println("${name} 생성됨")
    }
}
 */

// 3. 매개변수 기본 값
// 생성자에도 기본값을 줄 수 있다.
//      class Book(val title: String, val price: Int = 1000)

// 4. 부 생성자
// constructor 키워드로 생성자를 추가한다. 여러 개 만들 수 있다.
// constructor(title: String) : this(title, 1000)

// 부 생성자는 반드시 this(...)로 주 생성자를 호출해야 한다.
// 어떤 생성자로 만들어도 init블록은 항상 실행된다.



























