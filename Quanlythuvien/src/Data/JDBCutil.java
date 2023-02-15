package Data;
// kết nối mySQL vói ngôn ngữ java thông qua phương thức JDBC

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutil {
    public static Connection ketnoi_JDBC(){
        // xác định đường link và thông số của mySQL
        final String url = "jdbc:mysql://localhost:3306/Quanlythuvien";
        final String user ="root";
        final String password ="Huuphuc1995ct@";

        try {
            // đưng ký driver method kết nối JDBC
            Class.forName("com.mysql.jdbc.Driver");
            // tiến hành add link đk bên trên vào connection
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
