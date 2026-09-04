
// * 정보 은닉과 캡슐화 - private, protected, internal, public

// 캡슐화는 데이터와 그것을 다루는 기능을 하나로 묶고,
// 바깥에서 함부로 건드리면 안 되는 것은 감추는 것이다.
// 감추는 쪽에 초점을 맞춘 표현이 정보 은닉이다.

// 1. 왜 감추는가
// 프로퍼티를 그대로 열어 두면 아무나 아무 값이나 넣을 수 있다.
//   account.balance = -99999       // 잔액이 음수가 되어 버린다
//
// 프로퍼티를 감추고, 정해 둔 통로(메서드)로만 바꾸게 하면 규칙을 지킬 수 있다.
//   account.deposit(1000)          // 입금 규칙을 통과한 값만 반영된다

// 2. 가시성 제어자 4가지
//   public    : 어디서나 접근 가능. 아무것도 안 쓰면 이것이다.
//   private   : 선언된 곳 안에서만. (클래스 안 / 그 파일 안)
//   protected : 자기 자신과 자식 클래스에서만.
//   internal  : 같은 모듈(같은 프로젝트) 안에서만.

// * 자바와 다른 점
//   - 기본값이 public 이다. (자바는 package-private)
//   - protected 는 자기 + 자식만이다. 같은 패키지라고 접근할 수 없다. (자바보다 좁다)
//   - package-private 이 없고, 대신 모듈 단위의 internal 이 있다.
//
// * 최상위(파일 맨 바깥)에 선언한 것에 private 을 붙이면 '그 파일 안에서만'이 된다.

// 3. 감추고 통로만 열기
//   class BankAccount {
//       private var balance: Int = 0          // 밖에서 못 건드린다
//
//       fun deposit(money: Int) { ... }       // 정해진 통로만 열어 둔다
//       fun getBalance(): Int = balance
//   }

// 4. 커스텀 setter 와 field
// 아예 막는 대신, 값을 넣을 때 검사해서 걸러 낼 수도 있다.
//   var age: Int = 0
//       set(value) {
//           field = if (value < 0) 0 else value    // 음수면 0 으로
//       }
//
// * field 는 그 프로퍼티의 실제 저장 공간을 가리키는 이름이다.
//   setter 안에서 age = value 라고 쓰면 setter 가 자기 자신을 다시 불러 무한 반복이 된다.
//   반드시 field 에 넣어야 한다.

// 5. private set - 밖에서는 읽기만, 안에서는 쓰기
//   var score: Int = 0
//       private set          // getter 는 public, setter 만 private
//
// 가장 자주 쓰는 형태다. 값은 누구나 볼 수 있지만 바꾸는 것은 클래스 안에서만 가능하다.
























