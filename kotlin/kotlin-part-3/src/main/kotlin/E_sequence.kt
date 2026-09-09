
// * 시퀀스 - 필요할 때만 계산하기

// 시퀀스는 중간 리스트를 만들지 않고, 원소 하나가 모든 단계를 통과하게 만든다.
// 원소가 몇 개 안되면 상관없지만, 수십만 개라면 리스트를 몇 번씩 새로 만드는 것이 낭비다.

// 1. 즉시 계산과 지연 계산
// [List - 즉시 계산]
// list.filter { } -> 전부 걸러서 리스트를 만든다.
// .map { }        -> 그 리스트를 전부 변환해서 또 리스트를 만든다.
// .first()        -> 그중 첫 번째를 꺼낸다.
// 단계별로 끝까지 다 처리한다. 첫 번째 하나만 필요해도 전부 계산한다.

// [Sequence - 지연 계산]
// 원소 하나가 filter -> map 을 통과하고, 그다음 원소가 다시 filter -> map을 통과한다.
// first()가 답을 얻는 순간 나머지 원소는 아예 건드리지도 않는다.

fun e_isEven(n: Int): Boolean {
    println(" filter($n)")
    return n % 2 == 0
}

fun e_double(n: Int): Int {
    println(" map($n)")
    return n * 2
}

fun e_exam1() {

    val nums = listOf(1, 2, 3, 4, 5, 6)
    println("[List]")
    val r1 = nums.filter { e_isEven(it) }.map { e_double(it) }
    println(r1)
    // filter(1)
    // filter(2)
    // filter(3)
    // filter(4)
    // filter(5)
    // filter(6)
    // map(2)
    // map(4)
    // map(6)
    // filter를 6번 다하고 그 다음 map을 3번 실행한다.

    println("[Sequence]")
    val r2 = nums.asSequence().filter { e_isEven(it) }.map { e_double(it) }.toList()
    println(r2)
    //  filter(1)
    // filter(2) -> map(2)
    // filter(3)
    // filter(4) -> map(4)
    // filter(5)
    // filter(6) -> map(6)
    // 원소 하나가 파이프를 끝까지 통과하고, 그 다음 원소가 들어간다.

    // 결과는 똑같다. 다른 것은 '언제 무엇을 계산하는가'뿐이다.

}

fun main() {
    e_exam1()
}


