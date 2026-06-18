
// * I/O Stream (입출력 스트림)
// 자바에서 데이터를 입력받거나 출력할 때 사용하는, 데이터가 흐르는 통로(Stream)이다.
// 스트림은 단방향이라서 입력용(InputStream)과 출력용(OutputStream)이 따로 존재한다.

// * 바이트 스트림 vs 문자 스트림
// - 바이트 스트림 : 1바이트 단위로 데이터를 처리한다. -> 이미지/동영상 등 모든 종류의 데이터는 바이트 스트림
// InputStream, OutputStream
// - 문자 스트림 : 2바이트(문자) 단위로 데이터를 처리한다 -> 텍스트, 문자 스트림이 적합
// Writer, Reader
// -> 스트림 사용후 반드시 close()로 자원을 해제해야한다. -> (try-with-resources)


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class E_input_output_stream {

    private String desktopPath;
    private String folderPath;
    // * java.nio.file 패키지 (NIO)
    //	•	Path: 파일이나 폴더의 경로를 객체로 표현한다.
    //	•	Files: 파일/폴더의 생성, 존재 여부 확인, 삭제 등 유틸리티 메서드를 제공한다.
    private Path myFolder;
    private String today;
    private Path todayFile;

    public E_input_output_stream() {

        // System.getProperty("user.home")은 현재 사용자의 홈 디렉터리 경로를 문자열로 반환한다
        //   - JVM이 실행 환경에서 읽어온 "시스템 프로퍼티" 중 하나다
        //   - Windows면 C:\Users\사용자이름, macOS면 /Users/사용자이름, Linux면 /home/사용자이름 같은 값이다
        //   - 즉 OS나 계정이 달라도 각자의 홈 경로를 알아서 가져온다
        // 여기에 File.separator(OS별 경로 구분자 / 또는 \)와 "Desktop"을 붙여 바탕화면 경로를 만든다
        this.desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        this.folderPath = this.desktopPath + File.separator + "sample";

        // Paths.get(...)은 문자열로 된 경로를 Path 객체로 변환한다
        //   - String은 단순한 글자 덩어리라서 파일/폴더 작업에 바로 쓸 수 없다
        //   - Path 객체로 바꾸면 Files 클래스의 메서드(생성, 존재 확인, 삭제 등)에 넘길 수 있다
        //   - 또 getFileName(), getParent() 같은 경로 전용 기능도 쓸 수 있다
        // 참고: 자바 11 이상에서는 Path.of(folderPath)로 써도 동일하다
        this.myFolder = Path.of(this.folderPath);
    }

    // 1. 폴더 생성
    //	•	Files.notExists(Path) : 해당 경로가 존재하지 않으면 true를 반환
    //	•	Files.createDirectory(Path) : 경로에 해당하는 폴더(디렉터리)를 생성
    public void exam1() {
            try {
                if ( Files.notExists(myFolder) ) {
                    Files.createDirectory(myFolder);
                } else {
                    System.out.println("폴더가 이미 존재합니다.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    // 2. 파일에 내용 쓰기
    public void exam2() {
        // LocalDate.now() : 오늘 날짜를 가져오고, 지정한 패턴("yyyy-MM-dd")의 문자열로 포맷
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // Path.resolve(...) : 기준 경로(myFolder) 뒤에 하위 경로를 이어 붙여 새 Path 생성
        todayFile = myFolder.resolve(today + ".txt");

        if ( Files.notExists(todayFile) ) {

            try ( FileOutputStream fos = new FileOutputStream(todayFile.toFile()) ) {

                String content = "Hello World!";
                fos.write(content.getBytes());
                System.out.println( today + ".txt 파일을 생성하고 내용을 썼습니다." );
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {
            System.out.println( today + ".txt 파일이 이미 존재합니다." );
        }

    }

    static void main(String[] args) {
        E_input_output_stream e = new E_input_output_stream();
        e.exam2();

    }
}











