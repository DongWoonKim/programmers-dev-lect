
// * data class - 값을 담는 클래스

// 1. 모든 클래스는 Any를 상속한다.
// Any 에는 equals(), hashCode(), toString() 이 있다.
// 그런데 Any가 만들어 둔 기본 동작은 이렇다.
// - equals(other) : this === other '같은 객체인가(주소 비교)'
// - hashCode() : 객체마다 다른 번호
// - toString() : 클래스이름@주소
// 그래서 내용이 똑같은 객체 두 개를 만들어도 == 는 false 다.
// Set 과 Map 은 hashcode로 칸을 정하고 equals로 확인하므로 중복 제거도 되지 않는다.

// 2. data class 가 자동으로 만들어 주는 것
// class 앞에 data 를 붙이면, 주 생성자에 선언한 프로퍼티를 기준으로 다섯 가지가 생긴다
//     equals()        모든 프로퍼티가 같으면 true
//     hashCode()      모든 프로퍼티로 계산한 번호 (내용이 같으면 번호도 같다)
//     toString()      BMember(name=김철수, age=20)
//     copy()          일부만 바꾼 새 객체를 만든다
//     component1(), component2(), ...   구조 분해에 쓰인다

// 3. 특징
//   - 주 생성자에 프로퍼티가 최소 하나는 있어야 한다.
//   - 주 생성자의 프로퍼티는 val 또는 var 여야 한다.
//   - '주 생성자에 선언한 것'만 equals/hashCode/toString/copy 에 들어간다.
//     클래스 본문(중괄호 안)에 선언한 프로퍼티는 무시된다.
//   - var 프로퍼티를 Set 이나 Map 키로 쓰면 위험하다.
//     넣은 뒤에 값을 바꾸면 hashCode 가 달라져서 다시는 찾지 못한다.
//     -> 키로 쓸 data class 는 val 로만 만드는 것이 안전하다.

// 4. 언제 쓰나
//   "값을 담아 나르는 것이 주된 일"인 클래스에 쓴다.  회원, 상품, 주문, 좌표, 응답 결과 ...
//   반대로 동작이 중심인 클래스(MemberManager, MemberApp 같은)는 보통 클래스로 둔다.

// 보통 클래스
class BPlainMember(val name: String, val email: String)

// data class
data class BMember(val name: String, val email: String, var age: Int = 0)

// 본문에 선언한 프로퍼티는 equals가 들어가지 않는다.
data class BBook(val title: String) {
    var price: Int = 0
}

// 1. 보통 클래스와 data class
fun b_exam1() {

    val p1 = BPlainMember("김철수", "kim@a.com")
    val p2 = BPlainMember("김철수", "kim@a.com")

    println(p1 == p2)
    println(p1)

    val d1 = BMember("김철수", "kim@a.com")
    val d2 = BMember("김철수", "kim@a.com")

    println(d1 == d2)
    println(d1)
    println(d1.hashCode() == d2.hashCode())

    println(d1 == d2)  // equals 값비교
    println(d1 === d2) // 주소비교

    val d3 = d2
    println(d3 === d2) // true

}

// 2. data class 와 컬렉션
fun b_exam2() {
    val list = listOf(
        BMember("김철수", "kim@a.com"),
        BMember("이영희", "lee@a.com"),
        BMember("김철수", "kim@a.com")       // 위와 내용이 같은 회원
    )

    // 2-1. contains / indexOf 가 '내용'으로 동작한다
    println(list.contains(BMember("이영희", "lee@a.com")))      // true
    println(list.indexOf(BMember("김철수", "kim@a.com")))       // 0
    println(BMember("이영희", "lee@a.com") in list)             // true
    // 보통 클래스였다면 전부 false / -1 이 나온다.

    // 2-2. 중복 제거가 된다
    println(list.distinct().size)               // 2
    println(list.toSet().size)                  // 2

    // 2-3. Map 의 키로 쓸 수 있다
    val visits = mutableMapOf<BMember, Int>()
    visits[BMember("김철수", "kim@a.com")] = 5
    println(visits[BMember("김철수", "kim@a.com")])              // 5   제대로 찾는다

    // 2-4. 리스트끼리 비교도 내용으로 된다
    val a = listOf(BMember("김철수", "kim@a.com"))
    val b = listOf(BMember("김철수", "kim@a.com"))
    println(a == b)                             // true

    // 2-5. 출력이 읽을 만해진다. 디버깅할 때 이것만으로도 큰 이득이다.
    println(list)
}

// 3. copy - 일부만 바꾼 새 객체
fun b_exam3() {
    val origin = BMember("김철수", "kim@a.com", 20)

    // 이름만 바꾼 새 객체
    val renamed = origin.copy(name = "김영수")
    println(origin)                 // BMember(name=김철수, email=kim@a.com, age=20)
    println(renamed)                // BMember(name=김영수, email=kim@a.com, age=20)

    // 인자를 하나도 안 주면 그대로 복사한 새 객체가 나온다
    val cloned = origin.copy()
    println(cloned == origin)       // true    내용은 같고
    println(cloned === origin)      // false   객체는 다르다

    // copy 는 '고치는' 대신 '새로 만드는' 방식이다.
    // 원본이 그대로 남으므로, 여러 곳에서 같은 객체를 공유해도 안전하다.
    val members = listOf(
        BMember("김철수", "kim@a.com", 20),
        BMember("이영희", "lee@a.com", 30)
    )

    // 모두의 나이를 한 살씩 올린 '새 리스트'를 만든다. 원본은 건드리지 않는다.
    val aged = members.map { it.copy(age = it.age + 1) }
    println(members)                // 나이 20, 30
    println(aged)                   // 나이 21, 31

    // 주의! copy 는 얕은 복사다. 안에 든 컬렉션은 원본과 공유한다.
    // (A_collection 예제 6-3 의 얕은 복사와 같은 이야기다)
}

// 4. 구조분해
fun b_exam4() {

    val member = BMember("김철수", "kim@a.com", 20)

    // 주 생성자에 선언한 순서대로 쪼개진다.
    val (name, email, age) = member
    println("$name, $email, $age")

    // 필요 없는 것은 밑줄로 건너뛴다.
    val (n, _, a) = member
    println("$n, $a")

    // 반복문에서 바로 쪼개기
    val members = listOf(
        BMember("김철수", "kim@a.com", 20),
        BMember("이영희", "lee@a.com", 30)
    )

    for ( (n, e, a) in members ) {
        println("$n, $a - $e")
    }

    // Pair와 Triple 도 같은 원리로 쪼개진다. -> 둘 다 data class로 만들어져 있다.
    val pair = "사과" to 1000
    val ( fruit, price ) = pair
    println("$fruit, $price")

    val tri = Triple(1, "둘", 3.0)
    val (first, second, third) = tri
    println("$first - $second - $third")

    for ((k, v) in mapOf("a" to 1)) println("$k=$v")

}



fun main() {
    b_exam1()
    b_exam2()
    b_exam3()
    b_exam4()
}






















