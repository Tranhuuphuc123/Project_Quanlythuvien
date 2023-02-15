package View;

import Controller.Service_controller;
import Model.Sach_Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Giaodien_Edit extends JFrame {
    private JPanel panel_edit_Quanlysach;
    private JTextField field_edit_maSach;
    private JTextField field_edit_tenSach;
    private JTextField field_edit_Nxb;
    private JTextField field_edit_tacGia;
    private JTextField field_edit_soLuong;
    private JButton buttonedit_back;
    private JButton button_edit_Sua;
    private JLabel label_edit_maSach;
    private JLabel label_edit_tenSach;
    private JLabel label_edit_loaiSach;
    private JLabel label_edit_nhaXuatBan;
    private JLabel label_edit_tacGia;
    private JLabel label_edit_soLuong;
    private JRadioButton radioButton_edit_Vanhoc;
    private JRadioButton radioButton_edit_Khxn;
    private JRadioButton radioButton_edit_Congnghe;
    private JRadioButton radioButton_edit_Dialy;
    private JLabel label_edit_Nameform;

    // goi du lieu cac package chung
    private Sach_Model sach_model;
    private Service_controller service_controller;




    // contructor

    public Giaodien_Edit(String maSach_Quanlysach){

        // gang package model vao trong view_giaodienedit
        this.service_controller = new Service_controller();
        // gangs cho service = model(sach_model)
        sach_model = service_controller.getUserByMa(maSach_Quanlysach);


        this.init();
        this.setSize(500,500);
        //thiết lập chạy giao diện GUI khi vẽ vào code
        this.setContentPane(panel_edit_Quanlysach);
        this.pack();


        //set hien thi khi  nd can sua len bang edit.. de xem trc khi sua lai
        field_edit_maSach.setText(sach_model.getMaSach());
        field_edit_tenSach.setText(sach_model.getTenSach());
        String loaiSach_Edit = sach_model.getLoaiSach();
        if(loaiSach_Edit != null){
            String [] lS_edit = loaiSach_Edit.split(",");
            for(String l: lS_edit){
                if(l.equals("vanHoc")){
                    radioButton_edit_Vanhoc.setSelected(true);
                }
                if(l.equals("Khxh")){
                    radioButton_edit_Khxn.setSelected(true);
                }
                if(l.equals("Congnghe")){
                    radioButton_edit_Congnghe.setSelected(true);
                }
                if(l.equals("Dialy")){
                    radioButton_edit_Dialy.setSelected(true);
                }
            }
        }


        field_edit_Nxb.setText(sach_model.getNhaXuatBan());
        field_edit_tacGia.setText(sach_model.getTacGia());
        field_edit_soLuong.setText(String.valueOf(sach_model.getSoLuong()));





        // chuc nang quay lại bản Quanlysach
        buttonedit_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Giaodien_Quanlysach().setVisible(true);
                dispose();
            }
        });


        // thuc hien chuc nang update, sau dl lai nguoi dung
        button_edit_Sua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // thiết lập nơi nhập đưa dl từ bàn phím vào các fiel tg ứng trên giao diện
                sach_model.setMaSach(field_edit_maSach.getText());
                sach_model.setTenSach(field_edit_tenSach.getText());
                // thiet lap cac radio button trong loai sach
                String lS = "";
                if(radioButton_edit_Vanhoc.isSelected()){
                    lS +="vanHoc";
                }else if(radioButton_edit_Khxn.isSelected()){
                    lS += "Khxh";
                }else if(radioButton_edit_Congnghe.isSelected()){
                    lS += "Congnghe";
                }else if(radioButton_edit_Dialy.isSelected()){
                    lS += "Dialy";
                }
                sach_model.setLoaiSach(lS);

                sach_model.setNhaXuatBan(field_edit_tacGia.getText());
                sach_model.setTacGia(field_edit_tacGia.getText());
                sach_model.setSoLuong(Integer.parseInt(field_edit_soLuong.getText()));

                service_controller.Update_Quanlysach(sach_model);

                // caapj nhat xong an di
                new Giaodien_Quanlysach().setVisible(true);
                dispose();
            }
        });


        //end contructor
    }


    public void init(){
        this.setTitle("Bảng sữa người dùng");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // chạy giữa màn hình
        this.setLocationRelativeTo(null);

    }

}
