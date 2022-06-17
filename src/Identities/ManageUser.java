/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Identities;

import Commons.Common;
import Commons.TxtFileManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ManageUser {
    
    private TxtFileManager txtFileManager;

    public ManageUser() {
        
         /**
         * In this constructor we create a users file with TxtFileManager class to store data.
         */
        
        this.txtFileManager=new TxtFileManager("Users.txt");
    }
    
    public void insert(User user) {
        String row = user.getFirstName() + Common.SPLITTER + user.getLastName() + Common.SPLITTER +
                     user.getUserRole() + Common.SPLITTER + user.getUserName() + Common.SPLITTER +
                     user.getPassword();
        
        this.txtFileManager.appendRow(row);
    }
    
    /**
     * --------------------------------- stringToUser() -----> get a row in users file as a string
     * and convert it to a user
     */
    
    private User stringToUser(String row){
        
        User user = new User();
        
        /**
         * in below function we split username and password by splitter and store them in an ArrayList
         */
        
       // ArrayList<String> save = new ArrayList<>(Arrays.asList(row.split(Commons.SPLITTER)));       
        
        String str[] = row.split("~~~");
	List<String> save = new ArrayList<String>();
	save = Arrays.asList(str);
	
	user.setFirstName(save.get(0));       
        user.setLastName(save.get(1));
        user.setUserRole(save.get(2));
        user.setUserName(save.get(3));
        user.setPassword(save.get(4));
        
        return user;
    }
    
    /**
     * with this method we return all of users from users file in an ArrayList<User>
     * @return 
     */
    
    public ArrayList<User> ListOfUsers() {
        
        ArrayList<User> users = new ArrayList<>();
        //first we save all of users in users file in an ArrayList<String>
        ArrayList<String> save = this.txtFileManager.getListFromFile();
        
        /** in this function we set an object from User class that we get by stringToUser()
        * method from save list in i index in list ArrayList
        */
        
        for(int i=0; i<save.size(); i++) {
            users.add(stringToUser(save.get(i)));
        }
        
        return users;
    }
    
    public void updateUser(int index, String newRow) {
        
        this.txtFileManager.updateRow(index, newRow);
    }
 
}
