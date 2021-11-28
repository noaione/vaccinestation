/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.oodj.vaccinestation;

import java.awt.Color;
import javax.swing.JOptionPane;

import apu.oodj.vaccinestation.Internals.Managerial.Station;
import apu.oodj.vaccinestation.Internals.Users.Administrator;
import apu.oodj.vaccinestation.Internals.Users.Manager;

/**
 *
 * @author asus
 */
public class AdminRegisterManagerAccount extends javax.swing.JFrame {
    private Station station;
    private Administrator admin;

    /**
     * Creates new form AdminRegisterManagerAccount
     */
    public AdminRegisterManagerAccount(Administrator admin, Station station) {
        initComponents();
        this.station = station;

        lblStationName.setText(station.getName());
        lblStationLocation.setText(station.getAddress());
    }

    public AdminRegisterManagerAccount(Administrator admin,Station station, Manager manager) {
        initComponents();
        this.station = station;

        lblStationName.setText(station.getName());
        lblStationLocation.setText(station.getAddress());

        txtFullName.setText(manager.getName() + "");
        txtEmail.setText(manager.getEmail() + "");
        txtPhone.setText(manager.getPhoneNumber() + "");
        txtUsername.setText(manager.getUsername() + "");
        txtPassword.setText(manager.getPassword() + "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCitizenNon = new javax.swing.ButtonGroup();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtConPassword = new javax.swing.JPasswordField();
        lblCheckUsername = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnShow = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblCheckPassword = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblStationName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblStationLocation = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtUsernameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsernameKeyTyped(evt);
            }
        });

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Register a new manager account!");

        jLabel6.setText("Username");

        lblCheckUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lblCheckUsernameKeyPressed(evt);
            }
        });

        jLabel7.setText("Email Address");

        jLabel13.setText("Full Name");

        btnRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        jLabel8.setText("Password");

        jLabel9.setText("Confirm Password");

        btnShow.setText("jButton1");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        jLabel3.setText("Phone Number");

        txtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhoneKeyTyped(evt);
            }
        });

        lblCheckPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lblCheckPasswordKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Station Info");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Name: ");

        lblStationName.setText("---");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Location:");

        lblStationLocation.setText("---");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStationName, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                        .addGap(155, 155, 155))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtConPassword)
                                    .addComponent(txtPassword)
                                    .addComponent(txtUsername)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCheckPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCheckUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStationLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblStationName))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblStationLocation))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCheckUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnShow)
                        .addComponent(lblCheckPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtConPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameKeyPressed

    private void txtUsernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyTyped
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtUsernameKeyTyped

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        String name = txtFullName.getText();
        String email = txtEmail.getText();
        String phoneNumber = txtPhone.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String confirmpassword = txtConPassword.getText();

        Manager manager = new Manager(
            username,
            name,
            email,
            password,
            phoneNumber
        );

        if(name.isEmpty()){
            JOptionPane.showMessageDialog(this, "EMPTY BOX DETECTED\nPLEASE FILL YOUR >>NAME<< HERE!!");
            txtFullName.requestFocusInWindow();
        }else if(email.isEmpty()){
            JOptionPane.showMessageDialog(this, "EMPTY BOX DETECTED\nPLEASE FILL YOUR >>EMAIL<< HERE!!");
            txtEmail.requestFocusInWindow();
        }else if(phoneNumber.isEmpty()){
            JOptionPane.showMessageDialog(this, "EMPTY BOX DETECTED\nPLEASE FILL YOUR >>PHONE<< HERE!!");
            txtPhone.requestFocusInWindow();
        }else if(username.isEmpty()){
            JOptionPane.showMessageDialog(this, "EMPTY BOX DETECTED\nPLEASE FILL YOUR >>USERNAME<< HERE!!");
            txtUsername.requestFocusInWindow();
        }else if(txtUsername.getText().length() <= 5){
            JOptionPane.showMessageDialog(this, "MINIMUM '6' LENGTH OF ALPHABETS FOR USERNAME !!");
            txtUsername.requestFocusInWindow();
        }else if(password.isEmpty()){
            JOptionPane.showMessageDialog(this, "EMPTY BOX DETECTED\nPLEASE FILL YOUR >>PASSWORD<< HERE!!");
            txtPassword.requestFocusInWindow();
        }else if(confirmpassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "EMPTY BOX DETECTED\nPLEASE FILL YOUR >>CONFIRM PASSWORD<< HERE!!");
            txtConPassword.requestFocusInWindow();
        }else if(password.equals(confirmpassword)) {
            new AdminConfirmationRegisterManager(this.admin, manager, this.station).setVisible(true);
            this.setVisible(false);
        }else {
            JOptionPane.showMessageDialog(this, "DIFFERENT PASSWORD DETEDTED!! \n\nKindly Check Your Password and Confirm Password");
        }

    }//GEN-LAST:event_btnRegisterActionPerformed
    boolean showPassword = false;
    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        if (showPassword == false) {
            txtPassword.setEchoChar((char)0);
        }
        else {
            txtPassword.setEchoChar('*');
        }
        showPassword = !showPassword;
    }//GEN-LAST:event_btnShowActionPerformed

    private void txtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtPhoneKeyPressed

    private void txtPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhoneKeyTyped
        // TODO add your handling code here:
        char press = evt.getKeyChar();
        if(!(Character.isDigit(press))){
            JOptionPane.showMessageDialog(this, "PHONE NUMBER SHOULD BE NUMERIC (0-9) !!");
            evt.consume();
        }
    }//GEN-LAST:event_txtPhoneKeyTyped

    private void lblCheckPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblCheckPasswordKeyTyped
        // TODO add your handling code here:        
    }//GEN-LAST:event_lblCheckPasswordKeyTyped

    private void lblCheckUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblCheckUsernameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCheckUsernameKeyPressed

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        // TODO add your handling code here:  
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtUsernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyReleased
        if(txtUsername.getText().length() >= 6 && txtUsername.getText().length() < 16){
            lblCheckUsername.setText("NOW IT'S FINE");
            lblCheckUsername.setForeground(Color.BLUE);
        }
        else{
            lblCheckUsername.setText("'6' LETTERS REQUIRED");
            lblCheckUsername.setForeground(Color.RED);
        }
        if(txtUsername.getText().length() >= 16){
            JOptionPane.showMessageDialog(this, "MAXIMUM '15' LENGTH OF ALPHABETS FOR USERNAME !!");
            txtUsername.setText(txtUsername.getText().substring(0,15));
        }
    }//GEN-LAST:event_txtUsernameKeyReleased

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        if(txtPassword.getText().length() >= 12 && txtPassword.getText().length() <= 21){
            lblCheckPassword.setText("VERY STRONG !!");
            lblCheckPassword.setForeground(Color.BLUE);
        }else if(txtPassword.getText().length() >= 6 && txtPassword.getText().length() < 12){
            lblCheckPassword.setText("STRONG !!");
            lblCheckPassword.setForeground(Color.GREEN);
        }
        else{
            lblCheckPassword.setText("WEAK !! '6' LETTERS REQUIRED");
            lblCheckPassword.setForeground(Color.RED);
        }
        if(txtPassword.getText().length() == 21){
            JOptionPane.showMessageDialog(this, "MAXIMUM '20' LENGTH OF ALPHABETS FOR USERNAME !!");
            txtPassword.setText(txtPassword.getText().substring(0,20));
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel station registration?");
        if (confirm == JOptionPane.YES_OPTION) {
            new HomepageAdmin(this.admin).setVisible(true);
            this.setVisible(false);
            return;
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminRegisterManagerAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminRegisterManagerAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminRegisterManagerAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminRegisterManagerAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminRegisterManagerAccount(null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.ButtonGroup btnCitizenNon;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblCheckPassword;
    private javax.swing.JLabel lblCheckUsername;
    private javax.swing.JLabel lblStationLocation;
    private javax.swing.JLabel lblStationName;
    private javax.swing.JPasswordField txtConPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
