
package View;

import javax.swing.JOptionPane;
import Model.Dangky_Acount;
import Controller.Service_Controller;
import Data.JDBCutil;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends javax.swing.JFrame {
   Dangky_Acount acount;
    Service_Controller service_Controller;
  
    
    
    //contructor
    public Login() {
        initComponents();
        this.setVisible(true);
        
        acount = new Dangky_Acount();
        service_Controller = new Service_Controller();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_name_login = new javax.swing.JLabel();
        label_login = new javax.swing.JLabel();
        label_login2 = new javax.swing.JLabel();
        field_user = new javax.swing.JTextField();
        button_Them = new javax.swing.JButton();
        button_login = new javax.swing.JButton();
        field_Pass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        label_name_login.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_name_login.setForeground(new java.awt.Color(0, 0, 204));
        label_name_login.setText("ĐĂNG NHẬP HỆ THỐNG");

        label_login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_login.setForeground(new java.awt.Color(0, 153, 204));
        label_login.setText("User");

        label_login2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_login2.setForeground(new java.awt.Color(0, 153, 204));
        label_login2.setText("Password");

        button_Them.setText("Thêm Account");
        button_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ThemActionPerformed(evt);
            }
        });

        button_login.setText("Đăng Nhập");
        button_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(label_name_login)
                .addGap(52, 52, 52))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_login)
                            .addComponent(label_login2))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_user, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(field_Pass)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_Them)
                        .addGap(28, 28, 28)
                        .addComponent(button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(label_name_login)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_login)
                    .addComponent(field_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_login2)
                    .addComponent(field_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_login, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // xu li button lk voi de mo jframe Dangki_Acount
    private void button_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ThemActionPerformed
        new Dangki_login().setVisible(true);
        dispose();
    }//GEN-LAST:event_button_ThemActionPerformed

    
    // xử lý sự kiện đăng nhập
    private void button_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_loginActionPerformed
//       if(field_user.getText().isEmpty()){
//             JOptionPane.showMessageDialog(this,"Không được để trống Tên Đăng Nhập?");
//         }else if(field_Pass.getText().isEmpty()){
//             JOptionPane.showMessageDialog(this,"Không được để trống Mật khẩu");
//         }else{
//             acount.setUser(field_user.getText());
//             acount.setPassword(field_Pass.getText());
//             
//             // tiến hành mở giao diện chính
//             new Giaodien_Main().setVisible(true);
//             dispose();
//             
//             // tiến hành thoogn báo
//              JOptionPane.showMessageDialog(this,"Đăng nhập thành công ");
//         }



        Connection connection = JDBCutil.ketnoi_JDBC();
        try {
            String sql = "select * from Login where User = ? and Password =?";
            PreparedStatement preparedStatement = connection.prepareCall(sql);
             preparedStatement.setString(1,field_user.getText());
             preparedStatement.setString(2, field_Pass.getText());
                
                ResultSet rs =  preparedStatement.executeQuery();
                 if(field_user.getText().isEmpty()){
                     JOptionPane.showMessageDialog(this,"Không được để trống Tên Đăng Nhập");     
                 }
                 else if(field_Pass.getText().isEmpty()){
                     JOptionPane.showMessageDialog(this,"Không được để Mật Khẩu trống");     
                 }else if(rs.next()){
                      new Giaodien_Main().setVisible(true);
                      dispose();
                       JOptionPane.showMessageDialog(this,"Đăng nhập thành công ");
                 }else{
                     JOptionPane.showMessageDialog(this,"Đăng Nhập thât bại vui lòng thử lại");
                 }
                
            
           } catch (Exception e) {
        }
            
    }//GEN-LAST:event_button_loginActionPerformed

    
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Them;
    private javax.swing.JButton button_login;
    private javax.swing.JPasswordField field_Pass;
    private javax.swing.JTextField field_user;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_login;
    private javax.swing.JLabel label_login2;
    private javax.swing.JLabel label_name_login;
    // End of variables declaration//GEN-END:variables
}
