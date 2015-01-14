package webService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.DBHelper;
import dto.User;
import dto.Tweet;

@Path("/WebService")
public class WebService {
	
	/*@POST
	@Path("/test")
	@Produces("application/json")
	public void update() throws Exception  {
		
		try {
			//DBHelper.updateData();
			System.out.println("test is oki");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
			
		}
		
	}
	*/
	
	@GET
	@Path("GetUser")
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> user() throws Exception {
		
		DBHelper.updateData();
	    return DBHelper.getUser();
	}
	
	@GET
	@Path("/GetAllTweet")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Tweet> allTweet() throws Exception{
		
			DBHelper.updateData();
			return DBHelper.getAllTweet();
	}
	
	
	@GET
	@Path("/GetTweet/{id_user}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Tweet> tweet(@PathParam("id_user")long id_user) throws Exception{
		
		DBHelper.updateData();
		return DBHelper.getTweet(id_user);
		
	}
	

}
