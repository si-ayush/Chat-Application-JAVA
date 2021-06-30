package javaapplication2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author dell
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBconfig {
    
    private static Connection conn = null;
    private static Statement stmt = null;
    
    private static void openConnection(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatdb","root","surajsura8");
            stmt = conn.createStatement();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static boolean executeUpdate(String sql){
        try{
            
            openConnection();
            int x = stmt.executeUpdate(sql);
            if(x>0){
                return true;
               }
            else{
                return false;
            }
            
        }
        
        catch(Exception ex){
            ex.printStackTrace();
            return false;
        
        }
    }
    public static ResultSet executeQuery(String sql){
        try{
            
            openConnection();
           ResultSet rs= stmt.executeQuery(sql);
            return rs;
            
            }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
           }
        
        }
    public static void closeAll(){
        try{
            
           conn.close();
           stmt.close();
            
        }
        
        catch(Exception ex){
            ex.printStackTrace();
            
        }
    }
    }