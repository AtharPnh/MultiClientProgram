/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Identities;

import javax.swing.JPasswordField;

/**
 *
 * @author Administrator
 */
public class User {
    
    /*
    every client has information such as first name, last name, user role, user name and password
    */
    
    private String firstName;
    
    private String lastName;
    
    private String userRole;
      
    private String userName;
    
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String userRole, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userRole = userRole;
        this.userName = userName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    


    

    
    
}
