/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringprocessing;

import java.io.File;
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
            
            //Convert String to Int
            int intAge = Integer.parseInt(age);
            
            //Remove () and - from phone number
            String phone = phoneNumber.replaceAll("[^0-9\\+]", "");
            //create first and last name array
            char [] first = new char [100];
            char [] last = new char [100];

            boolean save=true;
            
            //Store each letter in an array
            for(int i=0;i<firstName.length();i++){
                first[i]=firstName.charAt(i);
            }
            for(int i=0;i<lastName.length();i++){
                last[i]=lastName.charAt(i);
            }
            
            // Validate first name
            for(int i=0;i<first.length;i++){
                if(Character.isDigit(first[i])){
                    System.err.println(firstName+": First name is incorrect");
                    save=false;
                    break;
                }
            }     
            // Validate last name
            for(int i=0;i<last.length;i++){
                if(Character.isDigit(last[i])){
                    System.err.println(lastName+": Last name is incorrect");
                    save=false;
                    break; 
                }
            }
            // Validate gender
            if( gender.toLowerCase().contains("male") || gender.toLowerCase().contains("female")){
            } else {
                System.err.println(firstName+" "+lastName+": Gender is wrong");
                save=false;
            }
            
            //Validate Email
            if(Character.isLetter(email.charAt(0))){
                    if(!email.contains("@")){
                        System.err.println(firstName+" "+lastName+": Email is incorrect");
                        save=false;
                    }
                    if(!email.contains(".")){
                        System.err.println(firstName+" "+lastName+": Email is incorrect");
                        save=false;
                    }
            } else {
                System.err.println(firstName+" "+lastName+": Email is incorrect");
                save=false;
            }
            
            // Validate Age
            if (intAge<0 || intAge>130){ // Validate Age
                System.err.println(firstName+" " + lastName + ": Age does not fall within 0 to 130");
                save=false;
            } else if (phone.length()!=10) { //Validate phone number
                System.err.println(firstName+" "+lastName+": Phone number is wrong");
                save=false;
            }
            
            // Save into records array
            if(save==true){
                records[currentIndex] = String.format("%-15s %-15s %-10s %-5s %-20s %-20s", firstName, lastName, gender, age, phoneNumber, email);
                currentIndex++;
            }
        } //While loop                                  
           
        }catch (Exception ex) {
            System.err.println("Exception Found: "+ex.getMessage());
        } //End try/catch block
        
        for(int i = 0; i<currentIndex; i++){
            System.out.println(records[i]);
        }//for loop
        
        
    } //main end
} //class end
