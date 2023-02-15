/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

// thuc hien truy van du lieu dau vao tu java ket hop coi ngon ngu sql

import Data.JDBCutil;
import Model.Dangky_Acount;
import Model.Maloaisach;
import Model.Quanlybandoc_Model;
import Model.Quanlymuontra;
import Model.Quanlytiemkiem;
import Model.Sach_Model;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
//---------------------------------------------------------------------------------------------------------------------------------------------------

public class DAO_Controller {
    

    /* xây dựng mehtod getAlluser lấy dữ liệu table ListSach từ mySQL vào bên table của java giao diện hiển thị lên*/
            public List<Sach_Model> getAllusers(){
                List<Sach_Model> sach_Models = new ArrayList<Sach_Model>();
                Connection connection = JDBCutil.ketnoi_JDBC();

                try {
                     // khai báo câu lệnh sql
                      String sql = "select * from  ListSach";
                    //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
                    PreparedStatement preparedStatement=connection.prepareStatement(sql);
                    // trả kết quả khi nhận câu lệnh truy vấn sql
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()){
                        Sach_Model sach_Model = new Sach_Model();
                        sach_Model.setMaSach(rs.getString("maSach"));
                        sach_Model.setTenSach(rs.getString("tenSach"));
                        sach_Model.setTacGia(rs.getString("tacGia"));
                        sach_Model.setMaLoai(rs.getString("maLoai"));
                        sach_Model.setGiaSach(rs.getDouble("giaSach"));
                       sach_Model.setSoLuong(rs.getInt("soLuong"));

                        //add các trường cột mới khai báo vào List để nó hiển thị với dạng mảng ds
                      sach_Models.add(sach_Model);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return  sach_Models;
            }
    
    
//---------------------------------------------------------------------------------------------------------------------------------------------------
            
            /* xây dựng method để lấy load dữ liệu từ table Maloaisach*/
    
        public ArrayList<Maloaisach> getAllusers2(){
           ArrayList<Maloaisach> maloaisachs = new ArrayList<Maloaisach>();
            Connection connection = JDBCutil.ketnoi_JDBC();
            try {
                     // khai báo câu lệnh sql
                      String sql = "select * from  Maloaisach";
                    //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
                    PreparedStatement preparedStatement=connection.prepareStatement(sql);
                    // trả kết quả khi nhận câu lệnh truy vấn sql
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()){
                        Maloaisach maloaisach = new Maloaisach();
                        maloaisach.setMaLoai(rs.getString("maLoai"));
                        maloaisach.setTenloai(rs.getString("tenLoai"));

                        //add các trường cột mới khai báo vào List để nó hiển thị với dạng mảng ds
                      maloaisachs.add(maloaisach);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return  maloaisachs;
        }
        
        
      //---------------------------------------------------------------------------------------------------------------------------------------------------  
      
            // chức năng load dữ liệu lên combox trong giao dien Main

                   public ArrayList<String> getLoad_ComboxSach(){
                        ArrayList<String> List_maLoai = new ArrayList<String>();
                         Connection connection = JDBCutil.ketnoi_JDBC();
                         try {
                                  // khai báo câu lệnh sql
                                   String sql = "select maLoai from Maloaisach";
                                 //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
                                 PreparedStatement preparedStatement=connection.prepareStatement(sql);
                                 // trả kết quả khi nhận câu lệnh truy vấn sql
                                 ResultSet rs = preparedStatement.executeQuery();
                                 while (rs.next()){
                                     List_maLoai.add(rs.getString("maLoai"));
                                 }
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }
                             return  List_maLoai;
                        }            
                                    
                        
                // load cho combobox maSach ben panel quanlymuontra -> maSach
                    public ArrayList<String> getLoad_ComboxMuontra_maSach(){
                        ArrayList<String> List_QLmuontra_maSach = new ArrayList<String>();
                         Connection connection = JDBCutil.ketnoi_JDBC();
                         try {
                                  // khai báo câu lệnh sql
                                   String sql = "select maSach from ListSach order by maSach";
                                 //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
                                 PreparedStatement preparedStatement=connection.prepareStatement(sql);
                                 // trả kết quả khi nhận câu lệnh truy vấn sql
                                 ResultSet rs = preparedStatement.executeQuery();
                                 while (rs.next()){
                                     List_QLmuontra_maSach.add(rs.getString("maSach"));
                                 }
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }
                             return  List_QLmuontra_maSach;
                        }      
                    
                    
                     // load cho combobox maSach ben panel quanlymuontra -> maBandoc
                    public ArrayList<String> getLoad_ComboxMuontra_maBandoc(){
                        ArrayList<String> List_QLmuontra_mabandoc = new ArrayList<String>();
                         Connection connection = JDBCutil.ketnoi_JDBC();
                         try {
                                  // khai báo câu lệnh sql
                                   String sql = "select maBandoc from  ListBandoc";
                                 //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
                                 PreparedStatement preparedStatement=connection.prepareStatement(sql);
                                 // trả kết quả khi nhận câu lệnh truy vấn sql
                                 ResultSet rs = preparedStatement.executeQuery();
                                 while (rs.next()){
                                     List_QLmuontra_mabandoc.add(rs.getString("maBandoc"));
                                 }
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }
                             return  List_QLmuontra_mabandoc;
                        }      
                   
                   
    //----------------------------------------------------------------------------------------  
                   
             // load du lieu tu sql table quanlymuontra len table_Quanlymuontra  
                        public ArrayList<Quanlymuontra> getAllMuontra(){
                        ArrayList<Quanlymuontra> quanlymuontras = new ArrayList<Quanlymuontra>();
                         Connection connection = JDBCutil.ketnoi_JDBC();
                         try {
                                  // khai báo câu lệnh sql
                                   String sql = "select * from  Quanlymuontra";
                                 //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
                                 PreparedStatement preparedStatement=connection.prepareStatement(sql);
                                 // trả kết quả khi nhận câu lệnh truy vấn sql
                                 ResultSet rs = preparedStatement.executeQuery();
                                 while (rs.next()){
                                     Quanlymuontra quanlymuontra = new Quanlymuontra();
                                     quanlymuontra.setMaSach(rs.getString("maSach"));
                                     quanlymuontra.setMaBandoc(rs.getString("maBandoc"));
                                     quanlymuontra.setNgayMuon(rs.getString("ngayMuon"));
                                     quanlymuontra.setNgayTra(rs.getString("ngayTra"));
                                     quanlymuontra.setTinhTrang(rs.getString("tinhTrang"));

                                     //add các trường cột mới khai báo vào List để nó hiển thị với dạng mảng ds
                                   quanlymuontras.add(quanlymuontra);
                                 }
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }
                             return  quanlymuontras;
                     }
                        
  
     // load du lieu table view Quanlytiemkiem len tbale giao dien
                   public ArrayList<Quanlytiemkiem> getAllTiemkiem(){
                        ArrayList<Quanlytiemkiem> quanlytiemkiems = new ArrayList<Quanlytiemkiem>();
                         Connection connection = JDBCutil.ketnoi_JDBC();
                         try {
                                  // khai báo câu lệnh sql
                                   String sql = "select * from Quanlytiemkiem";
                                 //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
                                 PreparedStatement preparedStatement=connection.prepareStatement(sql);
                                 // trả kết quả khi nhận câu lệnh truy vấn sql
                                 ResultSet rs = preparedStatement.executeQuery();
                                 while (rs.next()){
                                     Quanlytiemkiem quanlytiemkiem = new Quanlytiemkiem();
                                     quanlytiemkiem.setMaSach(rs.getString("maSach"));
                                      quanlytiemkiem.setTenSach(rs.getString("tenSach"));
                                       quanlytiemkiem.setMaBandoc(rs.getString("maBandoc"));
                                        quanlytiemkiem.setTenBandoc(rs.getString("tenBandoc"));
                                         quanlytiemkiem.setNgayMuon(rs.getString("ngayMuon"));
                                          quanlytiemkiem.setNgayTra(rs.getString("ngayTra"));
                                           quanlytiemkiem.setTinhTrang(rs.getString("tinhTrang"));

                                     //add các trường cột mới khai báo vào List để nó hiển thị với dạng mảng ds
                                   quanlytiemkiems.add(quanlytiemkiem);
                                 }
                             } catch (SQLException e) {
                                 e.printStackTrace();
                             }
                             return  quanlytiemkiems;
                     }      
                   
                   
                   
                   
  //---------------------------------------------------------------------------------------------------------------------------------------------------  
    // method insert them moi dl nhap tu ban phim vao trong sql va hien thilen table o giao dien hien thi

            public void Insert_Quanlysach(Sach_Model sach_Modell){
               Connection connection = JDBCutil.ketnoi_JDBC();
                 // add vao statement cau lenh sql
                try {
                     String sql ="insert into ListSach(maSach, tenSach, tacGia, maLoai, giaSach, soLuong ) values(?,?,?,?,?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,sach_Modell.getMaSach());
                    preparedStatement.setString(2,sach_Modell.getTenSach());
                    preparedStatement.setString(3,sach_Modell.getTacGia());
                    preparedStatement.setString(4,sach_Modell.getMaLoai());
                    preparedStatement.setDouble(5,sach_Modell.getGiaSach());
                    preparedStatement.setInt(6, sach_Modell.getSoLuong());

                    int rs =preparedStatement.executeUpdate();
                    System.out.println(rs);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            
            
            
               // method insert them moi dl ch bang Maloaisach

            public void Insert_Maloaisach(Maloaisach maloaisach){
               Connection connection = JDBCutil.ketnoi_JDBC();
                 // add vao statement cau lenh sql
                try {
                     String sql ="insert into Maloaisach(maLoai, tenLoai ) values(?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,maloaisach.getMaLoai());
                    preparedStatement.setString(2,maloaisach.getTenLoai());

                    int rs =preparedStatement.executeUpdate();
                    System.out.println(rs);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    
            
     //---------------------------------------------------------------------------------------------------------------------------------------------------       
            
              // chức năng xóa dữ liệu

                    public void Delete_Quanlysach(String maSach){
                      Connection connection = JDBCutil.ketnoi_JDBC();
                   
                      // add vaof staement cau lenh sql
                        try {
                              String sql = "DELETE from ListSach  where maSach = ?" ;
                            PreparedStatement preparedStatement=connection.prepareStatement(sql);
                            preparedStatement.setString(1,maSach);
                            int rs = preparedStatement.executeUpdate();
                            System.out.println(rs);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    
                    
                    
              // xoa du lieu bang Maloaisach
                    public void Delete_Maloaisach(String maLoai){
                      Connection connection = JDBCutil.ketnoi_JDBC();
                   
                      // add vaof staement cau lenh sql
                        try {
                              String sql = "DELETE from Maloaisach  where maLoai = ?" ;
                            PreparedStatement preparedStatement=connection.prepareStatement(sql);
                            preparedStatement.setString(1,maLoai);
                            int rs = preparedStatement.executeUpdate();
                            System.out.println(rs);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    
       //---------------------------------------------------------------------------------------------------------------------------------------------------             
                    
            // Phương thức Update
                    
                      // chư năng update cập nhật sữa dữ liêu
                        public void Update_Quanlysach(Sach_Model sach_Model){
                           Connection connection = JDBCutil.ketnoi_JDBC();
                               
                            try {
                                
                                  String sql = "update ListSach set  tenSach =?,  tacGia=?,  giaSach=?" +
                                   ", soLuong=?   where maSach= ?";
                                  // add vao statement doi tuong cua cau lenh sql
                                PreparedStatement preparedStatement= connection.prepareStatement(sql);
                             
                             
                                preparedStatement.setString(1,sach_Model.getTenSach());
                                preparedStatement.setString(2,sach_Model.getTacGia());
//                                preparedStatement.setString(3,sach_Model.getMaLoai());
                                preparedStatement.setDouble(3,sach_Model.getGiaSach());
                                preparedStatement.setInt(4,sach_Model.getSoLuong());
                                preparedStatement.setString(5,sach_Model.getMaSach());

                                int rs = preparedStatement.executeUpdate();
                                System.out.println(rs);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }
                        
                        
                        
              //---------------------------------------------------------------bo sung cho panel Quanlysach_ Maloaisach------------------------------------------------------------------------------------        
                          
        // getAllMabandoc them du lieu load sql len table ma ban doc
          public ArrayList<Quanlybandoc_Model> getAllMabandocs(){
           ArrayList<Quanlybandoc_Model> quanlybandoc_Models = new ArrayList<Quanlybandoc_Model>();
            Connection connection = JDBCutil.ketnoi_JDBC();
            try {
                     // khai báo câu lệnh sql
                      String sql = "select * from  ListBandoc";
                    //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
                    PreparedStatement preparedStatement=connection.prepareStatement(sql);
                    // trả kết quả khi nhận câu lệnh truy vấn sql
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()){
                        Quanlybandoc_Model quanlybandoc_Model = new Quanlybandoc_Model();
                        quanlybandoc_Model.setMaBandoc(rs.getString("mabandoc"));
                        quanlybandoc_Model.setTenBandoc(rs.getString("tenBandoc"));
                        quanlybandoc_Model.setCMND(rs.getString("CMND"));
                        quanlybandoc_Model.setGioiTinh(rs.getString("gioiTinh"));
                        quanlybandoc_Model.setNgayDangky(rs.getString("ngayDangky"));
                        quanlybandoc_Model.setNgayHethan(rs.getString("ngayHethan"));

                        //add các trường cột mới khai báo vào List để nó hiển thị với dạng mảng ds
                      quanlybandoc_Models.add(quanlybandoc_Model);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return  quanlybandoc_Models;
        }
          
          
      //---------------------------------------------------------------------------------------------------------------------------------------------------    
                        
                        

                   
             
//-------------------------------Phan code cua panel_Quanlybandoc---------------------------------------------------------------------------             
    // chức năng của bản Quanlybandoc
                        
     //*******insert dang ky ban doc
                 public void Dangkybandoc(Quanlybandoc_Model bandoc_model){
               Connection connection = JDBCutil.ketnoi_JDBC();
                 // add vao statement cau lenh sql
                try {
                     String sql ="insert into ListBandoc(maBandoc, tenBandoc, CMND, gioiTinh, ngayDangky, ngayHethan ) values(?,?,?,?,?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,bandoc_model.getMaBandoc());
                    preparedStatement.setString(2,bandoc_model.getTenBandoc());
                    preparedStatement.setString(3,bandoc_model.getCMND());
                    preparedStatement.setString(4,bandoc_model.getGioiTinh());
                    preparedStatement.setString(5,bandoc_model.getNgayDangky());
                    preparedStatement.setString(6, bandoc_model.getNgayHethan());

                    int rs =preparedStatement.executeUpdate();
                    System.out.println(rs);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
      
                 
     //---------------------------------------------------------------------------------------------------------------------------------------------------             
    // chức năng của xoa Quanlybandoc     
                 
                 
                  public void Delete_Quanlybandoc(String maBandoc){
                      Connection connection = JDBCutil.ketnoi_JDBC();
                   
                      // add vaof staement cau lenh sql
                        try {
                              String sql = "DELETE from ListBandoc  where maBandoc = ?" ;
                            PreparedStatement preparedStatement=connection.prepareStatement(sql);
                            preparedStatement.setString(1,maBandoc);
                            int rs = preparedStatement.executeUpdate();
                            System.out.println(rs);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
    
                  
     //---------------------------------------------------------------------------------------------------------------------------------------------------             
    // chức năng của update sữa chữa ban độc
                  
                  public void Update_Quanlybandoc(Quanlybandoc_Model quanlybandoc_Model){
                           Connection connection = JDBCutil.ketnoi_JDBC();
                               
                            try {
                                
                                  String sql = "update ListBandoc set  tenBandoc =?,  CMND=?,  gioiTinh=?" +
                                   ", ngayDangky=? , ngayHethan=?  where maBandoc= ?";
                                  // add vao statement doi tuong cua cau lenh sql
                                PreparedStatement preparedStatement= connection.prepareStatement(sql);
                             
                             
                                preparedStatement.setString(1,quanlybandoc_Model.getTenBandoc());
                                preparedStatement.setString(2,quanlybandoc_Model.getCMND());
                                preparedStatement.setString(3,quanlybandoc_Model.getGioiTinh());
                                preparedStatement.setString(4,quanlybandoc_Model.getNgayDangky());
                                preparedStatement.setString(5,quanlybandoc_Model.getNgayHethan());
                                preparedStatement.setString(6,quanlybandoc_Model.getMaBandoc());

                                int rs = preparedStatement.executeUpdate();
                                System.out.println(rs);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }
                        
                
      
                           
                           
                           
                           
                           
                           
                           
                           
  //*******************************Phan Quanlymuontra****************************************
     // chuc nang dang ky
        public void Dangky_muontra(Quanlymuontra Qlmt){
               Connection connection = JDBCutil.ketnoi_JDBC();
                 // add vao statement cau lenh sql
                try {
                     String sql ="insert into Quanlymuontra(maSach, maBandoc, ngayMuon, ngayTra,tinhTrang ) values(?,?,?,?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,Qlmt.getMaSach());
                    preparedStatement.setString(2,Qlmt.getMaBandoc());
                    preparedStatement.setString(3,Qlmt.getNgayMuon());
                    preparedStatement.setString(4,Qlmt.getNgayTra());
                    preparedStatement.setString(5,Qlmt.getTinhTrang());

                    int rs =preparedStatement.executeUpdate();
                    System.out.println(rs);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }                    
              
        
        // chuc nang xoa panel Quanlymuontra
          public void Delete_Quanlymuontra(String maSach){
               Connection connection = JDBCutil.ketnoi_JDBC();
                   
                // add vaof staement cau lenh sql
                  try {
                       String sql = "DELETE from Quanlymuontra  where maSach = ?" ;
                       PreparedStatement preparedStatement=connection.prepareStatement(sql);
                       preparedStatement.setString(1,maSach);
                       int rs = preparedStatement.executeUpdate();
                          System.out.println(rs);
                       } catch (SQLException e) {
                            e.printStackTrace();
                       }
                }
    
                           
        // chuc nang update cap nhat cho panel quanlymuontra
            public void Update_Quanlymuontra(Quanlymuontra Qlmt){
                  Connection connection = JDBCutil.ketnoi_JDBC();
                               
                      try {
                                
                          String sql = "update Quanlymuontra set ngayMuon =?, ngayTra=?, tinhTrang=? where maSach= ?";
                         // add vao statement doi tuong cua cau lenh sql
                           PreparedStatement preparedStatement= connection.prepareStatement(sql);
                                                          
                           preparedStatement.setString(1,Qlmt.getNgayMuon());
                           preparedStatement.setString(2,Qlmt.getNgayTra());
                           preparedStatement.setString(3,Qlmt.getTinhTrang());
                           preparedStatement.setString(4,Qlmt.getMaSach());
                           
                          int rs = preparedStatement.executeUpdate();
                              System.out.println(rs);
                           } catch (SQLException e) {
                                e.printStackTrace();
                           }

                     }
                        
      
            
            
            
            
            
 //***************************************panel_Quanlytiemkiem*******************************************           
 // chuc nang serach trong quanlytimkiem
        public ArrayList<Quanlytiemkiem> find_Search(String MBD){
           ArrayList<Quanlytiemkiem> findSearchs = new ArrayList<Quanlytiemkiem>();
            Connection connection = JDBCutil.ketnoi_JDBC();
            try {
                     // khai báo câu lệnh sql
                      String sql = "select * from Quanlytiemkiem where maBandoc like '%"+MBD+"%'";
                    //thục hiện tược tác statement -> statement giúp add câu truy vân sql từ java vào mySQL
                    PreparedStatement preparedStatement=connection.prepareStatement(sql);
                    // trả kết quả khi nhận câu lệnh truy vấn sql
                    ResultSet rs = preparedStatement.executeQuery();
                    while (rs.next()){
                         Quanlytiemkiem find = new Quanlytiemkiem();
                         find.setMaSach(rs.getString(1));
                         find.setTenSach(rs.getString(2));
                         find.setMaBandoc(rs.getString(3));
                         find.setTenBandoc(rs.getString(4));
                         find.setNgayMuon(rs.getString(5));
                         find.setNgayTra(rs.getString(6));
                         find.setTinhTrang(rs.getString(7));
                        //add các trường cột mới khai báo vào List để nó hiển thị với dạng mảng ds
                      findSearchs.add(find);            
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return  findSearchs;
        }
        
        
       
        
    // chuc nang dang ky them Acount 
        
        public void Dangky_Acount(Dangky_Acount acount){
               Connection connection = JDBCutil.ketnoi_JDBC();
                 // add vao statement cau lenh sql
                try {
                     String sql ="insert into Login(User, Gmail, Password, Confirm_Pass ) values(?,?,?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1,acount.getUser());
                    preparedStatement.setString(2,acount.getGmail());
                    preparedStatement.setString(3,acount.getPassword());
                    preparedStatement.setString(4,acount.getConfirmPass());

                    int rs =preparedStatement.executeUpdate();
                    System.out.println(rs);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }    
        
        
        
    // chuc nang tao bang user dang nhap bang tai khoan va mat khau ca nhan trc khi mo giao dien
//        public void Dangnhap_Login(Dangky_Acount acount2){
//            Connection connection= JDBCutil.ketnoi_JDBC();
//            try {
//                String sql = "select * from Login where User = ? and Password =?";
//                PreparedStatement preparedStatement = connection.prepareCall(sql);
//                preparedStatement.setString(1,acount2.getUser());
//                preparedStatement.setString(2, acount2.getPassword());
//                
//                int rs = preparedStatement.executeUpdate();
//                System.err.println(rs);
//                
//                
//            } catch (Exception e) {
//            }
//        }
  
             
    // end class
}
