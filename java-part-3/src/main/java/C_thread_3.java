
// * 싱글스레드 vs 멀티스레드

class C_thread_3_1 extends Thread{
    @Override
    public void run() {
        for ( int i = 0; i < 300; i++ ) {
            System.out.printf("%s ", "|");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("소요시간2 : " + (endTime));
    }
}

public class C_thread_3 {
    static void main(String[] args) {

    }
}
