package utilities;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import beans.SessionBean;

public class CreateForm{

	public static void buildForm(SessionBean beanObject)
	{
		//String userName = beanObject.getUserName();
		String stockSymbol = "";
		String sharePrice = "51.30";
		String totalValue = "";
		String quantity = "";
		String form = "";
		for(HashMap.Entry<String, String[]> entry : beanObject.getHashMap()){
			stockSymbol = entry.getKey();
			String stocksArray[] = entry.getValue();
			totalValue = String.valueOf(String.format("%.02f", Double.parseDouble(sharePrice) * Double.parseDouble(stocksArray[1])));
			totalValue = "$"+totalValue;
			form = form+ "<form action=\"TransactionHandlerServlet\">\n" +
					"<div class=\"div-table-row\">\n" +
					"<div class=\"div-table-col\">"+stockSymbol+"</div>\n" +
					"<input type=\"hidden\" name=\"stockSymbol\" value=\""+stockSymbol+"\">\n" +
					"<div class=\"div-table-col\">"+"$"+sharePrice+"</div>\n" +
					"<input type=\"hidden\" name=\"sharePrice\" value=\""+"$"+sharePrice+"\">\n" +
					"<div class=\"div-table-col\">"+"-.068"+"</div>\n" +
					"<input type=\"hidden\" name=\"recentChange\" value=\""+"-0.68"+"\">\n" +
					"<div class=\"div-table-col\">"+"April 5, 4:32PM EST"+"</div>\n" +
					"<input type=\"hidden\" name=\"lastUpdated\" value=\""+"April 5, 4:32PM EST"+"\">\n" +
					"<div class=\"div-table-col\">"+stocksArray[1]+"</div>\n" +
					"<input type=\"hidden\" name=\"sharesOwned\" value=\""+stocksArray[1]+"\">\n" +
					"<div class=\"div-table-col\">"+totalValue+"</div>\n" +
					"<input type=\"hidden\" name=\"totalValue\" value=\""+"$"+totalValue+"\">\n" +
					"<div class=\"div-table-col\"><select name=\"action\" ><option value=\"buy\">buy</option><option value=\"sell\">sell</select></div>\n" +
					"<div class=\"div-table-col\"><input type=\"text\" name=\"quantity\" size=\"4\" value=\""+quantity+"\"></div>\n" +
					"<input type=\"hidden\" name=\"quantity\" value=\""+quantity+"\">\n" +
					"<div class=\"div-table-col oneTwentyFiveWidth\"><input type=\"submit\" value=\"Make Transaction\"></div>\n" +
				"</div>\n" +
			"</form>";
		}
		beanObject.setForm(form);
	}

}
