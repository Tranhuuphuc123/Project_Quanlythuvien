
package View;

import Controller.Service_Controller;
import javax.swing.JOptionPane;
import Model.Dangky_Acount;

public class Dangki_login extends javax.swing.JFrame {
   Dangky_Acount acount;
   Service_Controller service_Controller;
  
    public Dangki_login() {
        initComponents();
        this.setVisible(true);
        
        acount = new Dangky_Acount();
        service_Controller = new Service_Controller();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_dangkitk = new javax.swing.JLabel();
        label_dkUser = new javax.swing.JLabel();
        label_dkGmail = new javax.swing.JLabel();
        label_dkPass = new javax.swing.JLabel();
        label_dkPassConfirm = new javax.swing.JLabel();
        field_dkUser = new javax.swing.JTextField();
        field_dkGmail = new javax.swing.JTextField();
        button_dkLogin = new javax.swing.JButton();
        button_dkAdd = new javax.swing.JButton();
        field_dkPass = new javax.swing.JPasswordField();
        field_dkConfirmPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        label_dangkitk.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_dangkitk.setForeground(new java.awt.Color(0, 0, 255));
        label_dangkitk.setText("ĐĂNG KÍ TÀI KHOẢN CÁ NHÂN");

        label_dkUser.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_dkUser.setText("User");

        label_dkGmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_dkGmail.setText("Gmail");

        label_dkPass.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_dkPass.setText("Password");

        label_dkPassConfirm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_dkPassConfirm.setText("Confirm Password");

        button_dkLogin.setText("Login");
        button_dkLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_dkLoginActionPerformed(evt);
            }
        });

        button_dkAdd.setText("Đăng ký");
        button_dkAdd.setToolTipText("");
        button_dkAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_dkAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_dangkitk)
                            .addComponent(label_dkGmail)
                            .addComponent(label_dkPass)
                            .addComponent(label_dkPassConfirm)
                            .addComponent(label_dkUser)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(132, 132, 132)
                            .addComponent(button_dkLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                            .addComponent(button_dkAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(207, 207, 207)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(field_dkUser, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(field_dkGmail)
                                .addComponent(field_dkPass)
                                .addComponent(field_dkConfirmPass)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_dangkitk)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_dkUser)
                    .addComponent(field_dkUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_dkGmail)
                    .addComponent(field_dkGmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_dkPass)
                    .addComponent(field_dkPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_dkPassConfirm)
                    .addComponent(field_dkConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_dkAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_dkLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // chuc nang dang ky Acount 
    private void button_dkAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_dkAddActionPerformed
        // tiến hành quét điều kiện nếu chưa nhậ gì sẽ báo lõi
              if(field_dkUser.getText().isEmpty() 
                  || field_dkGmail.getText().isEmpty()
                  || field_dkPass.getText().isEmpty()    
                  || field_dkConfirmPass.getText().isEmpty() ){
             
             JOptionPane.showMessageDialog(this,"Không được để thông tin trống?");
         }else{
             
      // thiết lập nơi nhập đưa dl từ bàn phím vào các fiel tg ứng trên giao diện
               
               acount.setUser(field_dkUser.getText());
               acount.setGmail(field_dkGmail.getText());
               acount.setPassword(field_dkPass.getText());
               acount.setConfirmPass(field_dkConfirmPass.getText());

                service_Controller.Dangky_Acount(acount);
                JOptionPane.showMessageDialog(this,"Đăng ký thành công?");
                
                field_dkUser.setText("");
                field_dkGmail.setText("");
                field_dkPass.setText("");
                field_dkConfirmPass.setText("");
          }
    }//GEN-LAST:event_button_dkAddActionPerformed

    private void button_dkLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_dkLoginActionPerformed
        new Login().setVisible(true);
        dispose();
    }//GEN-LAST:event_button_dkLoginActionPerformed

    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_dkAdd;
    private javax.swing.JButton button_dkLogin;
    private javax.swing.JPasswordField field_dkConfirmPass;
    private javax.swing.JTextField field_dkGmail;
    private javax.swing.JPasswordField field_dkPass;
    private javax.swing.JTextField field_dkUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_dangkitk;
    private javax.swing.JLabel label_dkGmail;
    private javax.swing.JLabel label_dkPass;
    private javax.swing.JLabel label_dkPassConfirm;
    private javax.swing.JLabel label_dkUser;
    // End of variables declaration//GEN-END:variables
}
