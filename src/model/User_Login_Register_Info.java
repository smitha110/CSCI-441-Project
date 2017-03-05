package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User_Login_Register_Info {
	
	public static boolean checkUserNameAndPassword(String username, String password)
	{
        Connection con = Database_Connect.Connect2LocalDB();
        boolean inDB = false;
        
        try {
        	PreparedStatement ps = con.prepareStatement("SELECT username, password from account WHERE username = ? AND password = ?");
        	ps.setString(1, username);
        	ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString("username").equals(username) && rs.getString("password").equals(password)){
            	inDB = true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(User_Login_Register_Info.class.getName()).log(Level.SEVERE, User_Login_Register_Info.class.getName() +   "; " + ex.getMessage(), ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(User_Login_Register_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return inDB;
	}
	
	public static boolean isUserNameInDB(String username)
	{
        Connection con = Database_Connect.Connect2LocalDB();
        boolean inDB = false;
        
        try {
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(username) as nameCount FROM account WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getInt("nameCount") > 0){
            	inDB = true;
            } 
 
        } catch (SQLException ex) {
            Logger.getLogger(User_Login_Register_Info.class.getName()).log(Level.SEVERE, User_Login_Register_Info.class.getName() +   "; " + ex.getMessage(), ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(User_Login_Register_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return inDB;
	}
	
	public static Integer getUserPrimaryKey(String username)
	{
		Connection con = Database_Connect.Connect2LocalDB();
		int userKey = 0;
		
        try {
        	PreparedStatement key = con.prepareStatement("SELECT primarykey FROM account WHERE username = ?");
            key.setString(1, username);
            ResultSet resultUserKey = key.executeQuery();
            resultUserKey.next();
            userKey = resultUserKey.getInt(1);
            System.out.println(resultUserKey.getInt(1));
        } catch (SQLException ex) {
            Logger.getLogger(User_Login_Register_Info.class.getName()).log(Level.SEVERE, User_Login_Register_Info.class.getName(), ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(User_Login_Register_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userKey;
	}
	
	public static void addUsernameAndPassword(String username, String password)
	{
    	Connection con = Database_Connect.Connect2LocalDB();
	       
        
        try {
        	
            PreparedStatement prep = con.prepareStatement("INSERT INTO account (username,password) VALUES (?,?)");
            prep.setString(1, username);
            prep.setString(2, password);
            prep.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(User_Login_Register_Info.class.getName()).log(Level.SEVERE, User_Login_Register_Info.class.getName() + ".addUserCar ", ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(User_Login_Register_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
