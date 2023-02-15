package View;

import Model.Sach_Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Giaodienchinh extends JFrame{
    Sach_Model sach_model;
    private JPanel panel_main;
    private JButton button_Quanlysach;
    private JButton button_Quanlybandoc;
    private JButton button_Quanlymuontra;
    private JButton button_Timkiem;

    // contructor
    public Giaodienchinh(){
        this.sach_model = new Sach_Model();
        this.init();
        this.setSize(300,300);

        //khi ấn nút Quản lý sách sẽ gọi frame quản lý sách ra
        button_Quanlysach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Giaodien_Quanlysach().setVisible(true);
                dispose();
            }
        });

    }
    //end contructor

    public void init(){
        this.setTitle("Quản lý sách");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // thiết lập chạy JFRAME trên GUI form của java Swing -> ddawtj init hay contructor deu dung nha
        this.setContentPane(panel_main);
        this.pack();
        this.setVisible(true);
    }
}
