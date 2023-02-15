/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Dangky_Acount;
import Model.Maloaisach;
import Model.Quanlybandoc_Model;
import Model.Quanlymuontra;
import Model.Quanlytiemkiem;
import Model.Sach_Model;
import java.util.ArrayList;
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
      public static List<Sach_Model> getAllusers(){
          return dao_controller.getAllusers();
      }
      
        //method List<> getAllusers2
      public static List<Maloaisach> getAllusers2(){
          return dao_controller.getAllusers2();
      }
      
      // add method getAllMabndocs() vaof serrvice
      public static List<Quanlybandoc_Model>getAllMabandocs(){
          return dao_controller.getAllMabandocs();
      }
      // add method tbale cho bang quanlymuontra
       public ArrayList<Quanlymuontra> getAllMuontra(){
           return dao_controller.getAllMuontra();
       }
       
       // add method load combox maSach
          public ArrayList<String> getLoad_ComboxMuontra_maSach(){
              return dao_controller.getLoad_ComboxMuontra_maSach();
          }
       // add method lod combox mabandoc
          public ArrayList<String> getLoad_ComboxMuontra_maBandoc(){
              return dao_controller.getLoad_ComboxMuontra_maBandoc();
          }
          
       // load du lieu bang view quan ly tiem kiem
           public ArrayList<Quanlytiemkiem> getAllTiemkiem(){
               return dao_controller.getAllTiemkiem();
           }
          
       // add find tiem kiem   
         public ArrayList<Quanlytiemkiem> find_Search(String MBD){
             return dao_controller.find_Search(MBD);
         }  
      
      // add method get Maloaisach
//       public static List<Maloaisach> getCombobox(){
//          return dao_controller.getCombobox();
//      }

     
      
      
     // add mehtod Insert_Quanlysach tu DAO vao service de lay du lieu truyen trung gian
    public void Insert_Quanlysach(Sach_Model sach_Model){
           dao_controller.Insert_Quanlysach(sach_Model);
    }
    // add methof them moi bang Maloaisach
     public void Insert_Maloaisach(Maloaisach maloaisach){
          dao_controller.Insert_Maloaisach(maloaisach);
     }
    
    // add dang ky ban doc
       public void Dangkybandoc(Quanlybandoc_Model bandoc_model){
           dao_controller.Dangkybandoc(bandoc_model);
       }

    // add method delete_quanlysach vao
    public void Delete_Quanlysach(String maSach){
          dao_controller.Delete_Quanlysach(maSach);
    }
    //add method delete Maloaisach
      public void Delete_Maloaisach(String maLoai){
          dao_controller.Delete_Maloaisach(maLoai);
      }
    // add pt xoa quanlybandoc
    public void Delete_Quanlybandoc(String maBandoc){
        dao_controller.Delete_Quanlybandoc(maBandoc);
    }

    // ad method Update_Quanlysach
    public void Update_Quanlysach(Sach_Model sach_Model){
          dao_controller.Update_Quanlysach(sach_Model);
    }
    
    // add method uodate ban doc
    public void Update_Quanlybandoc(Quanlybandoc_Model quanlybandoc_Model){
        dao_controller.Update_Quanlybandoc(quanlybandoc_Model);
    }
    
    
    //---------------------------------------------------------------------------
    // add chuc nang load dl tu table Maloaisach vao trong combobox
         public ArrayList<String> getLoad_ComboxSach(){
             return dao_controller.getLoad_ComboxSach();
         }

         
    /*chuc nang panel Quanlymuontra*/
      // method dang ky insert into cho Quanlymuontra
        public void Dangky_muontra(Quanlymuontra Qlmt){
            dao_controller.Dangky_muontra(Qlmt);
        } 
        
      // method xoa Quanlymuontra
         public void Delete_Quanlymuontra(String maSach){
             dao_controller.Delete_Quanlymuontra(maSach);
         }
      // method update panel quanlymuontra
         public void Update_Quanlymuontra(Quanlymuontra Qlmt) {
             dao_controller.Update_Quanlymuontra(Qlmt);
         }
         
         
      //-----------------chuc nang dang nhap , dang ki---------------------
         // theem method dangki_acount
          public void Dangky_Acount(Dangky_Acount acount){
              dao_controller.Dangky_Acount(acount);
          }
         // method dangnhap_login
//           public void Dangnhap_Login(Dangky_Acount acount2){
//               dao_controller.Dangnhap_Login(acount2);
//           }
}
