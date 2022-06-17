/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import chat.Client;

/**
 *
 * @author Administrator
 */
public class MenuPage extends javax.swing.JFrame {

    /**
     * Creates new form MenuPage
     */
    public MenuPage() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        btnshowSends = new javax.swing.JButton();
        btnSendMeesage = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnShowRecived = new javax.swing.JButton();
        lblUserName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(102, 0, 51));
        lblName.setText("Menu Page");
        lblName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnshowSends.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnshowSends.setText("Show sent Messages");
        btnshowSends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowSendsActionPerformed(evt);
            }
        });

        btnSendMeesage.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSendMeesage.setText("Send Message");
        btnSendMeesage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendMeesageActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEdit.setText("Edit Profile");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnShowRecived.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnShowRecived.setText("Show Recived Messages");
        btnShowRecived.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowRecivedActionPerformed(evt);
            }
        });

        lblUserName.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(326, 326, 326))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblName)
                                .addGap(58, 58, 58)
                                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSendMeesage, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnshowSends, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnShowRecived, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnSendMeesage)
                .addGap(24, 24, 24)
                .addComponent(btnshowSends)
                .addGap(18, 18, 18)
                .addComponent(btnShowRecived)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnshowSendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowSendsActionPerformed

    }//GEN-LAST:event_btnshowSendsActionPerformed

    private void btnSendMeesageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendMeesageActionPerformed
        
        ClientsList clientList = new ClientsList();
        
        clientList.lbluserName.setText(this.saveUserName());
        clientList.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSendMeesageActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
        EditPage editPage = new EditPage();
        editPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        
        this.setVisible(false);
        dispose();
        
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnShowRecivedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowRecivedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnShowRecivedActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPage().setVisible(true);
            }
        });
        
        
    }
    
    // get the user name from lable to pass it in next page
    public String saveUserName() {
        
        String un = this.lblUserName.getText();
        return un;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSendMeesage;
    private javax.swing.JButton btnShowRecived;
    private javax.swing.JButton btnshowSends;
    private javax.swing.JLabel lblName;
    public javax.swing.JLabel lblUserName;
    // End of variables declaration//GEN-END:variables
}