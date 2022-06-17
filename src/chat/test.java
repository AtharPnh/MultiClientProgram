/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat;

import Commons.Common;
import Commons.TxtFileManager;
import GUI.FirstPage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class test {

    public static void main(String args[]) {
        
        
        TxtFileManager txtFileManager = new TxtFileManager("Users.txt");
         
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirstPage().setVisible(true);
            }
        });
        
//        ArrayList<String> clients = txtFileManager.getListFromFile();
//        
//        ArrayList<String> clientUsernam = new ArrayList<>();
//        
//
//        /*
//        get a single row from ArrayList clients, split it and set in an array
//        and get 3th element(UserName)and add them in ArrayList clientUsernam
//         */
//        for (int i = 0; i < clients.size(); i++) {
//
//            String row = clients.get(i);
//            String rowToArray[] = row.split(Common.SPLITTER);
//            String userName = rowToArray[3];
//
//            clientUsernam.add(userName);
//            
//            //System.out.print(clientUsernam.get(i) + ", ");
//            
//        }
//        
//        for (int i = 0; i < clients.size(); i++){
//            String user = clientUsernam.get(i);
//            System.out.println(user);
//
//            try {
//
//                Socket socket = new Socket("localhost", 2089);
//                DataInputStream input = new DataInputStream(socket.getInputStream());
//                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//                out.writeUTF(user);
//                
//                Client client = new Client(user, socket);
//                client.setVisible(true);
//                client.dispose();
//                
//
//            } catch (IOException ex) {
//
//            }
//        
//        }
        
        
    }

}
