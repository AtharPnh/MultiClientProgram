/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
/**
 *
 * @author Administrator
 */
public class Server extends javax.swing.JFrame {

    private ServerSocket serverSocket;
    private static Map<String, Socket> allUsersList = new ConcurrentHashMap<>(); // keeps the mapping of all the usernames used and their socket connections
    private static Set<String> activeUserSet = new HashSet<>(); // this set keeps track of all the active users

    public Server() {
        try {
            initComponents();
            this.serverSocket = new ServerSocket(2089);
            this.lblStatus.setText("Server Started.");

            new ClientAccept().start();

        } catch (IOException e) {
            //
        }

    }

    public class ClientAccept extends Thread {

        @Override
        public void run() {
            while (true) {
                try {

                    Socket socket = serverSocket.accept(); // create a socket for client
                    String input = new DataInputStream(socket.getInputStream()).readUTF();// this will receive the username sent from client register view
                    if (allUsersList.containsKey(input)) {
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());// create an output stream for client
                        out.writeUTF("You are already registered");

                    } else {
                        allUsersList.put(input, socket);
                        activeUsers.append(input + " Joined. \n");
                        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                        out.writeUTF("");

                        new MessageReader(socket, input).start();// create a thread to read messages
                        new PrepareClientsList().start();//create a thread to update all the active clients
                    }

                } catch (IOException ex) {
                    //
                }
            }
        }

    }

    public class MessageReader extends Thread {// this class reads the messages coming from client and take appropriate actions

        private Socket socket;
        private String username;

        public MessageReader(Socket socket, String username) {// socket and username will be provided by client
            this.socket = socket;
            this.username = username;
        }

        @Override
        public void run() {

            while (!allUsersList.isEmpty()) {// if allUserList is not empty then proceed further

                try {

                    String input = new DataInputStream(socket.getInputStream()).readUTF();// read message from client
                    System.out.println("message read ==> " + input); // just print the message for testing

                    if (input.equals("")) {
                        allUsersList.remove(username);
                        activeUsers.append(username + " : removed \n");
                        new PrepareClientsList().start();

                        Set key = allUsersList.keySet();
                        Iterator itr = key.iterator();
                        while (itr.hasNext()) {

                            String k = (String) itr.next();

                            if (!k.equals(username)) { // we don't need to send this message to ourself
                                try {

                                    new DataOutputStream(((Socket) allUsersList.get(k)).getOutputStream()).writeUTF("< " + username + " to all " + input);

                                } catch (IOException ex) {
                                    allUsersList.remove(k);
                                    activeUsers.append(k + ": removed");
                                }

                                new PrepareClientsList().start();
                            }

                        }
                    } else if (input.contains("")) {

                        input = input.substring(20);
                        //The java.util.StringTokenizer class allows you to break a String into tokens. It is simple way to break a String.
                        StringTokenizer str = new StringTokenizer(input, ":");
                        String id = str.nextToken();
                        input = str.nextToken();

                        try {
                            new DataOutputStream(((Socket) allUsersList.get(id)).getOutputStream()).writeUTF("< " + username + " to " + id + " > " + input);

                        } catch (IOException ex) {

                            allUsersList.remove(id);
                            activeUsers.append(id + ": removed");

                        }
                        new PrepareClientsList().start();
                    }

                } catch (IOException ex) {
                    //
                }
            }
        }

    }

    public class PrepareClientsList extends Thread {

        @Override
        public void run() {

            String ids = "";
            Set k = allUsersList.keySet();
            Iterator itr = k.iterator();
            while (itr.hasNext()) {
                String key = (String) itr.next();
                ids += key + ",";
            }

            if (ids.length() != 0) {
                ids = ids.substring(0, ids.length() - 1);

            }
            itr = k.iterator();

            while (itr.hasNext()) {
                String key = (String) itr.next();
                try {

                    new DataOutputStream(((Socket) allUsersList.get(key)).getOutputStream()).writeUTF(":;.,/" + ids);

                } catch (IOException ex) {
                    allUsersList.remove(key);
                    activeUsers.append(key + ": removed");
                }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        activeUsers = new javax.swing.JTextArea();
        lblStatus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        activeUsers.setColumns(20);
        activeUsers.setRows(5);
        jScrollPane1.setViewportView(activeUsers);

        lblStatus.setText("...............................................................");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Server Status: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea activeUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
