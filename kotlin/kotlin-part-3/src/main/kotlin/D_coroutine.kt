import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

// * 동시성과 코루틴

// 0. 코루틴은 코틀린 표준 라이브러리가 아니라 별도 라이브러리다.

// 1. 스레드의 문제
// 자바에서 동시에 여러 일을 하려면 스레드를 만들었다. 그런데 스레드는 비싸다.
// - 하나에 1mb 안팎의 메모리를 쓴다. 수천 개를 쓰면 메모리가 바닥난다.
// - 스레드를 바꿔 가며 실행하는 데(컨텍스트 스위칭) 비용이 든다.
// - Thread.sleep 으로 기다리는 동안 그 스레드는 아무 일도 못 하고 묶여 있다.

// 2. 코루틴이란
// 중단(suspend)했다가 다시 나중에 재개할 수 있는 작업 단위이다. 흔히 '경량 스레드'라고 부른다.
// 코루틴은 스레드를 '대신'하는 것이 아니라 스레드 '위에서' 돌아간다.
// 서버에 요청을 보내 놓고 응답을 기다리는 상황을 생각해보자.

// [스레드]
// 응답이 올 때까지 그 일을 맡은 스레드는 아무것도 못 하고 붙잡혀 있다.
// 일은 안 하는데 자리만 차지하고 앉아 있는 것이다.
// 스레드가 200개면 동시에 200명까지가 끝이고, 201번째 사람은 앞이 끝나야 시작한다.
// 200개 전부가 '그냥 기다리는 중'인데도 그렇다.

// [코루틴]
// 기다려야 하면 "여기까지 했다"를 적어 두고 스레드에서 내려온다.
// 빈 스레드는 곧바로 다른 코루틴의 일을 하러 간다.
// 응답이 오면 적어 둔 것을 보고 다음 줄부터 이어서 한다.
// 기다리는 동안은 자리를 차지 하지 않으니, 스레드 4개로도 코루틴 1만개를 감당한다.

// 3. suspend 함수
// fun 앞에 suspend를 붙이면 "이 함수는 도중에 멈췄다 다시 시작할 수 있다"라는 뜻이다.
// - suspend 함수는 다른 suspend함수 안에서만 부를 수 있다.
// - 시작점이 필요하다. 그 시작점을 만들어 주는 것이 코루틴 빌더이다.

// 종류

// 4. 코루틴 빌더
// - runBlocking { } : 보통함수 안에서 suspend함수를 부를 수 있게 해준다.
// 안의 코루틴이 전부 끝날 때까지, 이것을 부른 스레드는 그 자리에 붙잡혀있다.
// 다음 줄로 넘어가지도, 다른 일을 하지도 못한다. Thread.sleep 과 같은 상태다
// - launch { } : 결과가 필요 없는 일을 띄운다.
// - async { } : 결과가 필요한 일을 띄운다. Deferred를 돌려주고 await()로 결과를 받는다.
// * launch 와 async는 아무 데서나 못 쓴다. CoroutineScope 안에서만 쓸 수 있다.

// 5. 구조화된 동시성
// 코루틴은 항상 어떤 스코프에 소속된다. 그래서 이런 것이 저절로 보장된다.
// - 부모는 자식이 전부 끝날 때까지 기다린다. (누가 아직 도는지 몰라도 된다.)
// - 부모를 취소하면 자식이 전부 취소된다.
// - 자식 하나가 예외로 죽으면 형제와 부모까지 취소된다.

// 1. 스레드와 코루틴의 무게 차이
fun d_exam1() {

    val threadTime = measureTimeMillis {
        val threads = List(10_000) {
            // apply 없이 .start()라고 쓰면 start()의 반환값인 Unit이 담겨 join을 부를 수 없다.
            // apply는 블록을 실행한 뒤 자기 자신을 돌려준다.
            Thread { Thread.sleep(100) }.apply { start() }
        }

        // join : 스레드가 끝날 때까지 기다린다.
        threads.forEach { it.join() }
    }
    println("스레드 1만 개 : ${threadTime}ms")

    val coroutineTime = measureTimeMillis {
        // runBlocking은 코루틴을 시작시키는 자리다. 이 중괄호 안이 코루틴 한 개(부모)다
        runBlocking {
            // repeat(n) {} : 블록을 n번 실행하는 반복문이다.
            repeat(100_000) {
                launch {
                    delay(100)
                }
            }

        }

    }
    println("코루틴 10만 개 : ${coroutineTime}ms")
}

fun main() {
    d_exam1()
}

























