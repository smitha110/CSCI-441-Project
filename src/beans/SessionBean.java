package beans;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

public class SessionBean {
	private String userName = "";
	private String message = "";
	private HashMap<String, String[]> stockHoldings = new HashMap<String, String[]>();
	private String form;
	private String userPrimaryKey = "";
	
	//getters
	public String getUserName()
	{
		return userName;
	}
	public String getMessage()
	{
		return message;
	}
    public Set<Entry<String, String[]>> getHashMap()
    {
    	Set<Entry<String, String[]>> set = stockHoldings.entrySet();
    	return set;
    }
    public String getForm()
    {
    	return form;
    }
    public String getUserPrimaryKey()
    {
    	return userPrimaryKey;
    }
	//setters
	public void setUserName(String value)
	{
		this.userName = value;
	}
	public void setMessage(String value)
	{
		this.message = value;
	}
    public void setHashMap(String argument1, String argument2)
    {
        this.stockHoldings.put(argument1, new String[] {argument1, argument2});
 
    }
    public void setForm(String value)
    {
    	this.form = value;
    }
    public void setUserPrimaryKey(String value)
    {
    	this.userPrimaryKey = value;
    }
}
