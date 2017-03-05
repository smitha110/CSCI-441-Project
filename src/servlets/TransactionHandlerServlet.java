package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.SessionBean;

@WebServlet("/TransactionHandlerServlet")
public class TransactionHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		SessionBean sessionInfo = (SessionBean)session.getAttribute("bean");
		
		String stockSymbol = request.getParameter("stockSymbol");
		String sharePrice = request.getParameter("sharePrice");
		String sharesOwned = request.getParameter("sharesOwned");
		String action = request.getParameter("action");
		String quantity = request.getParameter("quantity");
		
		if(Double.parseDouble(quantity) > Double.parseDouble(sharesOwned) && action.equals("sell"))
		{
			sessionInfo.setMessage("You cannot sell more shares than you own.");
		}
		else if(Double.parseDouble(quantity) < 0 && action.equals("buy"))
		{
			sessionInfo.setMessage("You cannot buy negative shares.");
		}
		else
		{
			if(action.equals("sell"))
			{
				sharesOwned = String.valueOf(Double.parseDouble(sharesOwned) - Double.parseDouble(quantity));
			}
			else if(action.equals("buy"))
			{
				sharesOwned = String.valueOf(Double.parseDouble(sharesOwned) + Double.parseDouble(quantity));	
			}
			model.User_StockInfo.updateStockHolding(sessionInfo.getUserPrimaryKey(), stockSymbol, sharesOwned);
			sessionInfo.setHashMap(stockSymbol, sharesOwned);
			utilities.CreateForm.buildForm(sessionInfo);
		}
		
		utilities.Redirects.gotoStockHoldings(response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
