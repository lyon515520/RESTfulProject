package webService;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.DBHelper;
import dto.User;
import dto.Tweet;

@Path("/WebService")
public class WebService {
	
	@GET
	@Path("UpdateData")
	@Produces({MediaType.APPLICATION_JSON})
	public void update() throws Exception {
		
		DBHelper.updateData();
	}
	
	@GET
	@Path("GetUser")
	@Produces({MediaType.APPLICATION_JSON})
	public List<User> user() throws Exception {
		
	    return DBHelper.getUser();
	}
	
	@GET
	@Path("/GetAllTweet")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Tweet> allTweet() throws Exception{
		
			return DBHelper.getAllTweet();
	}
	
	
	@GET
	@Path("/GetTweet/{id_user}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Tweet> tweet(@PathParam("id_user")long id_user) throws Exception{
		
		return DBHelper.getTweet(id_user);
		
	}
	

}
