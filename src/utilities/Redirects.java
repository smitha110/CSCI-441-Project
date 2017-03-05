package utilities;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Redirects {
       
	public static void gotoLoginJSP(HttpServletResponse response) {
		try {
			response.sendRedirect("login.jsp");
		} catch(IOException ex) {
            Logger.getLogger(Redirects.class.getName()).log(Level.SEVERE, " ug, the Redirect for login.jsp did not work", ex);			
		}
	}
	public static void gotoStockHoldingsHandlerServlet(HttpServletResponse response) {
		try {
			response.sendRedirect("StockHoldingsHandlerServlet");
		} catch(IOException ex){
			Logger.getLogger(Redirects.class.getName()).log(Level.SEVERE, " ug, the Redirect for StockHoldingsHandlerServlet did not work", ex);
		}
	}
	public static void gotoRegistrationJSP(HttpServletResponse response) {
		try {
			response.sendRedirect("registration.jsp");
		} catch(IOException ex){
			Logger.getLogger(Redirects.class.getName()).log(Level.SEVERE, " ug, the Redirect for registration.jsp did not work", ex);
		}		
	}
	public static void gotoStockHoldings(HttpServletResponse response) {
		try {
			response.sendRedirect("stockHoldings.jsp");
		} catch(IOException ex){
			Logger.getLogger(Redirects.class.getName()).log(Level.SEVERE, " ug, the Redirect for stockHoldings.jsp did not work", ex);
		}
	}
}
