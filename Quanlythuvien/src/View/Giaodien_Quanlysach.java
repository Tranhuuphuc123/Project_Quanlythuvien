package View;

import Controller.Service_controller;
import Model.Sach_Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Giaodien_Quanlysach extends  JFrame {

    // biến gọi từ các package khác
    Sach_Model sach_model;
    DefaultTableModel defaultTableModel; // defaultTableModel de thiet lap ten addcolumn cho table tren giao dien
    Service_controller service_controller;

    // biến toàn cục để load dữ liệu thông qua câu lệnh select * from.. từ dl bảng table ở mySQL lên table ở giao diện SWing
    private void setData(List<Sach_Model> sach_models){
        for(Sach_Model sach_model: sach_models){
            defaultTableModel.addRow(new Object[]{sach_model.getMaSach(),sach_model.getTenSach(),sach_model.getLoaiSach(),
                    sach_model.getNhaXuatBan(), sach_model.getTacGia(), sach_model.getSoLuong()});
        }
    }


    // phần khai báo tự định nghĩa của GUI java swing
    private JTable table_Quanlysach;
    private JTextField field_maSach;
    private JTextField field_tenSach;
    private JTextField field_Nxb;
    private JTextField field_tacGia;
    private JTextField field_soLuong;
    private JButton button_Insert;
    private JButton button_Delete;
    private JButton button_Update;
    private JButton button_Back;
    private JButton button_Refesh;
    private JLabel label_maSach;
    private JLabel label_tenSach;
    private JLabel label_loaiSach;
    private JLabel label_Nxb;
    private JLabel label_tacGia;
    private JLabel lebel_soLuong;
    private JRadioButton radioButton_Congnghe;
    private JRadioButton radioButton_Khxh;
    private JRadioButton radioButton_Dialy;
    private JRadioButton radioButton_vanHoc;
    private JTextArea area_moTa;
    private JLabel laebl_moTa;
    private JPanel panel_Quanlysach;


    //contructor
    public Giaodien_Quanlysach(){
        service_controller = new Service_controller();
        sach_model = new Sach_Model();
        //thiết lập chạy giao diện GUI khi vẽ vào code
        this.setContentPane(panel_Quanlysach);
        this.pack();
        // hiển thị JFrame
        this.setVisible(true);

        // lop xay duwng giao dien
        this.init();


        // chức năng nút quay lại Back
        button_Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Giaodienchinh().setVisible(true);
                dispose();
            }
        });



        // thực hiện chức năng refesh dữ liệu lại của table

        button_Refesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultTableModel.setRowCount(0);
                List<Sach_Model> sach_models = service_controller.getAllusers();
                setData(service_controller.getAllusers());
            }
        });



        // thực hiện chức năng thêm mới insert dl vào sql và hiển thị lên table của giao diện
        button_Insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // thiết lập nơi nhập đưa dl từ bàn phím vào các fiel tg ứng trên giao diện
                sach_model.setMaSach(field_maSach.getText());
                sach_model.setTenSach(field_tenSach.getText());
                // thiet lap cac radio button trong loai sach
                String lS = "";
                if(radioButton_vanHoc.isSelected()){
                    lS +="vanHoc";
                }else if(radioButton_Khxh.isSelected()){
                    lS += ",Khxh";
                }else if(radioButton_Congnghe.isSelected()){
                    lS += ",Congnghe";
                }else if(radioButton_Dialy.isSelected()){
                    lS += ",Dialy";
                }
                sach_model.setLoaiSach(lS);

                sach_model.setNhaXuatBan(field_Nxb.getText());
                sach_model.setTacGia(field_tacGia.getText());
                sach_model.setSoLuong(Integer.parseInt(field_soLuong.getText()));

                service_controller.Insert_Quanlysach(sach_model);

            }
        });



        // thực hiện chức năng xóa dữ liệu của bảng Quanlysach
        button_Delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row =  table_Quanlysach.getSelectedRow();

                // nếu người dùng chưa choinj gì mà bâ xóa xem như 11 là chưa chọn
                if(row == -1){
                    // show thong bao la chua chon gi ma doi xoa
                    JOptionPane.showMessageDialog(Giaodien_Quanlysach.this, "vui long chon dong muon xoa","loi",JOptionPane.ERROR_MESSAGE);
                }else{
                    // nc lai thi show nhac nho la co muon chac an xoa khong???
                    int confirm = JOptionPane.showConfirmDialog(Giaodien_Quanlysach.this,"Ban co chac an muon xoa khong?");
                    // neu chon yes thi thuc thi xoa
                    if(confirm==JOptionPane.YES_NO_OPTION){
                        String maSach_Quanlysach = String.valueOf(table_Quanlysach.getValueAt(row,0));
                        service_controller.Delete_Quanlysach(maSach_Quanlysach);

                            // xoa xong thi refresh lai du lieu
                            defaultTableModel.setRowCount(0);
                            setData(service_controller.getAllusers());
                        }
                    }
                }
            });



        // thuc hien update sua du lieu
        button_Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table_Quanlysach.getSelectedRow();
                if(row==-1){
                    JOptionPane.showMessageDialog(Giaodien_Quanlysach.this,"vui long chon trc khi update","loi",JOptionPane.ERROR_MESSAGE);
                }else{
                    String maSach_Quanlysach = String.valueOf(table_Quanlysach.getValueAt(row,0));


                    // bam nut mo hop thoai edit con mo ra
                    new Giaodien_Edit(maSach_Quanlysach).setVisible(true);
                    dispose();
                }
            }
        });



        //end contructor
    }



    public void init(){
        this.setTitle("Quản lý sách chi tiết");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // chạy giữa màn hình
        this.setLocationRelativeTo(null);


         // tiến hành code thêm các cột cho JTable đã thiết kế bên kéo thả GUI java Swing
        defaultTableModel = new DefaultTableModel(){
            // khi chọn thì khóa chức năng click vào chỉnh dữa tt trên row của table
            @Override
            public boolean isCellEditable(int row, int column){
              return false;
            }
        };
        table_Quanlysach.setModel(defaultTableModel);
        defaultTableModel.addColumn("maSach");
        defaultTableModel.addColumn("tenSach");
        defaultTableModel.addColumn("loiSach");
        defaultTableModel.addColumn("nhaXuatban");
        defaultTableModel.addColumn("tacaGia");
        defaultTableModel.addColumn("soLuong");


        setData(service_controller.getAllusers());

    }




    //end class Giaodien_Quanlysach
}
