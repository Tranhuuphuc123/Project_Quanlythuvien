/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

// co so du lieu ket noi với sql thong qua phuong thuc jdbc

import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCutil {
    public static java.sql.Connection ketnoi_JDBC() {
          // xác định đường link và thông số của mySQL
        final String url = "jdbc:mysql://localhost:3306/Quanlythuvien2";
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
