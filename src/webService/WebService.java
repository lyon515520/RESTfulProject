package webService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import dao.DBHelper;
import dto.User;
import dto.Tweet;

@Path("/WebService")
public class WebService {
	
	
	@GET
	@Path("/GetUser")
	@Produces("application/json")
	public String user() throws Exception{
		
		try 
		{	
			List<User> userData = null;
			DBHelper.updateData();
			userData = DBHelper.getUser();
			Gson gson = new Gson();
			System.out.println(gson.toJson(userData));
			
		} catch (Exception e)
		{
			throw e;
		}
		return null;
	}
	
	@GET
	@Path("/GetAllTweet")
	@Produces("application/json")
	public String allTweet() throws Exception{
		
		try 
		{	
			List<Tweet> allTweet = null;
			DBHelper.updateData();
			allTweet = DBHelper.getAllTweet();
			Gson gson = new Gson();
			System.out.println(gson.toJson(allTweet));
			
		} catch (Exception e)
		{
			throw e;
		}
		return null;
	}
	
	@GET
	@Path("/GetTweet")
	@Produces("application/json")
	public String tweet(@QueryParam("id_user") long id_user) throws Exception{
		
		try 
		{
			List<Tweet> tweetData = null;
			DBHelper.updateData();
			tweetData = DBHelper.getTweet(id_user);
			Gson gson = new Gson();
			System.out.println(gson.toJson(tweetData));

		} catch (Exception e)
		{
			throw e;
		}
		return null;
	}
	
	

}
