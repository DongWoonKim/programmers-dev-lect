
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



