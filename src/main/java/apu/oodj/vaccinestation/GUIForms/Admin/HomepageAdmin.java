/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apu.oodj.vaccinestation.GUIForms.Admin;

import java.awt.Color;

import apu.oodj.vaccinestation.GUIForms.Auth.LoginPage;
import apu.oodj.vaccinestation.Internals.Users.Administrator;

/**
 *
 * @author asus
 */
public class HomepageAdmin extends javax.swing.JFrame {
    private Administrator user;

    /**
     * Creates new form AdminForm
     */
    public HomepageAdmin() {
        initComponents();
        btnVaccineSlots.setBackground(Color.GRAY);
        btnRegisterManagerAcc.setBackground(Color.GREEN);
        btnModifyManagerAcc.setBackground(Color.CYAN);
        btnLogOut.setBackground(Color.RED);
    }

    public HomepageAdmin(Administrator user) {
        initComponents();
        this.user = user;
        btnVaccineSlots.setBackground(Color.GRAY);
        btnRegisterManagerAcc.setBackground(Color.GREEN);
        btnModifyManagerAcc.setBackground(Color.CYAN);
        btnLogOut.setBackground(Color.RED);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegisterManagerAcc = new javax.swing.JButton();
        btnModifyManagerAcc = new javax.swing.JButton();
        btnVaccineSlots = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel1.setText("HI ! ADMIN ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("WHAT DO YOU WANT TO DO TODAY ?? ");

        btnRegisterManagerAcc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegisterManagerAcc.setText("REGISTER NEW STATION");
        btnRegisterManagerAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterManagerAccActionPerformed(evt);
            }
        });

        btnModifyManagerAcc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModifyManagerAcc.setText("MODIFY MANAGER ACCOUNT");
        btnModifyManagerAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyManagerAccActionPerformed(evt);
            }
        });

        btnVaccineSlots.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVaccineSlots.setText("ADD/REMOVE VACCINE");
        btnVaccineSlots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineSlotsActionPerformed(evt);
            }
        });

        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogOut.setText("LOG OUT");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(btnVaccineSlots))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btnRegisterManagerAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(btnModifyManagerAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVaccineSlots, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegisterManagerAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModifyManagerAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVaccineSlotsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineSlotsActionPerformed
        new AdminAddRemoveVaccine(this.user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVaccineSlotsActionPerformed

    private void btnRegisterManagerAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterManagerAccActionPerformed
        new AdminCreateStation(this.user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegisterManagerAccActionPerformed

    private void btnModifyManagerAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyManagerAccActionPerformed
        // TODO add your handling code here:
        new AdminCheckUsernameModifyManagerAccount(this.user).show();
        this.hide();
    }//GEN-LAST:event_btnModifyManagerAccActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        new LoginPage("", "").show();
        this.hide();
    }//GEN-LAST:event_btnLogOutActionPerformed

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
            java.util.logging.Logger.getLogger(HomepageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomepageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomepageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomepageAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomepageAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnModifyManagerAcc;
    private javax.swing.JButton btnRegisterManagerAcc;
    private javax.swing.JButton btnVaccineSlots;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}