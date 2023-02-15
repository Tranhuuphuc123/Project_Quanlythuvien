package Controller;

import Model.Sach_Model;

import java.util.List;

// DAO(Data Access Object): nơi chứa và thực thi câu lệnh sql bên trong java
/*--> thì xây dựng hàm service này để:
* -DAO: làm việc trực tiếp với sql và java thông qua câu lệnh sql đã đc kết nối vơ nhau thông qua method JDBC
* - service nay sinh thêm nhận và lấy dữ liệu từ DAO này, đóng vai trò như lớp trung gian truyền dl th truy vấn sql ánh xạ
* vào các View Model bên phần giao diện cũng như chức nang của java một cách dễ dàng và nhanh gọn hơn.
* */
public class Service_controller {
    private static DAO_controller dao_controller;

    // contructor
    public Service_controller(){
        dao_controller = new DAO_controller();
    }

    /* add cac method thuc thi sql trong jav ben DAO_controller vao lan nua de lay dl trung gian tu DAO truyen cho cacs package khac*/

    //method List<> getAllusers
      public static List<Sach_Model> getAllusers(){
          return dao_controller.getAllusers();
      }

     // add mehtod Insert_Quanlysach tu DAO vao service de lay du lieu truyen trung gian
    public void Insert_Quanlysach(Sach_Model sach_model){
           dao_controller.Insert_Quanlysach(sach_model);
    }

    // add method delete_quanlysach vao
    public void Delete_Quanlysach(String STT){
          dao_controller.Delete_Quanlysach(STT);
    }

    // ad method Update_Quanlysach
    public void Update_Quanlysach(Sach_Model sach_model){
          dao_controller.Update_Quanlysach(sach_model);
    }




    //add method lay dl tu Model phuc vu bang edit bang sua du lieu
    /* xay dung ham lay dl phuc vu bang edit con ua du lieu-> nghia la bam chon dong can update mo hop thoai
     edit de sua update lai du lieu thi luc nay mo len hop thoai edit nos se xuat thong tin cua dong minh
     muon sua
    * */
    public Sach_Model getUserByMa(String maSach){
        return  dao_controller.getUserByMa(maSach);
    }

}
