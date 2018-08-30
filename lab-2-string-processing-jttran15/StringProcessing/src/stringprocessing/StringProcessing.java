/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringprocessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author James Tran
 */
public class StringProcessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String [] records;
        records = new String [100];
        
        int currentIndex = 0;
        

        
        try { 
            Scanner reader = new Scanner(new File(args[0]));
            
            
            while(reader.hasNext()){
            
            String [] line = reader.nextLine().split(",");
            
            String firstName = line[0];
            String lastName = line[1];
            String gender = line[2];
            String age = line[3];
            String phoneNumber = line[4];
            String email = line[5];
            
            int intAge = Integer.parseInt(age);
            
            if(!Character.isUpperCase(firstName.charAt(0))){ //Validate First Name
                System.out.println(firstName+": Name not capitalize");
            } else if(!Character.isUpperCase(lastName.charAt(0))){ //Validate Last Nmae
                System.out.println(lastName+": Name not capitalize");
            /*} else if (gender =="male" || gender=="female"){
                System.out.println(firstName + " " + lastName + ": Gender is not correct");
            */} else if (intAge<0 || intAge>130){ // Validate Age
                System.out.println(firstName+" " + lastName + ": Age does not fall within 0 to 130");
            /*} else if (email) { //Validate Email
                System.out.println(firstName+" "+lastName+": Email is wrong");
            } else if (phoneNumber) { //Validate phone number
                System.out.println(firstName+" "+lastName+": Phone number is wrong");
            */} else { // Save into records Array
                records[currentIndex] = String.format("%-15s %-15s %-10s %-5s %-20s %-20s", firstName, lastName, gender, age, phoneNumber, email);
                currentIndex++;
            }
        } //While loop                
            
            //firstName = firstName.substring(0, 1).toUpperCase()+firstName.substring(1).toLowerCase();

            //lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
            
            // Valiadte Gender
            //if(gender!=gender.substring(0).toLowerCase()||gender!=gender.substring(0).toUpperCase()){
            //    System.out.println(firstName+" "+lastName+": Gender is not correct");
            //}
            //gender = gender.substring(1).toLowerCase();         
            
        } catch (FileNotFoundException ex) {
            System.err.print("Could not find input file");
        } //End try/catch block
        
        for(int i = 0; i<currentIndex; i++){
            System.out.println(records[i]);
        }//for loop
        
        
    } //main end
} //class end
