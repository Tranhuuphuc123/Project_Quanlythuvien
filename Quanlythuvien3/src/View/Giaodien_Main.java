 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

//class Giaodien_Main

import Controller.DAO_Controller;
import Controller.Service_Controller;
import Model.Maloaisach;
import Model.Quanlybandoc_Model;
import Model.Quanlymuontra;
import Model.Quanlytiemkiem;
import Model.Sach_Model;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;

public class Giaodien_Main extends javax.swing.JFrame {
     CardLayout cardLayout;
    
    Service_Controller service_Controller;
    Sach_Model sach_Model;
    Maloaisach maloaisach;
    Quanlybandoc_Model quanlybandoc_Model;
    Quanlymuontra quanlymuontra;
    Quanlytiemkiem quanlytiemkiem;
    String MBD="";
    
    // ham khai bao them truong cot cho bang table
    DefaultTableModel defaultTableModel;
    DefaultTableModel defaultTableModel1;
    DefaultTableModel defaultTableModel2;
    DefaultTableModel defaultTableModel_Quanlymuontra;
    DefaultTableModel defaultTableModel_Quanlytiemkiem;
    
    private String maSach;

 //---------------------------------------------------------------------------------------------------------------------------------------------------

    // thiết lập dữ liệu setDada ở biến khai báo toàn bộ, có thể tái sử dụng tiết kiệm công sức viết code
    //setData này để chứa hàm load dữ liệu từ bảng bên Mysql qua table trên giao diện gui Swing
    private void setData(List<Sach_Model> sach_Models){
        for(Sach_Model sach_Model: sach_Models){
            defaultTableModel.addRow(new Object[]{sach_Model.getMaSach(), sach_Model.getTenSach(), sach_Model.getTacGia(), 
               sach_Model.getMaLoai(), sach_Model.getGiaSach(),sach_Model.getSoLuong()});
        }
    }
    
     private void setData2(List<Maloaisach> maloaisachs){
        for(Maloaisach maloaisach: maloaisachs){
            defaultTableModel1.addRow(new Object[]{maloaisach.getMaLoai(),maloaisach.getTenLoai()});
        }
    }
     
     // thiết lập load dữ liệu cho tbale Quanlybandoc
      private void setData_Quanlybandoc(List<Quanlybandoc_Model> quanlybandoc_models){
        for(Quanlybandoc_Model bandoc: quanlybandoc_models){
            defaultTableModel2.addRow(new Object[]{bandoc.getMaBandoc(), bandoc.getTenBandoc(), bandoc.getCMND(),
            bandoc.getGioiTinh(), bandoc.getNgayDangky(), bandoc.getNgayHethan()});
        }
    }
      
      // load dl tu tbale Maloaisach vao combobox Maloai
      private void setLoadcombox(List<String> ls){
                for(String item: ls){
                     jComboBox_maLoai.addItem(item.toString());

                }
      }
      
      
    // load dl tu sql table quanlymuontra len table quanlymuontra tren giao dien hien thi swing
        private void setQuanlymuontra(List<Quanlymuontra>quanlymuontras){
        for(Quanlymuontra qlmt: quanlymuontras){
           defaultTableModel_Quanlymuontra.addRow(new Object[]{qlmt.getMaSach(), qlmt.getMaBandoc(), qlmt.getNgayMuon(),
            qlmt.getNgayTra(), qlmt.getTinhTrang()});
        }
    }
    
        
        
        // load dl tu tbale Maloaisach vao combobox MaSach cua table Quanlymuontra
      private void setLoadcombox_QLmuontra_maSach(List<String> ls){
                for(String item: ls){
                     jComboBox_MTmaSach.addItem(item.toString());

                }
      }
      
         // load dl tu tbale Maloaisach vao combobox MaBandoc cuar table Quanlymuontra
      private void setLoadcombox_QLmuontra_maBandoc(List<String> ls){
                for(String item: ls){
                     jComboBox_MTMabandoc.addItem(item.toString());
                }
      }
      
      
      
      
      
      
 //---------------------------------------------------------------------------------------------------------------------------------------------------
  // contructor
    public Giaodien_Main() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        
        sach_Model = new Sach_Model();
        maloaisach = new Maloaisach();
        quanlybandoc_Model= new Quanlybandoc_Model();
        quanlymuontra = new Quanlymuontra();
        quanlytiemkiem = new Quanlytiemkiem();
        service_Controller = new Service_Controller();
       
      
        // setlayout(cardLayout giúp chuyển đòi qua lại các frame trong một frame)
        Component [] components = this.getContentPane().getComponents();
        for(Component component: components){
                if( component instanceof JButton jButton){
                        jButton.setUI(new BasicButtonUI());
                        jButton.setFocusPainted(false);
              }
        }
        
       
          cardLayout = (CardLayout)(panel_sub.getLayout());
          
   //---------------------------------------------------------------------------------------------------------------------------------------------------       
           // thiết lập theem ten va dl cot cho  table_ListSach  tren JFrame
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
                           defaultTableModel.addColumn("Tác giả");
                           defaultTableModel.addColumn("Mã Loại");
                           defaultTableModel.addColumn("Giá bán");
                           defaultTableModel.addColumn("Số lượng");

                           // them hien thi thong tin bang user sql len table
                           /*cách cũ*/
                   //        List<Sach_Model> sach_Models = service_controller.getAllUsers();
                   //        for(Sach_Model qls: sach_Models){
                   //            defaultTableModel.addRow(new Object[]{qls.getId(), qls.getName(), qls.getPhone(), qls.getUsername(), qls.getPassword(),qls.getAbout(),
                   //                    qls.getRole(), qls.getFavourites()});
                   //        }

                           /*cách mới khai báo biến toàn cục trc contrucor, khi cần thì gọi ra thui*/
                               setData(service_Controller.getAllusers());
    
                               
     //---------------------------------------------------------------------------------------------------------------------------------------------------                          
                 // theem load du lieu cho table 02 Maloaisach
                             defaultTableModel1= new DefaultTableModel()
                           {
                               // tiến hành thiết lập không cho người dùng sữa dữ liệu trên table thông qua nhấp chuột vào sữa
                               @Override
                               public boolean isCellEditable(int row, int column) {
                                   return false;
                               }
                           };
                           table_Maloaisach.setModel(defaultTableModel1);
                           defaultTableModel1.addColumn("Mã Loại");
                           defaultTableModel1.addColumn("Tên Loại");
                           
                             /*cách mới khai báo biến toàn cục trc contrucor, khi cần thì gọi ra thui*/
                               setData2(service_Controller.getAllusers2());
                               
       //---------------------------------------------------------------------------------------------------------------------------------------------------                                      
                               
                         // them load dl cho tbale Quanlybandoc
                            defaultTableModel2= new DefaultTableModel()
                           {
                               // tiến hành thiết lập không cho người dùng sữa dữ liệu trên table thông qua nhấp chuột vào sữa
                               @Override
                               public boolean isCellEditable(int row, int column) {
                                   return false;
                               }
                           };
                           table_Quanlybandoc.setModel(defaultTableModel2);
                           defaultTableModel2.addColumn("Mã bạn đọc");
                              defaultTableModel2.addColumn("Tên bạn đọc");;
                                 defaultTableModel2.addColumn("CMND");
                                    defaultTableModel2.addColumn("Giới tính");
                                       defaultTableModel2.addColumn("Ngày đăng ký");
                                          defaultTableModel2.addColumn("Ngà hết hạn");
                           
                           
                             /*cách mới khai báo biến toàn cục trc contrucor, khi cần thì gọi ra thui*/
                               setData_Quanlybandoc(service_Controller.getAllMabandocs());
              
             //---------------------------------------------------------------------------------------------------------------------------------------------------       
                               // hien thi len table Quanlymuontra
                                 defaultTableModel_Quanlymuontra= new DefaultTableModel()
                           {
                               // tiến hành thiết lập không cho người dùng sữa dữ liệu trên table thông qua nhấp chuột vào sữa
                               @Override
                               public boolean isCellEditable(int row, int column) {
                                   return false;
                               }
                           };
                           table_Quanlymuontra.setModel(defaultTableModel_Quanlymuontra);
                           defaultTableModel_Quanlymuontra.addColumn("Mã Sách");
                               defaultTableModel_Quanlymuontra.addColumn("Mã Bạn Đọc");
                                   defaultTableModel_Quanlymuontra.addColumn("Ngày Mượn");
                                       defaultTableModel_Quanlymuontra.addColumn("Ngày Trả");
                                           defaultTableModel_Quanlymuontra.addColumn("Tình trạng");
                             
                           
                             /*cách mới khai báo biến toàn cục trc contrucor, khi cần thì gọi ra thui*/
                               setQuanlymuontra(service_Controller.getAllMuontra());
                               
              //---------------------------------------------------------------------------------------------------------------------------------------------------       
                               // hien thi len table Quanlytiemkiem
                                 defaultTableModel_Quanlytiemkiem= new DefaultTableModel()
                           {
                               // tiến hành thiết lập không cho người dùng sữa dữ liệu trên table thông qua nhấp chuột vào sữa
                               @Override
                               public boolean isCellEditable(int row, int column) {
                                   return false;
                               }
                           };
                           table_tiemKiem.setModel(defaultTableModel_Quanlytiemkiem);
                           defaultTableModel_Quanlytiemkiem.addColumn("Mã Sách");
                               defaultTableModel_Quanlytiemkiem.addColumn("Tên sách");
                                   defaultTableModel_Quanlytiemkiem.addColumn("Mã bạn đọc");
                                     defaultTableModel_Quanlytiemkiem.addColumn("Tên bạn đọc");
                                       defaultTableModel_Quanlytiemkiem.addColumn("Ngày mượn");
                                           defaultTableModel_Quanlytiemkiem.addColumn("Ngày trả");
                                           defaultTableModel_Quanlytiemkiem.addColumn("Tình trạng");
                             
                           
                             /*cách mới khai báo biến toàn cục trc contrucor, khi cần thì gọi ra thui*/
                            
                               
                           List<Quanlytiemkiem> quanlytiemkiems = service_Controller.getAllTiemkiem();
                           for(Quanlytiemkiem tk: quanlytiemkiems){
                               defaultTableModel_Quanlytiemkiem.addRow(new Object[]{tk.getMaSach(), tk.getTenSach(), tk.getMaBandoc(),
                                   tk.getTenBandoc(), tk.getNgayMuon(),tk.getNgayTra(),tk.getTinhTrang()});
                           } 
                               
                               
                               
    }
    //end contructor

  //---------------------------------------------------------------------------------------------------------------------------------------------------  
   
   //initComponents
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jSplitPane_main = new javax.swing.JSplitPane();
        panel_Menu = new javax.swing.JPanel();
        button_Quanlysach = new javax.swing.JButton();
        button_Quanlybandoc = new javax.swing.JButton();
        button_Quanlymuontra = new javax.swing.JButton();
        button_Tiemkiem = new javax.swing.JButton();
        panel_sub = new javax.swing.JPanel();
        panel_Quanlysach = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        panel_listSach = new javax.swing.JPanel();
        label_tenLoaiSach = new javax.swing.JLabel();
        button_themMaloai = new javax.swing.JButton();
        button_xoaMaloai = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Maloaisach = new javax.swing.JTable();
        label_maLoai = new javax.swing.JLabel();
        field_maLoai = new javax.swing.JTextField();
        label_tenLoai = new javax.swing.JLabel();
        field_tenLoai = new javax.swing.JTextField();
        panel_ThongtinSach = new javax.swing.JPanel();
        panel_thongtinSach = new javax.swing.JPanel();
        label_Danhmucsach = new javax.swing.JLabel();
        label_maSach = new javax.swing.JLabel();
        label_tenSach = new javax.swing.JLabel();
        label_tacGia = new javax.swing.JLabel();
        label_giaBan = new javax.swing.JLabel();
        label_soLuong = new javax.swing.JLabel();
        field_maSach = new javax.swing.JTextField();
        field_tenSach = new javax.swing.JTextField();
        field_tacGia = new javax.swing.JTextField();
        field_gia = new javax.swing.JTextField();
        field_soLuong = new javax.swing.JTextField();
        jComboBox_maLoai = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Quanlysach = new javax.swing.JTable();
        button_xoa = new javax.swing.JButton();
        button_them = new javax.swing.JButton();
        button_sua = new javax.swing.JButton();
        button_Refesh = new javax.swing.JButton();
        label_tendanhmuc = new javax.swing.JLabel();
        panel_Quanlybandoc = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        label_maBandoc = new javax.swing.JLabel();
        label_tenBandoc = new javax.swing.JLabel();
        label_CMND = new javax.swing.JLabel();
        label_gioiTinh = new javax.swing.JLabel();
        label_NDK = new javax.swing.JLabel();
        label_NHH = new javax.swing.JLabel();
        field_maBandoc = new javax.swing.JTextField();
        field_tenBandoc = new javax.swing.JTextField();
        field_CMND = new javax.swing.JTextField();
        jCheckBox_nam = new javax.swing.JCheckBox();
        jCheckBox_nu = new javax.swing.JCheckBox();
        field_NDK = new javax.swing.JTextField();
        field_NHH = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_Quanlybandoc = new javax.swing.JTable();
        button_dangKyBandoc = new javax.swing.JButton();
        button_xoaBandoc = new javax.swing.JButton();
        button_suaBandoc = new javax.swing.JButton();
        button_reshfeshBandoc = new javax.swing.JButton();
        panel_Quanlymuontra = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_Quanlymuontra = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        label_MS = new javax.swing.JLabel();
        label_MBD = new javax.swing.JLabel();
        label_ngayMuon = new javax.swing.JLabel();
        label_ngayTra = new javax.swing.JLabel();
        label_tinhTrang = new javax.swing.JLabel();
        jComboBox_MTmaSach = new javax.swing.JComboBox<>();
        jComboBox_MTMabandoc = new javax.swing.JComboBox<>();
        field_ngayMuon = new javax.swing.JTextField();
        field_ngayTra = new javax.swing.JTextField();
        jCheckBox_Con = new javax.swing.JCheckBox();
        jCheckBox_Roi = new javax.swing.JCheckBox();
        button_MTThem = new javax.swing.JButton();
        button_MTXoa = new javax.swing.JButton();
        button_MTSua = new javax.swing.JButton();
        button_MTRefesh = new javax.swing.JButton();
        panel_Tiemkiem = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_tiemKiem = new javax.swing.JTable();
        button_timKiem = new javax.swing.JButton();
        field_timKiem = new javax.swing.JTextField();
        button_TK_refesh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        menuitem_save = new javax.swing.JMenuItem();
        menitem_Open = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        edit_Update = new javax.swing.JMenuItem();
        homepage = new javax.swing.JMenu();
        menu_Login = new javax.swing.JMenuItem();
        menu_dangki = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 620));
        setResizable(false);

        panel_Menu.setBackground(new java.awt.Color(102, 102, 102));

        button_Quanlysach.setBackground(new java.awt.Color(102, 102, 102));
        button_Quanlysach.setForeground(new java.awt.Color(255, 255, 255));
        button_Quanlysach.setText("Quản lý sách");
        button_Quanlysach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_QuanlysachActionPerformed(evt);
            }
        });

        button_Quanlybandoc.setBackground(new java.awt.Color(102, 102, 102));
        button_Quanlybandoc.setForeground(new java.awt.Color(255, 255, 255));
        button_Quanlybandoc.setText("Quản lý bạn đọc");
        button_Quanlybandoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_QuanlybandocActionPerformed(evt);
            }
        });

        button_Quanlymuontra.setBackground(new java.awt.Color(102, 102, 102));
        button_Quanlymuontra.setForeground(new java.awt.Color(255, 255, 255));
        button_Quanlymuontra.setText("Quản lý mượn trả");
        button_Quanlymuontra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_QuanlymuontraActionPerformed(evt);
            }
        });

        button_Tiemkiem.setBackground(new java.awt.Color(102, 102, 102));
        button_Tiemkiem.setForeground(new java.awt.Color(255, 255, 255));
        button_Tiemkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/focus_group.png"))); // NOI18N
        button_Tiemkiem.setText("Tiềm kiếm");
        button_Tiemkiem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button_Tiemkiem.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        button_Tiemkiem.setIconTextGap(-10);
        button_Tiemkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_TiemkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_MenuLayout = new javax.swing.GroupLayout(panel_Menu);
        panel_Menu.setLayout(panel_MenuLayout);
        panel_MenuLayout.setHorizontalGroup(
            panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(button_Quanlysach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(button_Quanlybandoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(button_Quanlymuontra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(button_Tiemkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panel_MenuLayout.setVerticalGroup(
            panel_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_MenuLayout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addComponent(button_Quanlysach, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_Quanlybandoc, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button_Quanlymuontra, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_Tiemkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jSplitPane_main.setLeftComponent(panel_Menu);

        panel_sub.setLayout(new java.awt.CardLayout());

        panel_Quanlysach.setEnabled(false);
        panel_Quanlysach.setPreferredSize(new java.awt.Dimension(700, 482));
        panel_Quanlysach.setVerifyInputWhenFocusTarget(false);

        panel_listSach.setBackground(new java.awt.Color(255, 255, 255));

        label_tenLoaiSach.setBackground(new java.awt.Color(255, 255, 255));
        label_tenLoaiSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_tenLoaiSach.setForeground(new java.awt.Color(204, 0, 0));
        label_tenLoaiSach.setText("Danh mục các loại sách");

        button_themMaloai.setText("Thêm");
        button_themMaloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_themMaloaiActionPerformed(evt);
            }
        });

        button_xoaMaloai.setText("Xóa ");
        button_xoaMaloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_xoaMaloaiActionPerformed(evt);
            }
        });

        table_Maloaisach.setBackground(new java.awt.Color(153, 204, 255));
        table_Maloaisach.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_Maloaisach);

        label_maLoai.setText("Mã Loại");

        label_tenLoai.setText("Tên Loại");

        javax.swing.GroupLayout panel_listSachLayout = new javax.swing.GroupLayout(panel_listSach);
        panel_listSach.setLayout(panel_listSachLayout);
        panel_listSachLayout.setHorizontalGroup(
            panel_listSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(panel_listSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_listSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_tenLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_listSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panel_listSachLayout.createSequentialGroup()
                            .addComponent(button_themMaloai)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_xoaMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_listSachLayout.createSequentialGroup()
                            .addGroup(panel_listSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(label_tenLoai)
                                .addComponent(label_maLoai))
                            .addGap(39, 39, 39)
                            .addGroup(panel_listSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(field_tenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(field_maLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 78, Short.MAX_VALUE))
        );
        panel_listSachLayout.setVerticalGroup(
            panel_listSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_listSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_tenLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_listSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_maLoai)
                    .addComponent(field_maLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_listSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tenLoai)
                    .addComponent(field_tenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panel_listSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_themMaloai)
                    .addComponent(button_xoaMaloai))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(panel_listSach);

        panel_ThongtinSach.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panel_ThongtinSach.setFocusable(false);
        panel_ThongtinSach.setInheritsPopupMenu(true);

        panel_thongtinSach.setBackground(new java.awt.Color(204, 204, 255));

        label_Danhmucsach.setText("Danh mục");

        label_maSach.setText("Mã sách");

        label_tenSach.setText("Tên sách");

        label_tacGia.setText("Tác giả");

        label_giaBan.setText("Giá ");

        label_soLuong.setText("Số lượng");

        field_maSach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout panel_thongtinSachLayout = new javax.swing.GroupLayout(panel_thongtinSach);
        panel_thongtinSach.setLayout(panel_thongtinSachLayout);
        panel_thongtinSachLayout.setHorizontalGroup(
            panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_thongtinSachLayout.createSequentialGroup()
                .addGroup(panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_thongtinSachLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_maSach)
                            .addComponent(label_tenSach)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_thongtinSachLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label_tacGia)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(field_maSach, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(field_tenSach)
                    .addComponent(field_tacGia))
                .addGroup(panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_thongtinSachLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_Danhmucsach)
                            .addComponent(label_giaBan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 26, Short.MAX_VALUE))
                    .addGroup(panel_thongtinSachLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_soLuong)
                        .addGap(28, 28, 28)))
                .addGroup(panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(field_gia, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(field_soLuong)
                    .addComponent(jComboBox_maLoai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        panel_thongtinSachLayout.setVerticalGroup(
            panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_thongtinSachLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_maSach)
                    .addComponent(label_Danhmucsach)
                    .addComponent(jComboBox_maLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_tenSach)
                    .addComponent(field_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_giaBan))
                .addGap(18, 18, 18)
                .addGroup(panel_thongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tacGia)
                    .addComponent(field_tacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_soLuong))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        table_Quanlysach.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        table_Quanlysach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        table_Quanlysach.setModel(new javax.swing.table.DefaultTableModel(
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
        table_Quanlysach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_QuanlysachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Quanlysach);

        button_xoa.setText("Xóa");
        button_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_xoaActionPerformed(evt);
            }
        });

        button_them.setText("Thêm");
        button_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_themActionPerformed(evt);
            }
        });

        button_sua.setText("Sữa");
        button_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_suaActionPerformed(evt);
            }
        });

        button_Refesh.setText("Refesh");
        button_Refesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_RefeshActionPerformed(evt);
            }
        });

        label_tendanhmuc.setBackground(new java.awt.Color(51, 255, 255));
        label_tendanhmuc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_tendanhmuc.setForeground(new java.awt.Color(255, 0, 0));
        label_tendanhmuc.setText("DANH MỤC SÁCH");

        javax.swing.GroupLayout panel_ThongtinSachLayout = new javax.swing.GroupLayout(panel_ThongtinSach);
        panel_ThongtinSach.setLayout(panel_ThongtinSachLayout);
        panel_ThongtinSachLayout.setHorizontalGroup(
            panel_ThongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_ThongtinSachLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(label_tendanhmuc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel_ThongtinSachLayout.createSequentialGroup()
                .addGroup(panel_ThongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ThongtinSachLayout.createSequentialGroup()
                        .addComponent(panel_thongtinSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(panel_ThongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_them, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(button_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_Refesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        panel_ThongtinSachLayout.setVerticalGroup(
            panel_ThongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_ThongtinSachLayout.createSequentialGroup()
                .addComponent(label_tendanhmuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(panel_ThongtinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_ThongtinSachLayout.createSequentialGroup()
                        .addComponent(button_them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_xoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_sua)
                        .addGap(18, 18, 18)
                        .addComponent(button_Refesh))
                    .addComponent(panel_thongtinSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(panel_ThongtinSach);

        javax.swing.GroupLayout panel_QuanlysachLayout = new javax.swing.GroupLayout(panel_Quanlysach);
        panel_Quanlysach.setLayout(panel_QuanlysachLayout);
        panel_QuanlysachLayout.setHorizontalGroup(
            panel_QuanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        panel_QuanlysachLayout.setVerticalGroup(
            panel_QuanlysachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_QuanlysachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_sub.add(panel_Quanlysach, "panel_Quanlysach");

        panel_Quanlybandoc.setBackground(new java.awt.Color(204, 204, 255));

        label_maBandoc.setText("Mã bạn đọc");

        label_tenBandoc.setText("Tên bạn đọc");

        label_CMND.setText("CMND");

        label_gioiTinh.setText("Giới tính");

        label_NDK.setText("Ngày đăng ký");

        label_NHH.setText("Ngày hêt hạn");

        buttonGroup1.add(jCheckBox_nam);
        jCheckBox_nam.setText("Nam");

        buttonGroup1.add(jCheckBox_nu);
        jCheckBox_nu.setText("Nữ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_maBandoc)
                    .addComponent(label_tenBandoc)
                    .addComponent(label_CMND))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(field_CMND, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(field_tenBandoc)
                    .addComponent(field_maBandoc))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_NDK)
                    .addComponent(label_NHH)
                    .addComponent(label_gioiTinh))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCheckBox_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(field_NDK, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_NHH, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_maBandoc)
                    .addComponent(label_gioiTinh)
                    .addComponent(field_maBandoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_nam)
                    .addComponent(jCheckBox_nu))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tenBandoc)
                    .addComponent(label_NDK)
                    .addComponent(field_tenBandoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_NDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_CMND)
                    .addComponent(label_NHH)
                    .addComponent(field_CMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_NHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

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
        table_Quanlybandoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_QuanlybandocMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_Quanlybandoc);

        button_dangKyBandoc.setText("Đăng ký thành viên");
        button_dangKyBandoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_dangKyBandocActionPerformed(evt);
            }
        });

        button_xoaBandoc.setText("Xóa");
        button_xoaBandoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_xoaBandocActionPerformed(evt);
            }
        });

        button_suaBandoc.setText("Sữa");
        button_suaBandoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_suaBandocActionPerformed(evt);
            }
        });

        button_reshfeshBandoc.setText("Refesh");
        button_reshfeshBandoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_reshfeshBandocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_QuanlybandocLayout = new javax.swing.GroupLayout(panel_Quanlybandoc);
        panel_Quanlybandoc.setLayout(panel_QuanlybandocLayout);
        panel_QuanlybandocLayout.setHorizontalGroup(
            panel_QuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_QuanlybandocLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_QuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_QuanlybandocLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())
                    .addGroup(panel_QuanlybandocLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel_QuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel_QuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(button_reshfeshBandoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addComponent(button_suaBandoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_xoaBandoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(button_dangKyBandoc))
                        .addGap(0, 152, Short.MAX_VALUE))))
        );
        panel_QuanlybandocLayout.setVerticalGroup(
            panel_QuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_QuanlybandocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_QuanlybandocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_QuanlybandocLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panel_QuanlybandocLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(button_xoaBandoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(button_suaBandoc)
                        .addGap(18, 18, 18)
                        .addComponent(button_reshfeshBandoc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_dangKyBandoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        panel_sub.add(panel_Quanlybandoc, "panel_Quanlybandoc");

        panel_Quanlymuontra.setBackground(new java.awt.Color(204, 204, 255));

        table_Quanlymuontra.setModel(new javax.swing.table.DefaultTableModel(
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
        table_Quanlymuontra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_QuanlymuontraMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(table_Quanlymuontra);

        label_MS.setText("Mã Sách");

        label_MBD.setText("Mã Bạn đọc");

        label_ngayMuon.setText("Ngày mượn");

        label_ngayTra.setText("Ngày trả");

        label_tinhTrang.setText("Tình trạng");

        jComboBox_MTMabandoc.setToolTipText("");

        buttonGroup2.add(jCheckBox_Con);
        jCheckBox_Con.setText("Còn mượn");

        buttonGroup2.add(jCheckBox_Roi);
        jCheckBox_Roi.setText("Đã trả");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_MS)
                            .addComponent(label_MBD)
                            .addComponent(label_ngayMuon))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_ngayTra)
                        .addGap(44, 44, 44)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox_MTmaSach, 0, 131, Short.MAX_VALUE)
                    .addComponent(jComboBox_MTMabandoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(field_ngayMuon)
                    .addComponent(field_ngayTra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_tinhTrang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox_Con)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox_Roi)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_MS)
                    .addComponent(label_tinhTrang)
                    .addComponent(jComboBox_MTmaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox_Con)
                    .addComponent(jCheckBox_Roi))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_MBD)
                    .addComponent(jComboBox_MTMabandoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_ngayMuon)
                    .addComponent(field_ngayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_ngayTra)
                    .addComponent(field_ngayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        button_MTThem.setText("Đăng ký");
        button_MTThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_MTThemActionPerformed(evt);
            }
        });

        button_MTXoa.setText("Xóa");
        button_MTXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_MTXoaActionPerformed(evt);
            }
        });

        button_MTSua.setText("Sữa");
        button_MTSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_MTSuaActionPerformed(evt);
            }
        });

        button_MTRefesh.setText("Refesh");
        button_MTRefesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_MTRefeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_QuanlymuontraLayout = new javax.swing.GroupLayout(panel_Quanlymuontra);
        panel_Quanlymuontra.setLayout(panel_QuanlymuontraLayout);
        panel_QuanlymuontraLayout.setHorizontalGroup(
            panel_QuanlymuontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_QuanlymuontraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_QuanlymuontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panel_QuanlymuontraLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panel_QuanlymuontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_MTThem, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addComponent(button_MTXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_MTSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_MTRefesh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 208, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_QuanlymuontraLayout.setVerticalGroup(
            panel_QuanlymuontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_QuanlymuontraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel_QuanlymuontraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_QuanlymuontraLayout.createSequentialGroup()
                        .addComponent(button_MTThem)
                        .addGap(18, 18, 18)
                        .addComponent(button_MTXoa)
                        .addGap(18, 18, 18)
                        .addComponent(button_MTSua)
                        .addGap(18, 18, 18)
                        .addComponent(button_MTRefesh)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_QuanlymuontraLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        panel_sub.add(panel_Quanlymuontra, "panel_Quanlymuontra");

        panel_Tiemkiem.setBackground(new java.awt.Color(204, 204, 255));

        table_tiemKiem.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(table_tiemKiem);

        button_timKiem.setText("Tiềm Kiếm");
        button_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_timKiemActionPerformed(evt);
            }
        });

        field_timKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                field_timKiemCaretUpdate(evt);
            }
        });

        button_TK_refesh.setText("Refesh");
        button_TK_refesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_TK_refeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_TiemkiemLayout = new javax.swing.GroupLayout(panel_Tiemkiem);
        panel_Tiemkiem.setLayout(panel_TiemkiemLayout);
        panel_TiemkiemLayout.setHorizontalGroup(
            panel_TiemkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_TiemkiemLayout.createSequentialGroup()
                .addGroup(panel_TiemkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_TiemkiemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_TiemkiemLayout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(field_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(button_timKiem)
                        .addGap(18, 18, 18)
                        .addComponent(button_TK_refesh, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_TiemkiemLayout.setVerticalGroup(
            panel_TiemkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_TiemkiemLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panel_TiemkiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_timKiem)
                    .addComponent(field_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_TK_refesh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_sub.add(panel_Tiemkiem, "panel_Tiemkiem");

        jSplitPane_main.setRightComponent(panel_sub);

        jMenuBar1.setMargin(new java.awt.Insets(5, 0, 0, 0));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(50, 20));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(200, 30));

        jMenu2.setBackground(new java.awt.Color(153, 255, 255));
        jMenu2.setText("File");

        menuitem_save.setText("Save");
        jMenu2.add(menuitem_save);

        menitem_Open.setText("Open");
        jMenu2.add(menitem_Open);

        jMenuBar1.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(255, 102, 0));
        jMenu3.setText("Edit");

        edit_Update.setText("Update");
        jMenu3.add(edit_Update);

        jMenuBar1.add(jMenu3);

        homepage.setText("Home");

        menu_Login.setText("Login");
        menu_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_LoginActionPerformed(evt);
            }
        });
        homepage.add(menu_Login);

        menu_dangki.setText("Đăng ký");
        menu_dangki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_dangkiActionPerformed(evt);
            }
        });
        homepage.add(menu_dangki);

        jMenuBar1.add(homepage);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane_main)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSplitPane_main, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //---------------------------------------------------------------------------------------------------------------------------------------------------   
    
    // method xử lý chuyển cảnh các menusun từ các nút nahns button chính
    private void button_QuanlysachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_QuanlysachActionPerformed
          cardLayout.show(panel_sub, "panel_Quanlysach");
    }//GEN-LAST:event_button_QuanlysachActionPerformed

    private void button_QuanlybandocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_QuanlybandocActionPerformed
          cardLayout.show(panel_sub, "panel_Quanlybandoc");
    }//GEN-LAST:event_button_QuanlybandocActionPerformed

    private void button_QuanlymuontraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_QuanlymuontraActionPerformed
          cardLayout.show(panel_sub, "panel_Quanlymuontra");
    }//GEN-LAST:event_button_QuanlymuontraActionPerformed

    private void button_TiemkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_TiemkiemActionPerformed
          cardLayout.show(panel_sub, "panel_Tiemkiem");
    }//GEN-LAST:event_button_TiemkiemActionPerformed

   
    
    
    
    
    
  //-----------------------------------------------------------Phần Panel_Quanlysach----------------------------------------------------------------------------------------  
    
    // xu ly su kien cho nut them (insert into table vao bang table)
    private void button_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_themActionPerformed
         // tiến hành quét điều kiện nếu chưa nhậ gì sẽ báo lõi
         if(field_maSach.getText().isEmpty() 
                || field_tenSach.getText().isEmpty() 
                  || field_tacGia.getText().isEmpty() 
                  || field_gia.getText().isEmpty() 
                  || field_soLuong.getText().isEmpty() ){
             
             JOptionPane.showMessageDialog(this,"Bạn chưa điền thông tin gì à?");
         }else{

      // thiết lập nơi nhập đưa dl từ bàn phím vào các fiel tg ứng trên giao diện
                sach_Model.setMaSach(field_maSach.getText());
                sach_Model.setTenSach(field_tenSach.getText());
                sach_Model.setTacGia(field_tacGia.getText());
                
                // dung getSelectItem() tra ve chi muc nguoi dung chon
               String Select = (String)(jComboBox_maLoai.getSelectedItem());
               sach_Model.setMaLoai(Select);
              
               sach_Model.setGiaSach(Double.valueOf(field_gia.getText()));
               sach_Model.setSoLuong(Integer.parseInt(field_soLuong.getText()));

                service_Controller.Insert_Quanlysach(sach_Model);
         }
    }//GEN-LAST:event_button_themActionPerformed

    
    
 //---------------------------------------------------------------------------------------------------------------------------------------------------   
    
    // method xóa sách dữ liệu
    private void button_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_xoaActionPerformed
         int row =  table_Quanlysach.getSelectedRow();
                // nếu người dùng chưa choinj gì mà bâ xóa xem như 11 là chưa chọn
                if(row == -1){
                    // show thong bao la chua chon gi ma doi xoa
                    JOptionPane.showMessageDialog(Giaodien_Main.this, "vui long chon dong muon xoa","loi",JOptionPane.ERROR_MESSAGE);
                }else{
                    // nc lai thi show nhac nho la co muon chac an xoa khong???
                    int confirm = JOptionPane.showConfirmDialog(Giaodien_Main.this,"Ban co chac an muon xoa khong?");
                    // neu chon yes thi thuc thi xoa
                    if(confirm==JOptionPane.YES_NO_OPTION){
                        String maSach_Quanlysach = String.valueOf(table_Quanlysach.getValueAt(row,0));
                        service_Controller.Delete_Quanlysach(maSach_Quanlysach);

                            // xoa xong thi refresh lai du lieu
                            defaultTableModel.setRowCount(0);
                            setData(Service_Controller.getAllusers());
                        }
                    }
    }//GEN-LAST:event_button_xoaActionPerformed

 //---------------------------------------------------------------------------------------------------------------------------------------------------   
    // xử lý nút resh lại cập nhật lại tất cả của panel Quanlysach
    private void button_RefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_RefeshActionPerformed
        // bang 01 ListSach
        defaultTableModel.setRowCount(0);
                List<Sach_Model> sach_Models = service_Controller.getAllusers();
                setData(service_Controller.getAllusers());
          //bang 02 Maloaisach      
         defaultTableModel1.setRowCount(0);
            List<Maloaisach>maloaisachs = service_Controller.getAllusers2();
                setData2(service_Controller.getAllusers2());    
           
          
         // thiết lập xóa hết các ô đg điền thông tin cho về ban đầu như chưa có gì
                field_maSach.setText("");
                field_tenSach.setText("");
                field_tacGia.setText("");
                // cách reset jcombox về ban đầu sau mỗi lần refesh
//                jComboBox_maLoai.setSelectedIndex(0);
                field_gia.setText("");
                field_soLuong.setText("");
                field_maLoai.setText("");                                                                  
                field_tenLoai.setText("");
                
                
           // load dl tu table maloai sach vao combox cua panel_Quanlysach.... add vao nut refesh lun--> de moi lan load moi lan load dc dl va cap nhat lun ml
           //cach cu
                   // thuc hien chuc nag load du lieu len combobox
//        ArrayList<String> List_maLoai = service_Controller.getLoad_ComboxSach();
//                for(String item: List_maLoai){
//                     jComboBox_maLoai.addItem(item.toString());
//                     //
//                     
//                }

         // cach moi goij va khoi tao setdata trc tren contructor
           setLoadcombox(service_Controller.getLoad_ComboxSach());
                        
    }//GEN-LAST:event_button_RefeshActionPerformed

    
    //---------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    // xử lý chức năng khi chọn dòng dữ liệu trên table nó sẽ hiển thị lên các field thông tin để có thể tùy chỉnh update hay xóa trực tiếp
    private void table_QuanlysachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_QuanlysachMouseClicked
        int row = table_Quanlysach.getSelectedRow();
        if(row>=0){
            field_maSach.setText(table_Quanlysach.getValueAt(row,0). toString());
            field_tenSach.setText(table_Quanlysach.getValueAt(row,1). toString());
            field_tacGia.setText(table_Quanlysach.getValueAt(row,2). toString());
             
             /*hien thi tt tu table len jcombox*/ 
            // dung cách 2 switch case
            String maloai = table_Quanlysach.getValueAt(row, 3).toString();
             switch (maloai){
                 case "ML01":
                     jComboBox_maLoai.setSelectedIndex(0);
                     break;
                 case "ML02":
                     jComboBox_maLoai.setSelectedIndex(1);
                     break;
                 case "ML03":
                     jComboBox_maLoai.setSelectedIndex(2);
                     break;
                 case "ML04":
                     jComboBox_maLoai.setSelectedIndex(3);
                     break; 
                 case "ML05":
                     jComboBox_maLoai.setSelectedIndex(4);
                     break; 
                 case "ML06":
                     jComboBox_maLoai.setSelectedIndex(5);
                     break;
                 case "ML07":
                     jComboBox_maLoai.setSelectedIndex(6);
                     break;
                 case "ML08":
                     jComboBox_maLoai.setSelectedIndex(7);
                     break;
                 case "ML09":
                     jComboBox_maLoai.setSelectedIndex(8);
                     break; 
                 case "ML10":
                     jComboBox_maLoai.setSelectedIndex(9);
                     break;      
             }
             
            field_gia.setText(table_Quanlysach.getValueAt(row,4). toString());
            field_soLuong.setText(table_Quanlysach.getValueAt(row,5). toString());     
        }
    }//GEN-LAST:event_table_QuanlysachMouseClicked

    //---------------------------------------------------------------------------------------------------------------------------------------------------
    
 // tthực hiện chức năng cập nhật cho trang quản lý sách
    private void button_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_suaActionPerformed
         int row = table_Quanlysach.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(Giaodien_Main.this,"vui long chon trc khi update","loi",JOptionPane.ERROR_MESSAGE);
                }else{                    
                       sach_Model.setMaSach(field_maSach.getText()); 
                       sach_Model.setTenSach(field_tenSach.getText());
                       sach_Model.setTacGia(field_tacGia.getText());
                       
                         // dung getSelectItem() tra ve chi muc nguoi dung chon
                       String Select = (String)(jComboBox_maLoai.getSelectedItem());
                       sach_Model.setMaLoai(Select);
                     
                       sach_Model.setGiaSach(Double.valueOf(field_gia.getText()));
                       sach_Model.setSoLuong(Integer.parseInt(field_soLuong.getText()));
   
                       
                       service_Controller.Update_Quanlysach(sach_Model);
            

                      
                       // sua xong thi refresh lai du lieu
                      defaultTableModel.setRowCount(0);
                      setData(Service_Controller.getAllusers());
           }
    }//GEN-LAST:event_button_suaActionPerformed

    

    
    
    
    
    //--------------------------------------------Phần giao diện của panel_Quanlybandoc-------------------------------------------------------------------------------------------------------
         // chuc nang dang ky ban doc
    
    
    private void button_dangKyBandocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_dangKyBandocActionPerformed
         // tiến hành quét điều kiện nếu chưa nhậ gì sẽ báo lõi
              if(field_maBandoc.getText().isEmpty() 
                  || field_tenBandoc.getText().isEmpty() 
                  || field_CMND.getText().isEmpty() 
                  || field_NDK.getText().isEmpty() 
                  || field_NHH.getText().isEmpty() ){
             
             JOptionPane.showMessageDialog(this,"Bạn chưa điền thông tin gì à?");
         }else{
             
         }

      // thiết lập nơi nhập đưa dl từ bàn phím vào các fiel tg ứng trên giao diện
                quanlybandoc_Model.setMaBandoc(field_maBandoc.getText());
                 quanlybandoc_Model.setTenBandoc(field_tenBandoc.getText());
                  quanlybandoc_Model.setCMND(field_CMND.getText());
                  // gioi tinh
                   String lS = "";
                    if(jCheckBox_nam.isSelected()){
                        lS +="Nam";
                    }else if(jCheckBox_nu.isSelected()){
                        lS += "Nu";
                    }
                   quanlybandoc_Model.setGioiTinh(lS);

                 quanlybandoc_Model.setNgayDangky(field_NDK.getText());
                 quanlybandoc_Model.setNgayHethan(field_NHH.getText());

                service_Controller.Dangkybandoc(quanlybandoc_Model);
    }//GEN-LAST:event_button_dangKyBandocActionPerformed

    
    //-------------------------------------------------
    // nut resh ban doc
    
    private void button_reshfeshBandocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_reshfeshBandocActionPerformed
           defaultTableModel2.setRowCount(0);
            List<Quanlybandoc_Model> quanlybandoc_Models = service_Controller.getAllMabandocs();
                setData_Quanlybandoc(service_Controller.getAllMabandocs());    
                
                // thiết lập xóa hết các ô đg điền thông tin cho về ban đầu như chưa có gì
                field_maBandoc.setText("");
                field_tenBandoc.setText("");
                field_CMND.setText("");
                buttonGroup1.clearSelection();
                field_NDK.setText("");
                field_NHH.setText("");
    }//GEN-LAST:event_button_reshfeshBandocActionPerformed
    

//----------------------------------------------------------
    // chuc nang gán  dong tu table len field(nhấn vào sẽ hiển thị lên các field tương ứng)

    private void table_QuanlybandocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_QuanlybandocMouseClicked
         int row = table_Quanlybandoc.getSelectedRow();
        if(row>=0){
            field_maBandoc.setText(table_Quanlybandoc.getValueAt(row,0). toString());
             field_tenBandoc.setText(table_Quanlybandoc.getValueAt(row,1). toString());
              field_CMND.setText(table_Quanlybandoc.getValueAt(row,2). toString());
              
               String gioitinh = table_Quanlybandoc.getValueAt(row,3).toString();
             switch (gioitinh) {
                 case "Nam":
                    jCheckBox_nam.setSelected(true);
                    jCheckBox_nu.setSelected(false);
                    break;
                 case "Nữ":
                    jCheckBox_nam.setSelected(false);
                    jCheckBox_nu.setSelected(true);
                    break;   
                default:
                    jCheckBox_nam.setSelected(true);
                    jCheckBox_nu.setSelected(true);
                    break;
            }
             
             
               field_NDK.setText(table_Quanlybandoc.getValueAt(row,4). toString());
                field_NHH.setText(table_Quanlybandoc.getValueAt(row,5). toString());
        }
    }//GEN-LAST:event_table_QuanlybandocMouseClicked

    //----------------------------------------------------------
    // chuc nang xoa quanlybandoc
    
    private void button_xoaBandocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_xoaBandocActionPerformed
         int row =  table_Quanlybandoc.getSelectedRow();
                // nếu người dùng chưa choinj gì mà bâ xóa xem như 11 là chưa chọn
                if(row == -1){
                    // show thong bao la chua chon gi ma doi xoa
                    JOptionPane.showMessageDialog(Giaodien_Main.this, "vui long chon dong muon xoa","loi",JOptionPane.ERROR_MESSAGE);
                }else{
                    // nc lai thi show nhac nho la co muon chac an xoa khong???
                    int confirm = JOptionPane.showConfirmDialog(Giaodien_Main.this,"Ban co chac an muon xoa khong?");
                    // neu chon yes thi thuc thi xoa
                    if(confirm==JOptionPane.YES_NO_OPTION){
                        String maBandoc_Quanlybandoc = String.valueOf(table_Quanlybandoc.getValueAt(row,0));
                        service_Controller.Delete_Quanlybandoc(maBandoc_Quanlybandoc);

                            // xoa xong thi refresh lai du lieu
                            defaultTableModel2.setRowCount(0);
                            setData_Quanlybandoc(Service_Controller.getAllMabandocs());
                        }
                    }
    }//GEN-LAST:event_button_xoaBandocActionPerformed

    
    //----------------------------------------------------------
    // chuc nang update quanlybandoc

    private void button_suaBandocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_suaBandocActionPerformed
         int row = table_Quanlybandoc.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(Giaodien_Main.this,"vui long chon trc khi update","loi",JOptionPane.ERROR_MESSAGE);
                }else{                    
                       quanlybandoc_Model.setMaBandoc(field_maBandoc.getText()); 
                       quanlybandoc_Model.setTenBandoc(field_tenBandoc.getText());
                       quanlybandoc_Model.setCMND(field_CMND.getText());
                       
                         // gioi tinh
                        String lS = "";
                         if(jCheckBox_nam.isSelected()){
                             lS +="Nam";
                         }else if(jCheckBox_nu.isSelected()){
                             lS += "Nu";
                         }
                        quanlybandoc_Model.setGioiTinh(lS);
                     
                       quanlybandoc_Model.setNgayDangky(field_NDK.getText());
                       quanlybandoc_Model.setNgayHethan(field_NHH.getText());
   
                       
                       service_Controller.Update_Quanlybandoc(quanlybandoc_Model);
            

                      
                       // sua xong thi refresh lai du lieu
                      defaultTableModel2.setRowCount(0);
                      setData_Quanlybandoc(Service_Controller.getAllMabandocs());
           }
    }//GEN-LAST:event_button_suaBandocActionPerformed

    
    
    
    
    
    
    
    
    
    
    //-----------------------------------------------------Bổ sung cho panel Quanlysach--------------------------------------------------------
    // chuc nang them moi va load tu bang maloai sach vao table maloai sach tren giao dien va combobox
    private void button_themMaloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_themMaloaiActionPerformed
         // thc hien chuc nang insert vao table Maloaisach
            // tiến hành quét điều kiện nếu chưa nhậ gì sẽ báo lõi
              if(field_maLoai.getText().isEmpty() 
                   || field_tenLoai.getText().isEmpty() ){
                   JOptionPane.showMessageDialog(this,"Bạn chưa điền thông tin gì à?");
          }else{

       // thiết lập nơi nhập đưa dl từ bàn phím vào các fiel tg ứng trên giao diện
                 maloaisach.setMaLoai(field_maLoai.getText());
                 maloaisach.setTenloai(field_tenLoai.getText());

                 service_Controller.Insert_Maloaisach(maloaisach);
        
              }
    }//GEN-LAST:event_button_themMaloaiActionPerformed

    // mục xóa bang Maloaisach
    private void button_xoaMaloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_xoaMaloaiActionPerformed
         int row =  table_Maloaisach.getSelectedRow();
                // nếu người dùng chưa chọn gì mà dâ xóa xem như 1a là chưa chọn
                if(row == -1){
                    // show thong bao la chua chon gi ma doi xoa
                    JOptionPane.showMessageDialog(Giaodien_Main.this, "vui long chon dong muon xoa","loi",JOptionPane.ERROR_MESSAGE);
                }else{
                    // nc lai thi show nhac nho la co muon chac an xoa khong???
                    int confirm = JOptionPane.showConfirmDialog(Giaodien_Main.this,"Ban co chac an muon xoa khong?");
                    // neu chon yes thi thuc thi xoa
                    if(confirm==JOptionPane.YES_NO_OPTION){
                        String QLMaloaisach = String.valueOf(table_Maloaisach.getValueAt(row,0));
                        service_Controller.Delete_Maloaisach(QLMaloaisach);

                            // xoa xong thi refresh lai du lieu
                            defaultTableModel1.setRowCount(0);
                            setData2(Service_Controller.getAllusers2());
                        }
                    }
    }//GEN-LAST:event_button_xoaMaloaiActionPerformed

    
    
    
    
    
    
    
    
    
//*************************************Phan panel Quanlymuontra************************************************
    // nut refesh cua panel quanlymuontra
    private void button_MTRefeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_MTRefeshActionPerformed
         // load dl cua table_Quanlymuontra
        defaultTableModel_Quanlymuontra.setRowCount(0);
                List<Quanlymuontra> quanlymuontras = service_Controller.getAllMuontra();
                setQuanlymuontra(service_Controller.getAllMuontra());
        
          
          // thiết lập xóa hết các ô đg điền thông tin cho về ban đầu như chưa có gì              
                field_ngayMuon.setText("");
                field_ngayTra.setText("");
                //clear khi refesh lại checkbok ỏ có thẻ code buttongroup2.setSelected(fasle);
                buttonGroup2.clearSelection();
    
          //load dữ liệu cho jcombox panel quanlymuontra
           setLoadcombox_QLmuontra_maSach(service_Controller.getLoad_ComboxMuontra_maSach());
           setLoadcombox_QLmuontra_maBandoc(service_Controller.getLoad_ComboxMuontra_maBandoc());
                        
    }//GEN-LAST:event_button_MTRefeshActionPerformed

    
    // phần xử ly chuột phải in dữ liệu lên field khi ấn chọn
    private void table_QuanlymuontraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_QuanlymuontraMouseClicked
         int row = table_Quanlymuontra.getSelectedRow();
        if(row>=0){
           /*hien thi tt tu table len jcombox*/ 
            // dung cach 2 switch case cho combobox maSach
            String masach = table_Quanlymuontra.getValueAt(row, 0).toString();
             switch (masach){
                 case "MS01":
                     jComboBox_MTmaSach.setSelectedIndex(0);
                     break;
                 case "MS02":
                     jComboBox_MTmaSach.setSelectedIndex(1);
                     break;
                 case "MS03":
                     jComboBox_MTmaSach.setSelectedIndex(2);
                     break;
                 case "MS04":
                     jComboBox_MTmaSach.setSelectedIndex(3);
                     break;
                 case "MS05":
                     jComboBox_MTmaSach.setSelectedIndex(4);
                     break; 
                 case "MS06":
                     jComboBox_MTmaSach.setSelectedIndex(5);
                     break;
                 case "MS07":
                     jComboBox_MTmaSach.setSelectedIndex(6);
                     break;
                 case "MS08":
                     jComboBox_MTmaSach.setSelectedIndex(7);
                     break;
                 case "MS09":
                     jComboBox_MTmaSach.setSelectedIndex(8);
                     break;
                 case "MS10":
                     jComboBox_MTmaSach.setSelectedIndex(9);
                     break;     
             }
             
            // dung cách 2 switch case cho combobox msLoai
            String maBandoc = table_Quanlymuontra.getValueAt(row, 1).toString();
             switch (maBandoc){
                 case "MBD01":
                     jComboBox_MTMabandoc.setSelectedIndex(0);
                     break;
                case "MBD02":
                     jComboBox_MTMabandoc.setSelectedIndex(1);
                     break;
                case "MBD03":
                     jComboBox_MTMabandoc.setSelectedIndex(2);
                     break;
                case "MBD04":
                     jComboBox_MTMabandoc.setSelectedIndex(3);
                     break;
                case "MBD05":
                     jComboBox_MTMabandoc.setSelectedIndex(4);
                     break;
                case "MBD06":
                     jComboBox_MTMabandoc.setSelectedIndex(5);
                     break;     
             }
           
          /*tt hien thi len field*/  
            field_ngayMuon.setText(table_Quanlymuontra.getValueAt(row,2). toString());
            field_ngayTra.setText(table_Quanlymuontra.getValueAt(row,3). toString()); 
            
         /* display lên checkbox khi nhấn D-click vào tt trên table hiển thị ra field tuong ung*/
            //cach 01 if-else
//               String tinhTranng = table_Quanlymuontra.getValueAt(row,4).toString();
//               if(tinhTranng.equals("Còn mượn")){
//                   jCheckBox_Con.setSelected(true);
//               }else if(tinhTranng.equals("Đã trả")){
//                   jCheckBox_Roi.setSelected(true);
//               }

            // cach 02 - switch-case
            
             String tinhTranng = table_Quanlymuontra.getValueAt(row,4).toString();
             switch (tinhTranng) {
                 case "Còn mượn":
                    jCheckBox_Con.setSelected(true);
                    jCheckBox_Roi.setSelected(false);
                    break;
                 case "Đã trả":
                    jCheckBox_Con.setSelected(false);
                    jCheckBox_Roi.setSelected(true);
                    break;   
                default:
                    jCheckBox_Con.setSelected(true);
                    jCheckBox_Roi.setSelected(true);
                    break;
            }                        
             
        }
    }//GEN-LAST:event_table_QuanlymuontraMouseClicked

   
    
   // chuc nang dang ky muon tra(insertt into table) 
    private void button_MTThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_MTThemActionPerformed
        // tiến hành quét điều kiện nếu chưa nhậ gì sẽ báo lõi
              if(field_ngayMuon.getText().isEmpty() 
                  || field_ngayTra.getText().isEmpty()){
             
             JOptionPane.showMessageDialog(this,"Bạn chưa điền thông tin gì à?");
         }else{
             
      // thiết lập nơi nhập đưa dl từ bàn phím vào các fiel tg ứng trên giao diện
            // dung getSelectItem() tra ve chi muc nguoi dung chon
               String Mt_maSach = (String)(jComboBox_MTmaSach.getSelectedItem());
               quanlymuontra.setMaSach(Mt_maSach);
               
               String Mt_maBandoc = (String)(jComboBox_MTMabandoc.getSelectedItem());
               quanlymuontra.setMaBandoc(Mt_maBandoc);
               
               quanlymuontra.setNgayMuon(field_ngayMuon.getText());
               quanlymuontra.setNgayTra(field_ngayTra.getText());
               
               // them cho chekcbox
                  // tinhTrang
                   String tt = "";
                    if(jCheckBox_Con.isSelected()){
                        tt +="Còn mượn";
                    }else if(jCheckBox_Roi.isSelected()){
                        tt += "Đã trả";
                    }
                   quanlymuontra.setTinhTrang(tt);

                service_Controller.Dangky_muontra(quanlymuontra);
          }
    }//GEN-LAST:event_button_MTThemActionPerformed

    
    // xay dung chuc nang xoa trong Quanlymuontra
    private void button_MTXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_MTXoaActionPerformed
        int row =  table_Quanlymuontra.getSelectedRow();
                // nếu người dùng chưa chon gì mà bâ xóa xem như 11 là chưa chọn
                if(row == -1){
                    // show thong bao la chua chon gi ma doi xoa
                    JOptionPane.showMessageDialog(Giaodien_Main.this, "vui long chon dong muon xoa","loi",JOptionPane.ERROR_MESSAGE);
                }else{
                    // nc lai thi show nhac nho la co muon chac an xoa khong???
                    int confirm = JOptionPane.showConfirmDialog(Giaodien_Main.this,"Ban co chac an muon xoa khong?");
                    // neu chon yes thi thuc thi xoa
                    if(confirm==JOptionPane.YES_NO_OPTION){
                        String del_MtmaSach = String.valueOf(table_Quanlymuontra.getValueAt(row,0));
                        service_Controller.Delete_Quanlymuontra(del_MtmaSach);

                            // xoa xong thi refresh lai du lieu
                            defaultTableModel_Quanlymuontra.setRowCount(0);
                            setQuanlymuontra(service_Controller.getAllMuontra());
                        }
                    }
    }//GEN-LAST:event_button_MTXoaActionPerformed

    // xay dung chuc nang update cap nhat sua cho panel Quanlymuontra
    private void button_MTSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_MTSuaActionPerformed
         int row = table_Quanlymuontra.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(Giaodien_Main.this,"vui long chon trc khi update","loi",JOptionPane.ERROR_MESSAGE);
                }else{    
                    
                        String Mt_maSach = (String)(jComboBox_MTmaSach.getSelectedItem());
                        quanlymuontra.setMaSach(Mt_maSach);
                        
                       quanlymuontra.setNgayMuon(field_ngayMuon.getText()); 
                       quanlymuontra.setNgayTra(field_ngayTra.getText());
                       
                         // tinhTrang
                        String tt = "";
                         if(jCheckBox_Con.isSelected()){
                             tt +="Còn mượn";
                         }else if(jCheckBox_Roi.isSelected()){
                             tt += "Đã trả";
                         }
                        quanlymuontra.setTinhTrang(tt);

                       service_Controller.Update_Quanlymuontra(quanlymuontra);
            

                      
                       // sua xong thi refresh lai du lieu
                      defaultTableModel_Quanlymuontra.setRowCount(0);
                      setQuanlymuontra(service_Controller.getAllMuontra());
           }
    }//GEN-LAST:event_button_MTSuaActionPerformed

    
    



    
/******************************Panel_tiemKiem*********************************************************/  
   // chuc nang refesh panel quanlytiemkiem
    
    
    private void button_TK_refeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_TK_refeshActionPerformed
         // load dl cua table_Quanlymuontra
        defaultTableModel_Quanlytiemkiem.setRowCount(0);
                List<Quanlytiemkiem> quanlytiemkiems = service_Controller.getAllTiemkiem();
                  for(Quanlytiemkiem tk: quanlytiemkiems){
                       defaultTableModel_Quanlytiemkiem.addRow(new Object[]{tk.getMaSach(), tk.getTenSach(), tk.getMaBandoc(),
                        tk.getTenBandoc(), tk.getNgayMuon(),tk.getNgayTra(),tk.getTinhTrang()});
                 } 

    }//GEN-LAST:event_button_TK_refeshActionPerformed

    
    
  // chuc nang tiem kiem 
    public void find_S(){
        //clear các dòng code về ban đầu khi tiềm kiếm để lọc ra dòng mong mún theo điều kiên
        defaultTableModel_Quanlytiemkiem = (DefaultTableModel) table_tiemKiem.getModel();
        defaultTableModel_Quanlytiemkiem.setRowCount(0);
        for(Quanlytiemkiem find: service_Controller.find_Search(MBD)){
            Object dataRow[]= new Object[7];
            dataRow[0]= find.getMaSach();
            dataRow[1]= find.getTenSach();
            dataRow[2]= find.getMaBandoc();
            dataRow[3]= find.getTenBandoc();
            dataRow[4]= find.getNgayMuon();
            dataRow[5]= find.getNgayTra();
            dataRow[6]= find.getTinhTrang();
            defaultTableModel_Quanlytiemkiem.addRow(dataRow);
        }
    }
    
    
    
    // xu ly action su kien cho nut nhan find tiem kiem
    private void button_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_timKiemActionPerformed
        MBD = field_timKiem.getText();
        find_S();
    }//GEN-LAST:event_button_timKiemActionPerformed

   // xử lý sự kiện caretupdate để khi nhấn tiềm đến tt nào nó sẽ hiển thị linh đông theo như vậy
    // ví dụ tiềm bạn đọc MBD mà mới bấm MDB thì tất cae MBD0 sẽ hiển ra theo như mình điền như  vậy linh đọng chuyển 
    private void field_timKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_field_timKiemCaretUpdate
        MBD = field_timKiem.getText();
        find_S();
    }//GEN-LAST:event_field_timKiemCaretUpdate

    
    
    
    
    
    
    
    //****************************************************************************************
    //******************chuc nang xu ly su kien cho các menue item******************************
    //*******************************************************************************************
    
    // chuc nang lk mo frame Login
    private void menu_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_LoginActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_menu_LoginActionPerformed

    // chuc nang lien ket mp frame Dangnhap
    private void menu_dangkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_dangkiActionPerformed
        new Dangki_login();
        dispose();
    }//GEN-LAST:event_menu_dangkiActionPerformed

    
    

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton button_MTRefesh;
    private javax.swing.JButton button_MTSua;
    private javax.swing.JButton button_MTThem;
    private javax.swing.JButton button_MTXoa;
    private javax.swing.JButton button_Quanlybandoc;
    private javax.swing.JButton button_Quanlymuontra;
    private javax.swing.JButton button_Quanlysach;
    private javax.swing.JButton button_Refesh;
    private javax.swing.JButton button_TK_refesh;
    private javax.swing.JButton button_Tiemkiem;
    private javax.swing.JButton button_dangKyBandoc;
    private javax.swing.JButton button_reshfeshBandoc;
    private javax.swing.JButton button_sua;
    private javax.swing.JButton button_suaBandoc;
    private javax.swing.JButton button_them;
    private javax.swing.JButton button_themMaloai;
    private javax.swing.JButton button_timKiem;
    private javax.swing.JButton button_xoa;
    private javax.swing.JButton button_xoaBandoc;
    private javax.swing.JButton button_xoaMaloai;
    private javax.swing.JMenuItem edit_Update;
    private javax.swing.JTextField field_CMND;
    private javax.swing.JTextField field_NDK;
    private javax.swing.JTextField field_NHH;
    private javax.swing.JTextField field_gia;
    private javax.swing.JTextField field_maBandoc;
    private javax.swing.JTextField field_maLoai;
    private javax.swing.JTextField field_maSach;
    private javax.swing.JTextField field_ngayMuon;
    private javax.swing.JTextField field_ngayTra;
    private javax.swing.JTextField field_soLuong;
    private javax.swing.JTextField field_tacGia;
    private javax.swing.JTextField field_tenBandoc;
    private javax.swing.JTextField field_tenLoai;
    private javax.swing.JTextField field_tenSach;
    private javax.swing.JTextField field_timKiem;
    private javax.swing.JMenu homepage;
    private javax.swing.JCheckBox jCheckBox_Con;
    private javax.swing.JCheckBox jCheckBox_Roi;
    private javax.swing.JCheckBox jCheckBox_nam;
    private javax.swing.JCheckBox jCheckBox_nu;
    private javax.swing.JComboBox<String> jComboBox_MTMabandoc;
    private javax.swing.JComboBox<String> jComboBox_MTmaSach;
    private javax.swing.JComboBox<String> jComboBox_maLoai;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane_main;
    private javax.swing.JLabel label_CMND;
    private javax.swing.JLabel label_Danhmucsach;
    private javax.swing.JLabel label_MBD;
    private javax.swing.JLabel label_MS;
    private javax.swing.JLabel label_NDK;
    private javax.swing.JLabel label_NHH;
    private javax.swing.JLabel label_giaBan;
    private javax.swing.JLabel label_gioiTinh;
    private javax.swing.JLabel label_maBandoc;
    private javax.swing.JLabel label_maLoai;
    private javax.swing.JLabel label_maSach;
    private javax.swing.JLabel label_ngayMuon;
    private javax.swing.JLabel label_ngayTra;
    private javax.swing.JLabel label_soLuong;
    private javax.swing.JLabel label_tacGia;
    private javax.swing.JLabel label_tenBandoc;
    private javax.swing.JLabel label_tenLoai;
    private javax.swing.JLabel label_tenLoaiSach;
    private javax.swing.JLabel label_tenSach;
    private javax.swing.JLabel label_tendanhmuc;
    private javax.swing.JLabel label_tinhTrang;
    private javax.swing.JMenuItem menitem_Open;
    private javax.swing.JMenuItem menu_Login;
    private javax.swing.JMenuItem menu_dangki;
    private javax.swing.JMenuItem menuitem_save;
    private javax.swing.JPanel panel_Menu;
    private javax.swing.JPanel panel_Quanlybandoc;
    private javax.swing.JPanel panel_Quanlymuontra;
    private javax.swing.JPanel panel_Quanlysach;
    private javax.swing.JPanel panel_ThongtinSach;
    private javax.swing.JPanel panel_Tiemkiem;
    private javax.swing.JPanel panel_listSach;
    private javax.swing.JPanel panel_sub;
    private javax.swing.JPanel panel_thongtinSach;
    private javax.swing.JTable table_Maloaisach;
    private javax.swing.JTable table_Quanlybandoc;
    private javax.swing.JTable table_Quanlymuontra;
    private javax.swing.JTable table_Quanlysach;
    private javax.swing.JTable table_tiemKiem;
    // End of variables declaration//GEN-END:variables

   
}
