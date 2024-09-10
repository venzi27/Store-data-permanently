
package javaapplication3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.w3c.dom.UserDataHandler;

public class JavaApplication3 {
     static File file = new File("C:\\Users\\ITOPS\\Downloads\\Userdata.txt");
      static FileReader fileread;
      static   BufferedReader reader;
     
    public static void savedata(String username, String password) throws FileNotFoundException, IOException{
        
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter reader = new BufferedWriter(fr);
        
        reader.write(username + "," + password );
        reader.newLine();
        reader.close();
       
       

 }
       
    public static boolean existence(String username) throws FileNotFoundException, IOException{
        
        
       fileread = new FileReader(file);
       reader = new BufferedReader(fileread);
       String line;
       
       while ((line = reader.readLine()) != null){
       String[] split = line.split(",");
       
       if (split[0].equals(username)){
          
           return true;
       }
       }
       return false;
        
        
        
    
    
    } public static boolean login(String username, String password) throws FileNotFoundException, IOException{
        fileread = new FileReader(file);
        reader = new BufferedReader(fileread);
        String data;
        
        while ((data = reader.readLine()) != null){
            String [] cred = data.split(",");
            
            if (cred[0].equals(username) && cred[1].equals(password)){
                return true;
                
            
        }
      
        
        
    }
      return false;

    /**
     *
     * @param args
     */

    /**
     *
     * @param args
     * @throws java.io.IOException
     */
    } public static boolean isValidLength(String str) {
        try {
           str.charAt(10);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
         }
    
    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("1.CREATE ");
        System.out.println("2.LOGIN");
        
        System.out.print("Select: ");
        int select = scan.nextInt();
        
        switch (select){
            
            case 1:
                System.out.print("Enter your name: ");
                String name = scan.next();
                System.out.println("Enter your password: ");
                String pass = scan.next();
                String line;
                
               if (existence(name)){
                 System.out.println("Username is already used");
                 
               } if (isValidLength(name) && isValidLength(pass)){
                   savedata(name, pass);
                   System.out.println("Your data is stored");
               }else{
                   System.out.println("The character should be 10 above");
               }
                 
             break;
                
    
            case 2:
                System.out.print("Name: ");
                String namelog = scan.next();
                System.out.println("Password: ");
                String passlog = scan.next();
                
                if (login(namelog, passlog)){
                    System.out.println("Success");
                }
                else{
                    System.out.println("Invalid username or password");
                }
                break;
                
            
            
        }
        
           
     
    }
    
    
}
