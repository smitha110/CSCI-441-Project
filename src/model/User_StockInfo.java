package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.SessionBean;


public class User_StockInfo {
	public static void setStockHolding(HttpServletRequest request, String userKey, String symbol, String amount)
	{
		HttpSession session = request.getSession(false);
		SessionBean sessionInfo = (SessionBean)session.getAttribute("bean");
		Connection con = Database_Connect.Connect2LocalDB();
		
        try {
            PreparedStatement prep = con.prepareStatement("INSERT INTO stockholding (userprimarykey,stocksymbol,stockamount) VALUES (?,?,?)");
            prep.setString(1, userKey);
            prep.setString(2, symbol);
            prep.setString(3, amount);
            prep.executeUpdate();
            
            sessionInfo.setHashMap(symbol, amount);

        } catch (SQLException ex) {
            Logger.getLogger(User_StockInfo.class.getName()).log(Level.SEVERE, User_StockInfo.class.getName() + ".setStockHolding ", ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(User_StockInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public static void updateStockHolding(String userKey, String symbol, String amount)
	{
		Connection con = Database_Connect.Connect2LocalDB();
		
        try {
            PreparedStatement prep = con.prepareStatement("UPDATE stockholding SET stockamount = ? WHERE userprimarykey = ? AND stocksymbol = ?");
            prep.setString(1, amount);
            prep.setString(2, userKey);
            prep.setString(3, symbol);
            prep.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(User_StockInfo.class.getName()).log(Level.SEVERE, User_StockInfo.class.getName() + ".setStockHolding ", ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(User_StockInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	public static void getStockHoldings(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		SessionBean sessionInfo = (SessionBean)session.getAttribute("bean");
		
		Connection con = Database_Connect.Connect2LocalDB();
		
        try {
    		PreparedStatement prep = con.prepareStatement("SELECT stocksymbol,stockamount FROM `stockholding` WHERE userprimarykey = ?");
    		prep.setString(1, sessionInfo.getUserPrimaryKey());
    		ResultSet rs = prep.executeQuery();
    		while (rs.next()){
    			if(rs.getString("stocksymbol").equals("GOOG"))
    			{
    				sessionInfo.setHashMap(rs.getString("stocksymbol"), rs.getString("stockamount"));
    			}
    			else if(rs.getString("stocksymbol").equals("AAPL"))
    			{
    				sessionInfo.setHashMap(rs.getString("stocksymbol"), rs.getString("stockamount"));    				
    			}
    			else if(rs.getString("stocksymbol").equals("MSFT"))
    			{
    				sessionInfo.setHashMap(rs.getString("stocksymbol"), rs.getString("stockamount"));
    			}
    		}
        } catch (SQLException ex) {
            Logger.getLogger(User_StockInfo.class.getName()).log(Level.SEVERE, User_StockInfo.class.getName() + ".setStockHolding ", ex);
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(User_StockInfo.class.getName()).log(Level.SEVERE, null, ex);
        }		
	}
}
