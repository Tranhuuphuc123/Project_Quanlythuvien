/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Texter;


import Data.JDBCutil;
import View.Giaodien_main;
import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
        

/**
 *
 * @author Tran Huu Phuc
 */
public class Kiemdinh {
      public static void main(String[] args) throws SQLException  {
          // ket nois text thu JDBC voi sql
//     java.sql.Connection connection = JDBCutil.ketnoi_JDBC();
           new Giaodien_main();
          
        
      }
}
