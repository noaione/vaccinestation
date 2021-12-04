/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package apu.oodj.vaccinestation.GUIForms.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import apu.oodj.vaccinestation.Internals.FileHandling;
import apu.oodj.vaccinestation.Internals.Managerial.VaccineRequest;
import apu.oodj.vaccinestation.Internals.Users.Citizen;

/**
 *
 * @author N4O
 */
public class UsersVaccineStatus extends javax.swing.JFrame {
    private Citizen user;
    private VaccineRequest firstDose;
    private VaccineRequest secondDose;
    private int currentPos;

    /**
     * Creates new form UsersVaccineStatus
     */
    public UsersVaccineStatus(Citizen user) {
        this.user = user;
        String[] vacRequests;
        try {
            vacRequests = FileHandling.ReadFile("vaccinerequest");
        } catch (FileNotFoundException ex) {
            new UsersStatusNotDoneVaccine(user).setVisible(true);
            this.setVisible(false);
            return;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to read vaccine request, please contact admin!");
            new HomepageUsers(user).setVisible(true);
            this.setVisible(false);
            return;
        }

        List<VaccineRequest> vaccineRequests = new ArrayList<VaccineRequest>();
        for (String data : vacRequests) {
            VaccineRequest r = VaccineRequest.ParseData(data);
            if (r.getUserId().equals(user.getId())) {
                vaccineRequests.add(r);
            }
        }

        if (vaccineRequests.size() == 0) {
            new UsersStatusNotDoneVaccine(user).setVisible(true);
            this.setVisible(false);
            return;
        }

        firstDose = null;
        secondDose = null;
        for (VaccineRequest r : vaccineRequests) {
            if (r.getDose() == 1) {
                firstDose = r;
            } else if (r.getDose() == 2) {
                secondDose = r;
            }
        }

        initComponents();
        this.moveToFirstDose();
    }

    private void moveToFirstDose() {
        currentPos = 1;
        btnNextDose.setEnabled(false);
        lblRequestTitle.setText("Requests");
        btnNextDose.setText("Dose 2");

        if (firstDose != null && !firstDose.isVaccinated()) {
            btnNextDose.setEnabled(false);
            switch (firstDose.getStatus()) {
                case 1:
                    lblRequestStat.setText("Approved");
                    break;
                case -1:
                    lblRequestStat.setText("Rejected");
                    break;
                default:
                    lblRequestStat.setText("Pending");
                    break;
            }
            lblFullName.setText(user.getName());
            lblIDNum.setText(user.getIdentificationNumber());
            lblVacDate.setText(firstDose.getVaccineDate().toString());
            lblVaccineName.setText(firstDose.getVaccine().getName());
            lblVaccineDose.setText("Dose 1");
        } else if (firstDose != null && firstDose.isVaccinated()) {
            if (secondDose != null) {
                btnNextDose.setEnabled(true);
            }
            lblRequestStat.setVisible(false);
            lblRequestTitle.setText("Done");
            lblFullName.setText(user.getName());
            lblIDNum.setText(user.getIdentificationNumber());
            lblVacDate.setText(firstDose.getVaccineDate().toString());
            lblVaccineName.setText(firstDose.getVaccine().getName());
            lblVaccineDose.setText("Dose 1");
        }
    }

    private void moveToSecondDose() {
        currentPos = 2;
        btnNextDose.setEnabled(true);
        btnNextDose.setText("Dose 1");

        lblFullName.setText(user.getName());
        lblIDNum.setText(user.getIdentificationNumber());
        lblVacDate.setText(secondDose.getVaccineDate().toString());
        lblVaccineName.setText(secondDose.getVaccine().getName());
        lblVaccineDose.setText("Dose 2");
        lblRequestTitle.setText("Done");
        lblRequestStat.setVisible(false);

        if (!secondDose.isVaccinated()) {
            lblRequestTitle.setText("Requests");
            lblRequestStat.setVisible(true);
            switch (secondDose.getStatus()) {
                case 1:
                    lblRequestStat.setText("Approved");
                    break;
                case -1:
                    lblRequestStat.setText("Rejected");
                    break;
                default:
                    lblRequestStat.setText("Pending");
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGoBack = new javax.swing.JButton();
        lblMainTop = new javax.swing.JLabel();
        panelDose = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblVaccineDose = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        lblIDNum = new javax.swing.JLabel();
        lblVacDate = new javax.swing.JLabel();
        lblVaccineName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblRequestTitle = new javax.swing.JLabel();
        lblRequestStat = new javax.swing.JLabel();
        btnNextDose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGoBack.setText("Go Back");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        lblMainTop.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblMainTop.setText("Vaccination Status");

        jLabel9.setText("ID Number");

        jLabel6.setText("Vaccine Name");

        lblVaccineDose.setText("l");

        jLabel8.setText("Full Name");

        jLabel5.setText("Vaccine Dose");

        lblFullName.setText("l");

        lblIDNum.setText("l");

        lblVacDate.setText("l");

        lblVaccineName.setText("l");

        jLabel4.setText("Vaccination Date");

        lblRequestTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRequestTitle.setText("Requests");

        lblRequestStat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRequestStat.setText("Pending");

        javax.swing.GroupLayout panelDoseLayout = new javax.swing.GroupLayout(panelDose);
        panelDose.setLayout(panelDoseLayout);
        panelDoseLayout.setHorizontalGroup(
            panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDoseLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDoseLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRequestTitle)
                            .addComponent(lblRequestStat)))
                    .addGroup(panelDoseLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblIDNum, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDoseLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblVacDate, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDoseLayout.createSequentialGroup()
                        .addGroup(panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineDose, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panelDoseLayout.setVerticalGroup(
            panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDoseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDoseLayout.createSequentialGroup()
                        .addComponent(lblRequestTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRequestStat, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDoseLayout.createSequentialGroup()
                        .addGroup(panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIDNum, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVacDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDoseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaccineDose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnNextDose.setText("Dose 2");
        btnNextDose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextDoseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMainTop)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGoBack)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNextDose))
                        .addComponent(panelDose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblMainTop)
                .addGap(18, 18, 18)
                .addComponent(panelDose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(btnNextDose))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        new HomepageUsers(this.user).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnNextDoseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextDoseActionPerformed
        if (currentPos == 1) {
            this.moveToSecondDose();
        } else if (currentPos == 2) {
            this.moveToFirstDose();
        }
    }//GEN-LAST:event_btnNextDoseActionPerformed

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
            java.util.logging.Logger.getLogger(UsersVaccineStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsersVaccineStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsersVaccineStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersVaccineStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsersVaccineStatus(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnNextDose;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblIDNum;
    private javax.swing.JLabel lblMainTop;
    private javax.swing.JLabel lblRequestStat;
    private javax.swing.JLabel lblRequestTitle;
    private javax.swing.JLabel lblVacDate;
    private javax.swing.JLabel lblVaccineDose;
    private javax.swing.JLabel lblVaccineName;
    private javax.swing.JPanel panelDose;
    // End of variables declaration//GEN-END:variables
}
