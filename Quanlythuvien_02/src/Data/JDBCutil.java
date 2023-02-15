/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tran Huu Phuc
 */
public class JDBCutil {
    public static java.sql.Connection ketnoi_JDBC() {
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
