/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Commons.Common;
import Commons.TxtFileManager;
import chat.Client;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.DefaultListModel;

/**
 *
 * @author Administrator
 */
public class ClientsList extends javax.swing.JFrame {
    
    
    DefaultListModel model;
    
    private TxtFileManager txtFileManager;
    
    

    /**
     * Creates new form ClientsList
     */
    public ClientsList() {
        
        model = new DefaultListModel();
        
        this.txtFileManager = new TxtFileManager("Users.txt");
        
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JList<>();
        btnConnect = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        lbluserName = new javax.swing.JLabel();
        btnBack2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setText("Select The Client:");

        jScrollPane1.setViewportView(usersList);

        btnConnect.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnUsers.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnUsers.setText("Clients");
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });

        lbluserName.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N

        btnBack2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnBack2.setText("Back");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbluserName, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(btnUsers)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbluserName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUsers, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        /**
         * this button designed for show clients list
         */
        ArrayList<String> clients = this.txtFileManager.getListFromFile();
        
        //convert ArrayList to array
        String[] list = clients.toArray(new String[clients.size()]);
        
        String cli = null;
        
        for(int i = 0; i < list.length; i++) {
            
            cli = list[i];
            model.addElement(cli);
        }
        
        usersList.setModel(model);
    }//GEN-LAST:event_btnUsersActionPerformed
    
    
    
    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed

      //create an ArrayList from JList
        ArrayList<String> clients = (ArrayList<String>) usersList.getSelectedValuesList();
        
        ArrayList<String> clientUsernam = new ArrayList<>();
        
        /*
        get a single row from ArrayList clients, split it and set in an array
        and get 3th element(UserName)and add them in ArrayList clientUsernam
        */
        for( int i=0; i<clients.size(); i++) {
            
            String row = clients.get(i);
            String rowToArray[] = row.split(Common.SPLITTER);
            String userName = rowToArray[3];
            
            clientUsernam.add(userName);
            
        }
        
        //for every user got from jlist build a client window

        for (int i = 0; i < clientUsernam.size(); i++) {
            String user = clientUsernam.get(i);

            try {

                Socket socket = new Socket("localhost", 2089);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(user);
                
                new Client(user, socket).setVisible(true);
                this.dispose();
                

            } catch (IOException ex) {

            }
        }
        
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed

        MenuPage menuPage = new MenuPage();
        menuPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBack2ActionPerformed

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
            java.util.logging.Logger.getLogger(ClientsList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientsList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientsList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientsList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientsList().setVisible(true);
            }
        });
    }
    
    // get the user name from lable to pass it in next page
    public String saveUserName() {
        
        String un = this.lbluserName.getText();
        return un;
    }
    
    //get the userName client or clients that selected from list
    public ArrayList<String> targetUsers(){
        
        //create an ArrayList from JList
        ArrayList<String> clients = (ArrayList<String>) usersList.getSelectedValuesList();
        
        ArrayList<String> clientUsernam = new ArrayList<>();
        
        /*
        get a single row from ArrayList clients, split it and set in an array
        and get 3th element(UserName)and add them in ArrayList clientUsernam
        */
        for( int i=0; i<clients.size(); i++) {
            
            String row = clients.get(i);
            String rowToArray[] = row.split(Common.SPLITTER);
            String userName = rowToArray[3];
            
            clientUsernam.add(0, userName);
            
        }
        
        return clientUsernam;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lbluserName;
    private javax.swing.JList<String> usersList;
    // End of variables declaration//GEN-END:variables
}