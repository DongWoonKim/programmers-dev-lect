
// * 반복문
// 어떤 작업이 반복적으로 수행되도록 할 때 사용된다.

public class H_loop {

    /*
        * for 문
        for ( 초기값; 조건식; 증감식 ) {
            // 조건식이 참일 때 수행될 문장들을 적는다.
        }
     */
    public static void exam1() {
        for ( int i = 0; i < 10; i++) {
            System.out.println("cnt : " + i);
        }
    }

    public static void exam2() {
        for ( int i = 1; i < 10; i++ ) {
            System.out.println("2 * " + i + " = " + (2 * i));
        }
    }

    // 중첩
    public static void exam3() {
        for ( int i = 1; i < 3; i++ ) {
            System.out.println("i= " + i);
            for ( int k = 1; k < 5; k++ ) {
                System.out.println("k= " + k);
            }
        }
    }

    // 구구단 : 2단부터 9단까지 중첩for문을 사용해서
    public static void practice1() {
        System.out.println("=== 구구단 전체 ===");
        for ( int dan = 2; dan < 10; dan++ ) {
            System.out.println("=== " + dan + "단 ===");
            for ( int k = 1; k < 10; k++ ) {
                System.out.println(dan + " * " + k + " = " + (dan * k));
            }
        }
    }

    // continue : 1 ~ 100까지 짝수만 출력
    public static void exam4() {
        for ( int i = 1; i <= 100; i++ ) {
            if ( i % 2 != 0 ) {
                // 홀수
                continue;
            }
            // 짝수
            System.out.println(i);
        }
    }

    // break : 1 ~ 100까지 올라가는데, 30에 도달했을 때 멈춤(탈출)
    public static void exam5() {
        for ( int num = 1; num <= 100; num++ ) {
            if ( num == 30 ) {
                break;
            }
            System.out.println(num);
        }

        System.out.println("탈출한다");
    }


    static void main(String[] args) {
        exam5();
    }
}
