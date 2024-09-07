/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cps356_hw1;

import static java.lang.System.out;

/**
 *
 * @author gsven
 */
public class CPS356_Hw1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
    
public class Client{
    private int ID;
    private int port;
    private String Name;
    
    Client(){
        
    }

    Client(int id){
        
    }
    Client(int id, int p){
        
    }
    Client(int id, int p, String n){
        
    }
    public void getPort(){
        
    }
    public void setPort(){
        
    }
    public void getID(){
        
        
    }
    public void setID(){
        
    }
    public void getName(){
        
    }
    public void setName(){
        
    }
    public void PrintDate(){
        
    }
}
public class PrintClient extends Client{
    String Location;
    public void getLocation(){
        
    }
    
    public void setLocation(){
        
    }
    public void PrintDate(String Locat){
        if (Locat == null){
            PrintDate();
        }
        else {
            out.print(Location);
            out.print(" is not allowed to display printDate for clients");
        }
        
    }
}
    
}
