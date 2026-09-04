
// * this/super

// this  : 자기 자신(이 객체)을 가리킨다.
// super : 부모 클래스를 가리킨다.
// 둘 다 "누구의 것인지"가 헷갈릴 때 콕 집어 주는 역할을 한다.

// 1. this - 프로퍼티와 매개변수 이름이 같을 때
//   class User(name: String) {
//       val name: String
//       init {
//           this.name = name     // this.name 은 프로퍼티, 그냥 name 은 매개변수
//       }
//   }

// 2. this - 자기 자신을 돌려주기 (메서드 체이닝)
//   fun add(topping: String): Pizza {
//       ...
//       return this          // 자기 자신을 돌려준다
//   }
//   pizza.add("치즈").add("페퍼로니").add("올리브")     <- 점을 이어서 쓸 수 있다

// 3. this - 생성자에서 다른 생성자 부르기
//   constructor(title: String) : this(title, 10000)

// 4. super - 부모의 메서드/프로퍼티 부르기
//   override fun work() {
//       super.work()         // 부모의 work() 를 먼저 실행하고
//       println("추가 동작")   // 내 동작을 덧붙인다
//   }

// 5. super - 부모 생성자 부르기
// * 주 생성자가 있을 때 : 클래스 선언부에서 부모 생성자를 호출한다.
//   class Manager(name: String) : Employee(name)
//
// * 주 생성자가 없을 때 : 부 생성자에서 super(...) 로 호출한다.
//   class Intern : Employee {
//       constructor(name: String) : super(name)
//   }

// 6. super<타입> - 어느 부모인지 지정하기
// 인터페이스는 여러 개를 구현할 수 있어서, 같은 이름의 기본 구현이 겹칠 수 있다.
// 이때는 꺾쇠로 어느 쪽 것인지 지정해야 한다. 지정하지 않으면 컴파일 에러다.
//   super<Walkable>.move()
//   super<Swimmable>.move()




















