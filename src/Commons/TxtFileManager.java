/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Commons;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class TxtFileManager {
    
     private File file;
    
    /**
     * CRUD ----> Create, Read, Update, Delete
     */
    
    /**
     * first Operation ----> CREATE a File
     * @param fileName
     */
    
    public TxtFileManager(String fileName) {
        
         this.file = new File(fileName);
        
            if (!this.file.exists()) {
 
            try {
                // Create a new file if not exists.
                this.file.createNewFile();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            }
    }
    
    /**
     * write data in file
     * set it private to use in this class
     * @param row
     */
    
    private void writeToFile(String row){
        
        try {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.file, true));
            writer.append(row);
            writer.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
             System.out.println(ex.getMessage());
        }
        
    }
    
    /**
     * Read a File and retrieve data
     */
    
    private String readData() {
        
        String save="";
        
        try {
            
            Scanner reader = new Scanner(this.file);
            while(reader.hasNextLine()) {
                
                if(save==""){
                    save = reader.nextLine();
                }else{
                    save = save + "\n" + reader.nextLine();
                }
            }
            
            reader.close();
                } catch (FileNotFoundException ex) {
             System.out.println(ex.getMessage());
        }
        
        return save;
    }
    
    /**
     * Update a file 
     */
    //--------------------------------------- updateRow() -----> get a list of objects from a file and update it
    public void updateRow(int index, String newRow) {
        
        ArrayList<String> list =this.getListFromFile();
        
        this.clear();
        
        list.set(index, newRow);
        
         //write the arraylist in file by BufferedWriter
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(this.file, true));
            
            for (String lines : list){
                
            writer.append(lines + "\n");
                             
            }
            
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(TxtFileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    //--------------------------------------- getListFromFile() -----> get a list of objects from a file
    public ArrayList<String> getListFromFile(){

        ArrayList<String> list=new ArrayList<String>();

        try(Scanner scanner=new Scanner(new FileReader(this.file))){

            while(scanner.hasNextLine()){
                list.add(scanner.nextLine());
            }
            
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
    
    //--------------------------------------- appendRow() -----> append a new row to end of a file
    public void appendRow(String row) {
        
        String lines = this.readData(); // first read data from file
        
        this.clear();
        
        if(lines.equals("")) { // chek if file is null
            lines = row;
        } else {
            lines=lines + "\n" + row; //append the row to end of file
        }
        
        this.writeToFile(lines); // write the data to file
    }
    
    //---------------------------------------clear() -----> clear content of the file
    public void clear(){
        if(!this.file.exists()){
            System.out.println("This file doesn't exist.");
        }else{

            PrintWriter out= null;
            try {

                out = new PrintWriter(this.file);
                out.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
    
    //--------------------------------------- deleteRow() -----> delete a specified row from a file
    
     public void deleteRow(int index){

        if(index<=0){
            return;
        }
        
        //save all content of file in an array list by getListFromFile() method
        ArrayList<String> list=this.getListFromFile();
     
        //delete the row by its index from arraylist
        list.remove(index);
        
        //clear all file to save new rows
        this.clear();
        
        //write the rest of arraylist in file by BufferedWriter
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(this.file, true));
            
            for (String lines : list){
                
            writer.append(lines + "\n");
                             
            }
            
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(TxtFileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
