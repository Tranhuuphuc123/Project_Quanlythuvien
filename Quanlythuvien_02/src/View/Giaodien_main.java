/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.Service_Controller;
import Model.Quanlysach_Model;
import com.mysql.cj.xdevapi.Table;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tran Huu Phuc
 */
public class Giaodien_main extends javax.swing.JFrame {
 //class member khai bao tu dinh nghia 
    // setlayout sang card layout de chuyen giao dien frame
    CardLayout cardLayout;
 
    //khai báo biến tao tự định nghĩa

    Service_Controller service_Controller;
    Quanlysach_Model quanlysach_Model;
    // ham khai bao them truong cot cho bang table
    DefaultTableModel defaultTableModel;
 

    // thiết lập dữ liệu setDada ở biến khai báo toàn bộ, có thể tái sử dụng tiết kiệm công sức viết code
    //setData này để chứa hàm load dữ liệu từ bảng bên Mysql qua table trên giao diện gui Swing
    private void setData(List<Quanlysach_Model> quanlysach_Models){
        for(Quanlysach_Model quanlysach_Model: quanlysach_Models){
            defaultTableModel.addRow(new Object[]{quanlysach_Model.getMaSach(), quanlysach_Model.getTenSach(), quanlysach_Model.getLoaiSach(), quanlysach_Model.getNhaXuatBan(), 
                quanlysach_Model.getTacGia(),quanlysach_Model.getSoLuong()});
        }
    }
    
    
    
   
 // contructor
    public Giaodien_main() {
        initComponents();
        this.setVisible(true);
        service_Controller = new Service_Controller();
        quanlysach_Model= new Quanlysach_Model();
       
        // dinh nghia class member tu dinh nghia
      
        
         // setlayout(cardLayout giúp chuyển đòi qua lại các frame trong một frame)
        Component [] components = this.getContentPane().getComponents();
        for(Component component: components){
                if( component instanceof JButton){
                        ((JButton) component).setUI(new BasicButtonUI());
                        ((JButton) component).setFocusPainted(false);
              }
        }
        
          cardLayout = (CardLayout)(panel_sub.getLayout());
          
          
      
                         // thiết lập table tren JFrame
                           defaultTableModel = new DefaultTableModel()
                           {
                               // tiến hành thiết lập không cho người dùng sữa dữ liệu trên table thông qua nhấp chuột vào sữa
                               @Override
                               public boolean isCellEditable(int row, int column) {
                                   return false;
                               }
                           };
                           table_Quanlysach.setModel(defaultTableModel);
                           defaultTableModel.addColumn("Mã sách");
                           defaultTableModel.addColumn("Tên Sách");
                           defaultTableModel.addColumn("Loại sách");
                           defaultTableModel.addColumn("Nhà xuất bản");
                           defaultTableModel.addColumn("Tác giả");
                           defaultTableModel.addColumn("Số lượng");

                           // them hien thi thong tin bang user sql len table
                           /*cách cũ*/
                   //        List<User> users = UserService.getAllUsers();
                   //        for(User user: users){
                   //            defaultTableModel.addRow(new Object[]{user.getId(), user.getName(), user.getPhone(), user.getUsername(), user.getPassword(),user.getAbout(),
                   //                    user.getRole(), user.getFavourites()});
                   //        }

                           /*cách mới khai báo biến toàn cục trc contrucor, khi cần thì gọi ra thui*/
                               setData(service_Controller.getAllusers());
     
            
            
             //end contructor
    }
        
        
    // ham initComponents(); hamf xaay duwngj frame code
    /* đoạn code giao diện sinh ra khi ve*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        panel_menu = new javax.swing.JPanel();
        button_Quanlysach = new javax.swing.JButton();
        button_Quanlybandoc = new javax.swing.JButton();
        button_Quanlymuontra = new javax.swing.JButton();
        button_Timkiem = new javax.swing.JButton();
        panel_sub = new javax.swing.JPanel();
        panel_subQuanlysach = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        label_maSach = new javax.swing.JLabel();
        label_tenSach = new javax.swing.JLabel();
        label_loaiSach = new javax.swing.JLabel();
        label_Nxb = new javax.swing.JLabel();
        label_tacGia = new javax.swing.JLabel();
        label_soLuong = new javax.swing.JLabel();
        field_maSach = new javax.swing.JTextField();
        field_tenSach = new javax.swing.JTextField();
        jRadioButton_vanHoc = new javax.swing.JRadioButton();
        jRadioButton_KHXH = new javax.swing.JRadioButton();
        jRadioButton_Congnghe = new javax.swing.JRadioButton();
        field_Nxb = new javax.swing.JTextField();
        field_tacGia = new javax.swing.JTextField();
        jRadioButton_diaLy = new javax.swing.JRadioButton();
        field_soLuong = new javax.swing.JTextField();
        button_them = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_capnhat = new javax.swing.JButton();
        button_refesh = new javax.swing.JButton();
        Jscroll_Quanlysach = new javax.swing.JScrollPane();
        table_Quanlysach = new javax.swing.JTable();
        panel_subQuanlybandoc = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        label_maBandoc = new javax.swing.JLabel();
        label_tenBandoc = new javax.swing.JLabel();
        label_diaChi = new javax.swing.JLabel();
        label_CMND = new javax.swing.JLabel();
        label_namSinh = new javax.swing.JLabel();
        label_ngayDangky = new javax.swing.JLabel();
        field_maBandoc = new javax.swing.JTextField();
        field_tenBandoc = new javax.swing.JTextField();
        field_diaChi = new javax.swing.JTextField();
        field_CMND = new javax.swing.JTextField();
        field_namSinh = new javax.swing.JTextField();
        field_ngayDK = new javax.swing.JTextField();
        button_dangkybandoc = new javax.swing.JButton();
        button_xoabandoc = new javax.swing.JButton();
        button_capnhatbandoc = new javax.swing.JButton();
        button_refeshbandoc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Quanlybandoc = new javax.swing.JTable();
        panel_subQuanlymuontra = new javax.swing.JPanel();
        panel_subTimkiem = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setSize(new java.awt.Dimension(800, 600));

        jSplitPane1.setMinimumSize(new java.awt.Dimension(205, 600));

        panel_menu.setBackground(new java.awt.Color(102, 102, 102));
        panel_menu.setMinimumSize(new java.awt.Dimension(100, 600));
        panel_menu.setPreferredSize(new java.awt.Dimension(158, 600));

        button_Quanlysach.setLabel("Quản lý sách");
        button_Quanlysach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_QuanlysachActionPerformed(evt);
            }
        });

        button_Quanlybandoc.setLabel("Quản lý bạn đọc");
        button_Quanlybandoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_QuanlybandocActionPerformed(evt);
            }
        });

        button_Quanlymuontra.setLabel("Mượn/Trả");
        button_Quanlymuontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_QuanlymuontraActionPerformed(evt);
            }
        });

        button_Timkiem.setLabel("Tiềm kiếm");
        button_Timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_TimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_Timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_Quanlysach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_Quanlybandoc, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(button_Quanlymuontra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(button_Quanlysach, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_Quanlybandoc, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_Quanlymuontra, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_Timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jSplitPane1.setLeftComponent(panel_menu);

        panel_sub.setPreferredSize(new java.awt.Dimension(566, 600));
        panel_sub.setLayout(new java.awt.CardLayout());

        panel_subQuanlysach.setBackground(new java.awt.Color(255, 255, 255));

        label_maSach.setText("Mã sách");

        label_tenSach.setText("Tên Sách");

        label_loaiSach.setText("Loại sách");

        label_Nxb.setText("Nhà xuất bản");

        label_tacGia.setText("Tác giả");

        label_soLuong.setText("Số lượng");

        buttonGroup1.add(jRadioButton_vanHoc);
        jRadioButton_vanHoc.setText("Văn học");

        buttonGroup1.add(jRadioButton_KHXH);
        jRadioButton_KHXH.setText("KHXH");

        buttonGroup1.add(jRadioButton_Congnghe);
        jRadioButton_Congnghe.setText("Công nghệ");

        buttonGroup1.add(jRadioButton_diaLy);
        jRadioButton_diaLy.setText("Địa lý");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_loaiSach)
                        .addGap(30, 30, 30)
                        .addComponent(jRadioButton_vanHoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton_KHXH)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton_Congnghe, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton_diaLy, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tenSach)
                            .addComponent(label_maSach))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_maSach, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(field_tenSach)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_Nxb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(field_Nxb, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(label_tacGia)
                                .addGap(44, 44, 44))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(label_soLuong)
                                .addGap(35, 35, 35)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_tacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_maSach)
                    .addComponent(field_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tenSach)
                    .addComponent(field_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_loaiSach)
                    .addComponent(jRadioButton_vanHoc)
                    .addComponent(jRadioButton_KHXH)
                    .addComponent(jRadioButton_Congnghe)
                    .addComponent(jRadioButton_diaLy))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Nxb)
                    .addComponent(field_Nxb))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tacGia)
                    .addComponent(field_tacGia))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_soLuong))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        button_them.setText("Thêm");
        button_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_themActionPerformed(evt);
            }
        });

        button_delete.setText("Xóa");
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        button_capnhat.setText("Cập nhật");
        button_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_capnhatActionPerformed(evt);
            }
        });

        button_refesh.setText("Refesh");
        button_refesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_refeshActionPerformed(evt);
            }
        });

        table_Quanlysach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        Jscroll_Quanlysach.setViewportView(table_Quanlysach);

        javax.swing.GroupLayout panel_subQuanlysachLayout = new javax.swing.GroupLayout(panel_subQuanlysach);
        panel_subQuanlysach.setLayout(panel_subQuanlysachLayout);
        panel_subQuanlysachLayout.setHorizontalGroup(
            panel_subQuanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_subQuanlysachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_subQuanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Jscroll_Quanlysach)
                    .addGroup(panel_subQuanlysachLayout.createSequentialGroup()
                        .addGroup(panel_subQuanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_subQuanlysachLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_refesh))
                            .addGroup(panel_subQuanlysachLayout.createSequentialGroup()
                                .addComponent(button_them)
                                .addGap(12, 12, 12)
                                .addComponent(button_delete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_capnhat)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        panel_subQuanlysachLayout.setVerticalGroup(
            panel_subQuanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_subQuanlysachLayout.createSequentialGroup()
                .addGroup(panel_subQuanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_subQuanlysachLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(button_refesh))
                    .addGroup(panel_subQuanlysachLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panel_subQuanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_them)
                    .addComponent(button_delete)
                    .addComponent(button_capnhat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jscroll_Quanlysach, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
        );

        panel_sub.add(panel_subQuanlysach, "panel_subQuanlysach");

        panel_subQuanlybandoc.setBackground(new java.awt.Color(255, 255, 255));

        label_maBandoc.setText("Mã bạn đọc");

        label_tenBandoc.setText("Tên bạn đọc");

        label_diaChi.setText("Địa chỉ");

        label_CMND.setText("CMND");

        label_namSinh.setText("Năm sinh");

        label_ngayDangky.setText("Ngày đăng ký ");

        field_maBandoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_maBandocActionPerformed(evt);
            }
        });

        field_diaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_diaChiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_maBandoc)
                        .addGap(29, 29, 29)
                        .addComponent(field_maBandoc, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_namSinh)
                            .addComponent(label_ngayDangky))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(field_namSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(field_ngayDK, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_tenBandoc)
                        .addGap(26, 26, 26)
                        .addComponent(field_tenBandoc, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_diaChi)
                            .addComponent(label_CMND))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_diaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(field_CMND))))
                .addContainerGap(516, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_maBandoc)
                    .addComponent(field_maBandoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tenBandoc)
                    .addComponent(field_tenBandoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_diaChi)
                    .addComponent(field_diaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_CMND)
                    .addComponent(field_CMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_namSinh)
                    .addComponent(field_namSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_ngayDangky)
                    .addComponent(field_ngayDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        button_dangkybandoc.setText("Đăng ký");

        button_xoabandoc.setText("Xóa");

        button_capnhatbandoc.setText("Cập nhật");

        button_refeshbandoc.setText("Refesh");

        table_Quanlybandoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table_Quanlybandoc);

        javax.swing.GroupLayout panel_subQuanlybandocLayout = new javax.swing.GroupLayout(panel_subQuanlybandoc);
        panel_subQuanlybandoc.setLayout(panel_subQuanlybandocLayout);
        panel_subQuanlybandocLayout.setHorizontalGroup(
            panel_subQuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_subQuanlybandocLayout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_subQuanlybandocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_subQuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panel_subQuanlybandocLayout.createSequentialGroup()
                        .addComponent(button_dangkybandoc, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_xoabandoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_capnhatbandoc))
                    .addGroup(panel_subQuanlybandocLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_refeshbandoc)))
                .addGap(19, 19, 19))
        );
        panel_subQuanlybandocLayout.setVerticalGroup(
            panel_subQuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_subQuanlybandocLayout.createSequentialGroup()
                .addGroup(panel_subQuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_subQuanlybandocLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_subQuanlybandocLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(button_refeshbandoc)))
                .addGroup(panel_subQuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_subQuanlybandocLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panel_subQuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_xoabandoc)
                            .addComponent(button_capnhatbandoc)))
                    .addGroup(panel_subQuanlybandocLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_dangkybandoc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
        );

        panel_sub.add(panel_subQuanlybandoc, "panel_subQuanlybandoc");

        panel_subQuanlymuontra.setBackground(new java.awt.Color(51, 255, 204));

        javax.swing.GroupLayout panel_subQuanlymuontraLayout = new javax.swing.GroupLayout(panel_subQuanlymuontra);
        panel_subQuanlymuontra.setLayout(panel_subQuanlymuontraLayout);
        panel_subQuanlymuontraLayout.setHorizontalGroup(
            panel_subQuanlymuontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );
        panel_subQuanlymuontraLayout.setVerticalGroup(
            panel_subQuanlymuontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        panel_sub.add(panel_subQuanlymuontra, "panel_subQuanlymuontra");

        panel_subTimkiem.setBackground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout panel_subTimkiemLayout = new javax.swing.GroupLayout(panel_subTimkiem);
        panel_subTimkiem.setLayout(panel_subTimkiemLayout);
        panel_subTimkiemLayout.setHorizontalGroup(
            panel_subTimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );
        panel_subTimkiemLayout.setVerticalGroup(
            panel_subTimkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        panel_sub.add(panel_subTimkiem, "panel_subTimkiem");

        jSplitPane1.setRightComponent(panel_sub);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     
                                          

    private void button_QuanlybandocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_QuanlybandocActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panel_sub, "panel_subQuanlybandoc");
    }//GEN-LAST:event_button_QuanlybandocActionPerformed

    private void button_QuanlymuontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_QuanlymuontraActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panel_sub, "panel_subQuanlymuontra");
    }//GEN-LAST:event_button_QuanlymuontraActionPerformed

    private void button_TimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_TimkiemActionPerformed
        // TODO add your handling code here:
        cardLayout.show(panel_sub, "panel_subTimkiem");
    }//GEN-LAST:event_button_TimkiemActionPerformed

    
    
    
    // chức  năng insert thêm mới dữ liệu của panel quản lý sách
    private void button_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_themActionPerformed
        // thiết lập nơi nhập đưa dl từ bàn phím vào các fiel tg ứng trên giao diện
                quanlysach_Model.setMaSach(field_maSach.getText());
                quanlysach_Model.setTenSach(field_tenSach.getText());
                // thiet lap cac radio button trong loai sach
                String lS = "";
                if(jRadioButton_vanHoc.isSelected()){
                    lS +="Văn Học";
                }else if(jRadioButton_KHXH.isSelected()){
                    lS += ",KHXH";
                }else if(jRadioButton_Congnghe.isSelected()){
                    lS += ",Công nghệ";
                }else if(jRadioButton_diaLy.isSelected()){
                    lS += ",Dịa lý";
                }
                quanlysach_Model.setLoaiSach(lS);
                
                quanlysach_Model.setNhaXuatBan(field_Nxb.getText());
                quanlysach_Model.setTacGia(field_tacGia.getText());
                quanlysach_Model.setSoLuong(Integer.parseInt(field_soLuong.getText()));

                service_Controller.Insert_Quanlysach(quanlysach_Model);
    }//GEN-LAST:event_button_themActionPerformed

    
    
    
    // chức năng refesh lại dữ liệu của quản lý sách
    private void button_refeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_refeshActionPerformed
              defaultTableModel.setRowCount(0);
                List<Quanlysach_Model> quanlysach_Models = service_Controller.getAllusers();
                setData(service_Controller.getAllusers());
    }//GEN-LAST:event_button_refeshActionPerformed

    
    
    // chức năng xóa dữ liệu của quản lý sách
    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
         int row =  table_Quanlysach.getSelectedRow();
                // nếu người dùng chưa choinj gì mà bâ xóa xem như 11 là chưa chọn
                if(row == -1){
                    // show thong bao la chua chon gi ma doi xoa
                    JOptionPane.showMessageDialog(Giaodien_main.this, "vui long chon dong muon xoa","loi",JOptionPane.ERROR_MESSAGE);
                }else{
                    // nc lai thi show nhac nho la co muon chac an xoa khong???
                    int confirm = JOptionPane.showConfirmDialog(Giaodien_main.this,"Ban co chac an muon xoa khong?");
                    // neu chon yes thi thuc thi xoa
                    if(confirm==JOptionPane.YES_NO_OPTION){
                        String maSach_Quanlysach = String.valueOf(table_Quanlysach.getValueAt(row,0));
                        service_Controller.Delete_Quanlysach(maSach_Quanlysach);

                            // xoa xong thi refresh lai du lieu
                            defaultTableModel.setRowCount(0);
                            setData(service_Controller.getAllusers());
                        }
                    }
    }//GEN-LAST:event_button_deleteActionPerformed

    
    private void field_diaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_diaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_diaChiActionPerformed

    private void field_maBandocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_maBandocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_maBandocActionPerformed

    
    
    // tthực hiện chức năng cập nhật cho trang quản lý sách
    private void button_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_capnhatActionPerformed
         int row = table_Quanlysach.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(Giaodien_main.this,"vui long chon trc khi update","loi",JOptionPane.ERROR_MESSAGE);
                }else{
                    String maSach_Quanlysach = String.valueOf(table_Quanlysach.getValueAt(row,0));


                    // bam nut mo hop thoai edit con mo ra
                    new Editmenu_Quanlysach(maSach_Quanlysach).setVisible(true);
                    dispose();
                }
    }//GEN-LAST:event_button_capnhatActionPerformed

    private void button_QuanlysachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_QuanlysachActionPerformed
         cardLayout.show(panel_sub, "panel_subQuanlysach");
    }//GEN-LAST:event_button_QuanlysachActionPerformed

  
    
   
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Jscroll_Quanlysach;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_Quanlybandoc;
    private javax.swing.JButton button_Quanlymuontra;
    private javax.swing.JButton button_Quanlysach;
    private javax.swing.JButton button_Timkiem;
    private javax.swing.JButton button_capnhat;
    private javax.swing.JButton button_capnhatbandoc;
    private javax.swing.JButton button_dangkybandoc;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_refesh;
    private javax.swing.JButton button_refeshbandoc;
    private javax.swing.JButton button_them;
    private javax.swing.JButton button_xoabandoc;
    private javax.swing.JTextField field_CMND;
    private javax.swing.JTextField field_Nxb;
    private javax.swing.JTextField field_diaChi;
    private javax.swing.JTextField field_maBandoc;
    private javax.swing.JTextField field_maSach;
    private javax.swing.JTextField field_namSinh;
    private javax.swing.JTextField field_ngayDK;
    private javax.swing.JTextField field_soLuong;
    private javax.swing.JTextField field_tacGia;
    private javax.swing.JTextField field_tenBandoc;
    private javax.swing.JTextField field_tenSach;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton_Congnghe;
    private javax.swing.JRadioButton jRadioButton_KHXH;
    private javax.swing.JRadioButton jRadioButton_diaLy;
    private javax.swing.JRadioButton jRadioButton_vanHoc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel label_CMND;
    private javax.swing.JLabel label_Nxb;
    private javax.swing.JLabel label_diaChi;
    private javax.swing.JLabel label_loaiSach;
    private javax.swing.JLabel label_maBandoc;
    private javax.swing.JLabel label_maSach;
    private javax.swing.JLabel label_namSinh;
    private javax.swing.JLabel label_ngayDangky;
    private javax.swing.JLabel label_soLuong;
    private javax.swing.JLabel label_tacGia;
    private javax.swing.JLabel label_tenBandoc;
    private javax.swing.JLabel label_tenSach;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel panel_sub;
    private javax.swing.JPanel panel_subQuanlybandoc;
    private javax.swing.JPanel panel_subQuanlymuontra;
    private javax.swing.JPanel panel_subQuanlysach;
    private javax.swing.JPanel panel_subTimkiem;
    private javax.swing.JTable table_Quanlybandoc;
    private javax.swing.JTable table_Quanlysach;
    // End of variables declaration//GEN-END:variables

   
}
