import java.util.Arrays;

// * ArrayList : 배열에 물리적으로 나란히 저장
class MyArrayList {

    private String[] arr = new String[10];
    private int size = 0;

    // * 인덱스 접근
    String get(int index) {
        return arr[index];
    }

    // * 맨 뒤에 추가
    void addLast(String data) {
        // 용량이 꽉찼으면 확장후 삽입
        ensureCapacity();
        arr[size++] = data;
    }

    // * 맨 앞에 추가 : 뒤 요소를 전부 한 칸씩 밀어야 자리가 생긴다(느림)
    void addFirst(String data) {
        ensureCapacity();

        for (int i = size; i > 0; i--) {
            arr[i] = arr[i - 1]; // 물리적으로 붙어있으니 통째로 밀기
        }

        arr[0] = data;
        size++;
    }

    // * 길이 반환
    int size() {
        return size;
    }

    // * 자동으로 용량 확장
    private void ensureCapacity() {
        if (size == arr.length) {
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
    }

}

// * LinkedList : 노드가 prev/next 주소를 들고 논리적으로 연결
class MyLinkedList {
    
}

public class A_collections_list_exercise {

    public static void exam1() {
        System.out.println("=== 직접 만든 ArrayList (배열에 물리적으로 나란히) ===");
        MyArrayList arr = new MyArrayList();
        arr.addLast("가");
        arr.addLast("나");
        arr.addLast("다");
        System.out.println("get(2) = " + arr.get(2)
                + "   <- 인덱스로 주소를 바로 계산해서 한 번에 접근");
        arr.addFirst("앞");  // 내부에서 뒤 요소들을 전부 한 칸씩 밀어야 한다
        System.out.println("addFirst(\"앞\") -> 뒤 요소를 한 칸씩 밀어서 0번 자리를 비웠음");
        System.out.println("결과: 0번=" + arr.get(0) + ", 1번=" + arr.get(1) + ", 2번=" + arr.get(2));
    }

    static void main(String[] args) {
        exam1();
    }
}
