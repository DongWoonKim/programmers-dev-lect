package com.example.spring.springtheory.ch04;

// * 예외
// 예외가 발생하면 그것을 catch블록을 써서 잡아내는 것까지는 좋은데,
// 그리고 아무것도 하지 않고 별문제 없는 것처럼 넘어가 버리는 건 정말 위험한 일이다.
// 프로그램 실행 중에 어디선가 예외가 발생했는데 그것을 무시하고 계속 진행해버리기 때문이다.
// 예외를 처리할 때 반드시 지켜야할 핵심 원칙은 한 가지다.
// 모든 예외는 적절하게 복구되든지 아니면 작업을 중단시키고 운영자 또는 개발자에게 분명하게 통보되어야 한다.

// * 예외의 종류 (자바에서 throw 할 수 있는 객체는 모두 Throwable의 자식이다)
//  1) Error
//     - java.lang.Error의 자식. 시스템 레벨의 심각한 오류(OutOfMemoryError 등).
//     - 애플리케이션 코드가 잡아서 대응할 수 있는 게 아니므로 catch 하려 하지 않는다.
//  2) Checked Exception (체크 예외)
//     - Exception의 자식 중 RuntimeException을 '상속하지 않은' 것들(IOException, SQLException 등).
//     - 반드시 catch 하거나 throws로 선언해야 컴파일된다(컴파일러가 강제).
//     - 그래서 잘못 쓰면 아래 '안티패턴'들이 나오기 쉽다.
//  3) Unchecked Exception (언체크 예외, 런타임 예외)
//     - RuntimeException의 자식(NullPointerException, IllegalArgumentException 등).
//     - catch/throws를 강제하지 않는다. 주로 '프로그램의 버그' 성격이라, 복구보다 코드 수정 대상이다.

public class Exception_01 {
    static void main(String[] args) {

    }
}
