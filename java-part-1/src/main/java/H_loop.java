
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

    }

    // 1 ~ 100까지 짝수만 출력



    static void main(String[] args) {
        exam3();
    }
}
