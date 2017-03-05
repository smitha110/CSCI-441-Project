package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database_Connect {
	
	public static String user = "csci441", pass = "csci441";

	public static Connection Connect2LocalDB() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/stockinvestments", Database_Connect.user, Database_Connect.pass);

            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database_Connect.class.getName()).log(Level.SEVERE, Database_Connect.class.getName() + ".Connect2LocalDB" + " ClassNotFoundException", ex);
        } catch (SQLException ex) {
            Logger.getLogger(Database_Connect.class.getName()).log(Level.SEVERE, Database_Connect.class.getName() + ".Connect2LocalDB" + " SQLException", ex);
        }
        return con;
	}
}
