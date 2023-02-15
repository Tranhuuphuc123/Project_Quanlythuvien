/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Data.JDBCutil;
import Model.Quanlysach_Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Huu Phuc
 */
public class DAO_Controller {
    
    /* xây dựng mehtod getAlluser lấy dữ liệu table Quanlysach từ mySQL vào bên table của java giao diện hiển thị lên*/
    public List<Quanlysach_Model> getAllusers(){
        List<Quanlysach_Model> quanlysach_Models = new ArrayList<Quanlysach_Model>();
        Connection connection = JDBCutil.ketnoi_JDBC();

        // khai báo câu lệnh sql
        String sql = "select * from Quanlysach";


        try {
            //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            // trả kết quả khi nhận câu lệnh truy vấn sql
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Quanlysach_Model quanlysach_Model=new Quanlysach_Model();
                quanlysach_Model.setMaSach(rs.getString("maSach"));
                quanlysach_Model.setTenSach(rs.getString("tenSach"));
                quanlysach_Model.setLoaiSach(rs.getString("loaiSach"));
                quanlysach_Model.setNhaXuatBan(rs.getString("nhaXuatBan"));
                quanlysach_Model.setTacGia(rs.getString("tacGia"));
                quanlysach_Model.setSoLuong(rs.getInt("soLuong"));

                //add các trường cột mới khai báo vào List để nó hiển thị với dạng mảng ds
                quanlysach_Models.add(quanlysach_Model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  quanlysach_Models;
    }


    // method insert them moi dl nhap tu ban phim vao trong sql va hien thilen table o giao dien hien thi

       public void Insert_Quanlysach(Quanlysach_Model quanlysach_Model){
          Connection connection = JDBCutil.ketnoi_JDBC();
            String sql ="insert into Quanlysach(maSach, tenSach, loaiSach, nhaXuatBan, tacGia" +
                    ", soLuong) values(?,?,?,?,?,?)";

            // add vao statement cau lenh sql
           try {
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setString(1,quanlysach_Model.getMaSach());
               preparedStatement.setString(2,quanlysach_Model.getTenSach());
               preparedStatement.setString(3,quanlysach_Model.getLoaiSach());
               preparedStatement.setString(4,quanlysach_Model.getNhaXuatBan());
               preparedStatement.setString(5,quanlysach_Model.getTacGia());
               preparedStatement.setInt(6, quanlysach_Model.getSoLuong());

               int rs =preparedStatement.executeUpdate();
               System.out.println(rs);

           } catch (SQLException e) {
               e.printStackTrace();
           }
       }



       // chức năng xóa dữ liệu

      public void Delete_Quanlysach(String maSach){
        Connection connection = JDBCutil.ketnoi_JDBC();
        String sql = "DELETE from Quanlysach  where maSach =?";

        // add vaof staement cau lenh sql
          try {
              PreparedStatement preparedStatement=connection.prepareStatement(sql);
              preparedStatement.setString(1,maSach);
              int rs = preparedStatement.executeUpdate();
              System.out.println(rs);
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }



      // chư năng update cập nhật sữa dữ liêu
     public void Update_Quanlysach(Quanlysach_Model quanlysach_Model){
        Connection connection = JDBCutil.ketnoi_JDBC();
        String sql = "update Quanlysach set maSach =?, tenSach =?, loaiSach=?, nhaXuatBan=?" +
                "tacGia=?, soLuong=? where maSach=?";

        // add vao statement doi tuong cua cau lenh sql
         PreparedStatement preparedStatement= null;
         try {
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(6,quanlysach_Model.getMaSach());
             preparedStatement.setString(2,quanlysach_Model.getTenSach());
             preparedStatement.setString(3,quanlysach_Model.getLoaiSach());
             preparedStatement.setString(4,quanlysach_Model.getNhaXuatBan());
             preparedStatement.setString(5,quanlysach_Model.getTacGia());
             preparedStatement.setInt(5,quanlysach_Model.getSoLuong());

             int rs = preparedStatement.executeUpdate();
             System.out.println(rs);

         } catch (SQLException e) {
             e.printStackTrace();
         }

     }



     /* xay dung ham lay dl phuc vu bang edit con ua du lieu-> nghia la bam chon dong can update mo hop thoai
     edit de sua update lai du lieu thi luc nay mo len hop thoai edit nos se xuat thong tin cua dong minh
     muon sua
    * */
     public Quanlysach_Model getUserByMa(String maSach){
         Connection connection = JDBCutil.ketnoi_JDBC();

         // khai báo câu lệnh sql
         String sql = "select * from Quanlysach where maSach =?";


         try {
             //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
             PreparedStatement preparedStatement=connection.prepareStatement(sql);
             preparedStatement.setString(1,maSach);
             // trả kết quả khi nhận câu lệnh truy vấn sql
             ResultSet rs = preparedStatement.executeQuery();
             while (rs.next()){
                 Quanlysach_Model quanlysach_Modell=new Quanlysach_Model();
                 quanlysach_Modell.setMaSach(rs.getString("maSach"));
                 quanlysach_Modell.setTenSach(rs.getString("tenSach"));
                 quanlysach_Modell.setLoaiSach(rs.getString("loaiSach"));
                 quanlysach_Modell.setNhaXuatBan(rs.getString("nhaXuatBan"));
                 quanlysach_Modell.setTacGia(rs.getString("tacGia"));
                 quanlysach_Modell.setSoLuong(rs.getInt("soLuong"));

                 //add các trường cột mới khai báo vào List để nó hiển thị với dạng mảng ds
                 return  quanlysach_Modell;
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return  null;
     }

}
