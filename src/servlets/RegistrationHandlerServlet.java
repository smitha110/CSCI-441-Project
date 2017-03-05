package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.SessionBean;
import model.User_Login_Register_Info;

@WebServlet("/RegistrationHandlerServlet")
public class RegistrationHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		SessionBean sessionInfo = (SessionBean)session.getAttribute("bean");
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		if(userName.equals(null) || userName.isEmpty() || password.equals(null) || password.isEmpty() || confirmPassword.equals(null) || confirmPassword.isEmpty())
		{
			sessionInfo.setMessage("***** Fields Cannot Be Empty *****");
			utilities.Redirects.gotoRegistrationJSP(response);
		}
		else if(!password.equals(confirmPassword))
		{
			sessionInfo.setMessage("***** Password Do Not Match *****");
			utilities.Redirects.gotoRegistrationJSP(response);
		}
		else
		{
			Boolean inDB = model.User_Login_Register_Info.isUserNameInDB(userName);
			if(inDB.equals(true))
			{
				sessionInfo.setMessage("***** Username "+ userName + " is taken *****");
				utilities.Redirects.gotoRegistrationJSP(response);
			}
			else if(inDB.equals(false))
			{
				model.User_Login_Register_Info.addUsernameAndPassword(userName, password);
				String userKey = Integer.toString(User_Login_Register_Info.getUserPrimaryKey(userName));
				sessionInfo.setUserPrimaryKey(userKey);
				
				//Enter 10 of each stock here from model.User_StockInfo
				model.User_StockInfo.setStockHolding(request, userKey,"MSFT", "10");
				model.User_StockInfo.setStockHolding(request, userKey,"GOOG", "10");
				model.User_StockInfo.setStockHolding(request, userKey,"AAPL", "10");
				
				utilities.Redirects.gotoStockHoldingsHandlerServlet(response);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
