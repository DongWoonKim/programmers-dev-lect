
// * 컬렉션 - List, Set, Map

// 1. 자바와 차이점
//   [자바]                                    [코틀린]
//   new ArrayList<>()                      -> mutableListOf()      new 가 없다
//   Arrays.asList(1, 2, 3)                 -> listOf(1, 2, 3)
//   list.get(0) / list.set(0, x)           -> list[0] / list[0] = x
//   map.get(k) / map.put(k, v)             -> map[k] / map[k] = v
//   list.size() / map.size()               -> list.size            프로퍼티라 괄호가 없다
//   list.contains(x)                       -> x in list
//   map.containsKey(k)                     -> k in map
//   for (Map.Entry<K,V> e : m.entrySet())  -> for ((k, v) in m)    구조 분해
//   list.stream().filter(..).collect(..)   -> list.filter { .. }   stream() 이 필요 없다
//   Collections.unmodifiableList(list)     -> 자료형을 List 로 적으면 끝
//
// * 가장 큰 차이는 마지막 줄이다. 코틀린은 '읽기 전용'을 자료형으로 나눠 놓았다.

// 2. 읽기 전용과 가변
//   자바의 List 는 하나뿐이라, 어떤 리스트를 받든 add 를 부를 수 있었다.
//   막으려면 unmodifiableList 로 감싸야 했고, 그래도 add 를 부르는 것은 컴파일이 됐다.
//   (실행 중에 UnsupportedOperationException 이 나서야 알게 된다)
//
//   코틀린은 자료형 자체가 두 갈래다.
//     List<T>          꺼내 볼 수만 있다. add/remove 가 아예 존재하지 않는다.
//     MutableList<T>   넣고 빼고 바꿀 수 있다.  (MutableList 는 List 의 자식이다)
//     Set / MutableSet,  Map / MutableMap 도 같은 구조다.
//
//   함수 매개변수를 List 로 적으면 "이 함수는 목록을 건드리지 않는다"를 컴파일러가 보장한다.
//
//   [만드는 함수]
//     읽기 전용   listOf()       setOf()       mapOf()
//     가변        mutableListOf()  mutableSetOf()  mutableMapOf()
//     자바 구현체  arrayListOf()  hashSetOf() / linkedSetOf() / sortedSetOf()
//                                hashMapOf() / linkedMapOf() / sortedMapOf()
//
//   * mutableListOf 는 내부적으로 ArrayList 를, mutableSetOf/mutableMapOf 는
//     LinkedHashSet/LinkedHashMap 을 만든다. 그래서 넣은 순서가 유지된다.
//     특별한 이유가 없으면 mutable~Of 를 쓰면 된다.

// 3. 읽기 전용은 '불변'이 아니다
//   MutableList 를 List 자리에 넣으면 '읽기 전용 창'이 하나 생길 뿐, 원본은 그대로 살아 있다.
//   원본을 가진 쪽이 값을 바꾸면 그 창으로도 바뀐 값이 보인다.
//   정말 바뀌지 않게 하려면 toList() 로 복사본을 만들어 넘겨야 한다.

// 4. null 을 대하는 방식
//   자바는 없는 값을 물으면 대체로 null 이 나왔고, 그것을 확인하는 것은 개발자 몫이었다.
//   코틀린은 반환 자료형에 ? 가 붙어 있어 확인하지 않으면 컴파일이 되지 않는다.
//     map["없는키"]        -> V?      null 이 나온다
//     list.getOrNull(99)  -> T?      예외 대신 null
//     list[99]            -> T       없으면 예외 (자바와 같다)
//   "없을 때 무엇을 돌려줄지"를 고르는 함수들이 짝으로 준비되어 있다.
//     getOrNull / getOrElse { } / getOrDefault / getOrPut { } / first / firstOrNull

val a_prices = mapOf( "아메리카노" to 4500, "카페라떼" to 5000, "바닐라라떼" to 5500 )

class APoint(val x: Int, val y: Int) {
    override fun toString() = "($x, $y)"
}


// 1. 자바와 달라지는 표기
fun a_exam1() {

    val list = mutableListOf("사과", "바나나")
    list.add("포도")
    println(list[0])
    list[0] = "체리"
    println(list.size)
    println( "포도" in list ) // contains
    println(list)

    // == 가 내용을 비교한다. 자바의 equals에 해당
    println( listOf(1, 2) == listOf(1, 2) ) // true
    println( arrayOf(1, 2) == arrayOf(1, 2)) // false 배열은 여전히 주소를 비교한다.

    println( arrayOf(1, 2) )
    println( listOf(1, 2) )

    // 만드는 방법들
    println(emptyList<Int>())                   // []       비어 있으면 자료형을 적어 준다
    println(listOfNotNull(1, null, 3))          // [1, 3]   null 을 걸러 내며 만들기
    println(List(5) { it * it })                // [0, 1, 4, 9, 16]
    println((1..5).toList())                    // [1, 2, 3, 4, 5]
    println(arrayOf(1, 2, 2).toSet())           // [1, 2]   변환하며 중복 제거

}

// 2. 읽기 전용과 가변
fun a_exam2() {

    val readOnly = listOf(1, 2, 3)
//    readOnly.add(4)
//    readOnly[0] = 100

    val mutable = mutableListOf(1, 2, 3)
    mutable.add(4)
    mutable[0] = 100
    println(mutable)

    // val : 변수 이름이 다른 객체를 가리키지 못하게 막는다.
    // List : 그 객체의 내용을 바꾸지 못하게 막는다.
    val a = mutableListOf(1, 2, 3)
    a.add(4)
//    a = mutableListOf(1, 2, 3)

    // 읽기 전용은 불변이 아니다
    val origin = mutableListOf(1, 2, 3)
    val view: List<Int> = origin        // 읽기 전용 '창'을 낸 것뿐이다
    origin.add(4)
    println(view)                       // [1, 2, 3, 4]   같이 바뀐다!
    println(view === origin)            // true           같은 객체다

    val copy = origin.toList()          // 이 순간의 내용을 복사한 새 리스트
    origin.add(5)
    println("$origin / $copy")          // [1,2,3,4,5] / [1,2,3,4]

    // 2-3. 안에서는 가변으로 만들고, 밖으로는 읽기 전용으로 내보내는 것이 정석이다
    fun makeList(): List<Int> {
        val result = mutableListOf<Int>()
        for (i in 1..3) result.add(i)
        return result.toList()          // toList() 를 빼면 원본과 이어져 있다
    }
    println(makeList())                 // [1, 2, 3]

}


fun main() {
    a_exam1()
    a_exam2()
}


























