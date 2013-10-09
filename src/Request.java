package parser;

public class Request 
{
	
	
	private Integer RequestId;
	private Integer ManagerId;
	private String RestaurantName;
	private String Cuisine;
	private String Location;
	
	
	Request()
	{
	}
	
	/*
	 * GET PARAMETER
	 */
	
	public Integer getRequestId()
	{
		return RequestId;
	}
	
	public Integer getManagerId()
	{
		return ManagerId;
	}
	
	public String getRestaurantName()
	{
		return RestaurantName;
	}
	
	public String getCuisine()
	{
		return Cuisine;
	}
	
	public String getLocation()
	{
		return Location;
	}
	
	
	/*
	 *  SET PARAMETER
	 */
	public void setRequestId(Integer RequestId)
	{
		this.RequestId = RequestId;
	}
	
	public void setManagerId(Integer ManagerId)
	{
		this.ManagerId = ManagerId;
	}
	
	public void setRestaurantName(String RestaurantName)
	{
		this.RestaurantName = RestaurantName;
	}
	
	public void setCuisine(String Cuisine)
	{
		this.Cuisine = Cuisine;
	}
	
	public void setLocation(String Location)
	{
		this.Location = Location;
	}

}
