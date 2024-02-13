package login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fagr
 */
public class Database {
      
    public static Connection connect(){
     try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect =DriverManager.getConnection("jdbc:mysql://localhost/javafxcurd","root","");
            return connect;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
       
    
}


