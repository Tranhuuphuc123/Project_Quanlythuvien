package Controller;

import Data.JDBCutil;
import Model.Sach_Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// controller : DAO(Data Access Object nơi thực thi các câu lệnh truy vấn sql vào database của Mysql bên trong java )

//start DAO
public class DAO_controller {

    /* xây dựng mehtod getAlluser lấy dữ liệu table Quanlysach từ mySQL vào bên table của java giao diện hiển thị lên*/
    public List<Sach_Model> getAllusers(){
        List<Sach_Model> sach_models = new ArrayList<Sach_Model>();
        Connection connection = JDBCutil.ketnoi_JDBC();

        // khai báo câu lệnh sql
        String sql = "select * from Quanlysach";


        try {
            //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            // trả kết quả khi nhận câu lệnh truy vấn sql
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Sach_Model sach_model=new Sach_Model();
                sach_model.setMaSach(rs.getString("maSach"));
                sach_model.setTenSach(rs.getString("tenSach"));
                sach_model.setLoaiSach(rs.getString("loaiSach"));
                sach_model.setNhaXuatBan(rs.getString("nhaXuatBan"));
                sach_model.setTacGia(rs.getString("tacGia"));
                sach_model.setSoLuong(rs.getInt("soLuong"));

                //add các trường cột mới khai báo vào List để nó hiển thị với dạng mảng ds
                sach_models.add(sach_model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  sach_models;
    }


    // method insert them moi dl nhap tu ban phim vao trong sql va hien thilen table o giao dien hien thi

       public void Insert_Quanlysach(Sach_Model sach_model){
          Connection connection = JDBCutil.ketnoi_JDBC();
            String sql ="insert into Quanlysach(maSach, tenSach, loaiSach, nhaXuatBan, tacGia" +
                    ", soLuong) values(?,?,?,?,?,?)";

            // add vao statement cau lenh sql
           try {
               PreparedStatement preparedStatement = connection.prepareStatement(sql);
               preparedStatement.setString(1,sach_model.getMaSach());
               preparedStatement.setString(2,sach_model.getTenSach());
               preparedStatement.setString(3,sach_model.getLoaiSach());
               preparedStatement.setString(4,sach_model.getNhaXuatBan());
               preparedStatement.setString(5,sach_model.getTacGia());
               preparedStatement.setInt(6, sach_model.getSoLuong());

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
     public void Update_Quanlysach(Sach_Model sach_model){
        Connection connection = JDBCutil.ketnoi_JDBC();
        String sql = "update Quanlysach set maSach =?, tenSach =?, loaiSach=?, nhaXuatBan=?" +
                "tacGia=?, soLuong=? where maSach maSach =?";

        // add vao statement doi tuong cua cau lenh sql
         PreparedStatement preparedStatement= null;
         try {
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1,sach_model.getMaSach());
             preparedStatement.setString(2,sach_model.getTenSach());
             preparedStatement.setString(3,sach_model.getLoaiSach());
             preparedStatement.setString(4,sach_model.getNhaXuatBan());
             preparedStatement.setString(5,sach_model.getTacGia());
             preparedStatement.setInt(6,sach_model.getSoLuong());

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
     public Sach_Model getUserByMa(String maSach){
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
                 Sach_Model sach_model=new Sach_Model();
                 sach_model.setMaSach(rs.getString("maSach"));
                 sach_model.setTenSach(rs.getString("tenSach"));
                 sach_model.setLoaiSach(rs.getString("loaiSach"));
                 sach_model.setNhaXuatBan(rs.getString("nhaXuatBan"));
                 sach_model.setTacGia(rs.getString("tacGia"));
                 sach_model.setSoLuong(rs.getInt("soLuong"));

                 //add các trường cột mới khai báo vào List để nó hiển thị với dạng mảng ds
                 return  sach_model;
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return  null;
     }



    //end DAO
}
