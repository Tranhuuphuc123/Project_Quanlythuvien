/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Quanlysach_Model;
import java.util.List;

/**
 *
 * @author Tran Huu Phuc
 */
public class Service_Controller {
  
     private static DAO_Controller dao_controller;

    // contructor
    public Service_Controller(){
        dao_controller = new DAO_Controller();
    }

    /* add cac method thuc thi sql trong jav ben DAO_controller vao lan nua de lay dl trung gian tu DAO truyen cho cacs package khac*/

    //method List<> getAllusers
      public static List<Quanlysach_Model> getAllusers(){
          return dao_controller.getAllusers();
      }

     // add mehtod Insert_Quanlysach tu DAO vao service de lay du lieu truyen trung gian
    public void Insert_Quanlysach(Quanlysach_Model quanlysach_Model){
           dao_controller.Insert_Quanlysach(quanlysach_Model);
    }

    // add method delete_quanlysach vao
    public void Delete_Quanlysach(String maSach){
          dao_controller.Delete_Quanlysach(maSach);
    }

    // ad method Update_Quanlysach
    public void Update_Quanlysach(Quanlysach_Model quanlysach_Model){
          dao_controller.Update_Quanlysach(quanlysach_Model);
    }




    //add method lay dl tu Model phuc vu bang edit bang sua du lieu
    /* xay dung ham lay dl phuc vu bang edit con ua du lieu-> nghia la bam chon dong can update mo hop thoai
     edit de sua update lai du lieu thi luc nay mo len hop thoai edit nos se xuat thong tin cua dong minh
     muon sua
    * */
    public Quanlysach_Model getUserByMa(String maSach){
        return  dao_controller.getUserByMa(maSach);
    }


  
    
}
