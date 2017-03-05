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
/**
 * Servlet implementation class LoginHandlerServlet
 */
@WebServlet("/LoginHandlerServlet")
public class LoginHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		SessionBean sessionInfo = (SessionBean) session.getAttribute("bean");

		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		Boolean inDB = User_Login_Register_Info.checkUserNameAndPassword(userName, password);
		if(inDB.equals(true))
		{
			Integer userKey = User_Login_Register_Info.getUserPrimaryKey(userName);
			
			sessionInfo.setUserName(userName);
			sessionInfo.setUserPrimaryKey(Integer.toString(userKey));
			
			utilities.Redirects.gotoStockHoldingsHandlerServlet(response);
		}
		else if(inDB.equals(false))
		{
			sessionInfo.setMessage("***** Username/Password are incorrect *****");
			utilities.Redirects.gotoLoginJSP(response);			
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
