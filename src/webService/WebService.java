package webService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.google.gson.Gson;

import dao.DBHelper;
import dao.GetObjet;
import dto.User;
import dto.Tweet;

@Path("/WebService")
public class WebService {
	
	
	@GET
	@Path("/GetUser")
	@Produces("application/json")
	public String user() throws Exception{
		
		//Database database= new Database();
	    //Connection connection = database.Get_Connection();
		//String users  = null;
		
		try 
		{	
			/*List<User> userData = null;
			GetObjet gb = new GetObjet();
			gb.updateData();
			userData = gb.getUser();
			Gson gson = new Gson();
			System.out.println(gson.toJson(userData));*/
			//DBHelper dp = new DBHelper();
			DBHelper.updateData("Billie","bill","2008-12-29 00:0");
			//DBHelper.updateDataTest();
			System.out.println("oki");
			
		} catch (Exception e)
		{
			throw e;
			//System.out.println("error/webservice");
		}
		return null;
	}
	
	
	@GET
	@Path("/GetTweet")
	@Produces("application/json")
	public String tweet(@QueryParam("nickname") String nickname){
		
		try 
		{
			List<Tweet> tweetData = null;
			GetObjet gb = new GetObjet();
			gb.updateData();
			tweetData = gb.getTweet(nickname);
			Gson gson = new Gson();
			System.out.println(gson.toJson(tweetData));
			//tweet = gson.toJson(tweetData);

		} catch (Exception e)
		{
			System.out.println("error");
		}
		return null;
	}
	
	

}
