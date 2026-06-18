
// * I/O Stream (입출력 스트림)
// 자바에서 데이터를 입력받거나 출력할 때 사용하는, 데이터가 흐르는 통로(Stream)이다.
// 스트림은 단방향이라서 입력용(InputStream)과 출력용(OutputStream)이 따로 존재한다.

// * 바이트 스트림 vs 문자 스트림
// - 바이트 스트림 : 1바이트 단위로 데이터를 처리한다. -> 이미지/동영상 등 모든 종류의 데이터는 바이트 스트림
// InputStream, OutputStream
// - 문자 스트림 : 2바이트(문자) 단위로 데이터를 처리한다 -> 텍스트, 문자 스트림이 적합
// Writer, Reader
// -> 스트림 사용후 반드시 close()로 자원을 해제해야한다. -> (try-with-resources)


public class E_input_output_stream {
    static void main(String[] args) {

    }
}
