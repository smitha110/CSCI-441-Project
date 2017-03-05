package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.SessionBean;
/**
 * Servlet implementation class StockHoldingsHandlerServlet
 */
@WebServlet("/StockHoldingsHandlerServlet")
public class StockHoldingsHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StockHoldingsHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		SessionBean sessionInfo = (SessionBean)session.getAttribute("bean");
		
		if(request.getHeader("Referer").contains("login.jsp") || request.getHeader("Referer").contains("registration.jsp") || request.getSession(false) == null)
		{
			model.User_StockInfo.getStockHoldings(request);
		
			utilities.CreateForm.buildForm(sessionInfo);
			utilities.Redirects.gotoStockHoldings(response);
		}
		else
		{
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
