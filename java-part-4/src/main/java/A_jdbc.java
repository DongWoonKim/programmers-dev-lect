import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class A_jdbc {

    public Connection connection() {

        String url = "jdbc:mysql://localhost:3306/java_basic";
        String user = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conn Success!");

            return connection;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertData(String name, int age, String phone) {
        // sql injection 조사
        String query = "INSERT INTO member (name, age, phone) VALUES (?, ?, ?)";

        try (
                Connection conn = connection();
                PreparedStatement pstmt = conn.prepareStatement( query );
        ) {

            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, phone);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static void main(String[] args) {
        A_jdbc aJdbc = new A_jdbc();
        aJdbc.connection();

    }
}
