package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Tweet;
import dto.User;

import org.apache.log4j.Logger;


public class DBHelper {
	static Logger log = Logger.getLogger(DBHelper.class);
	
	public static void updateData() throws Exception
	{
		
		Database database = new Database();
		Connection connection = database.Get_Connection();
		
		try
		{
			/*1 part to update the user*/
			PreparedStatement ps1 = connection.prepareStatement("SELECT * FROM user");
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()){
				rs1.close();
				//use log this place
			}else{
				String user = "INSERT INTO `user` (`id_user`, `name`, `nickname`, `joindate`) VALUES"
							+"(1, 'Lee', 'ali', '2008-12-29 00:0'),"
							+"(2, 'Zhang', 'liz', '2011-10-14 00:0'),"
							+"(3, 'Alexendre', 'alex', '2012-03-04 00:0')";
				PreparedStatement update_user = connection.prepareStatement(user);
				update_user.executeUpdate();
			}
			
			/*1 part to update the tweet*/
			PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM tweet");
			ResultSet rs2 = ps2.executeQuery();
			if(rs2.next()){
				rs2.close();
				//use log this place
			}else{
				String tweet = "INSERT INTO `tweet` (`id_tweet`, `id_user`, `message`, `date`) VALUES"
						+"(1, 1, 'this is a message demo1', '2013-12-14 00:0'),"
						+"(2, 1, 'this is a message demo2', '2013-12-17 00:0'),"
						+"(3, 2, 'this is a message demo3', '2013-05-17 00:0'),"
						+"(4, 2, 'this is a message demo4', '2014-05-14 00:0'),"
						+"(5, 3, 'this is a message demo5', '2012-07-11 00:0'),"
						+"(6, 3, 'this is a message demo6', '2011-05-15 00:0')";
				PreparedStatement update_tweet = connection.prepareStatement(tweet);
				update_tweet.executeUpdate();
			}
			
			
		}
		catch(Exception e)
		{
			//throw e;
			System.out.println("something wrong in this part");
		}
		
	}
	
	
	public static List<User> getUser() throws Exception
	{	
		Database database = new Database();
		
		List<User> userData = new ArrayList<User>();
		//Statement stmt=null;
		ResultSet rset=null;
		PreparedStatement ps =null;
		
		
		
		Connection connection = database.Get_Connection();
		// get a connection to the DB
		
		
		try
		{	
			
			ps = connection.prepareStatement("SELECT * FROM user ORDER BY id_user ASC");
			rset = ps.executeQuery();
			
			// analyze results
			while(rset.next()){
				User userObject = new User();
				userObject.setId(rset.getInt("id_user"));
				userObject.setName(" "+rset.getString("name"));
				userObject.setNickname(" "+rset.getString("nickname"));
				userObject.setJoindate(" "+rset.getString("joindate"));
				userData.add(userObject);
				log.trace("found Book: "+userObject.toString());
			}
			
			log.info("found a total of "+userData.size()+" user(s)"); 
			return userData;
		}catch (SQLException e) {
			// TODO Auto-generated catch block 
			//e.printStackTrace();
			throw e;
		} /*finally{
			try { if (rset != null) rset.close(); } catch(Exception e) { e.printStackTrace(); }
			try { if (ps != null) ps.close(); } catch(Exception e) { e.printStackTrace(); }
			try { if (connection != null) connection.close(); } catch(Exception e) { e.printStackTrace(); }
		}*/
		
	}
	
	public static List<Tweet> getAllTweet() throws Exception
	{
		
		Database database = new Database();
		
		List<Tweet> tweetDataAll = new ArrayList<Tweet>();
		//Statement stmt=null;
		ResultSet rset=null;
		PreparedStatement ps =null;
			
		
		Connection connection = database.Get_Connection();
		// get a connection to the DB
		
		
		try
		{
			ps = connection.prepareStatement("SELECT * FROM tweet ORDER BY id_tweet ASC");
			rset = ps.executeQuery();
			
			// analyze results
			while(rset.next()){
				Tweet tweetObjectAll = new Tweet();
				tweetObjectAll.setTweetId(rset.getInt("id_tweet"));
				tweetObjectAll.setUserId(rset.getInt("id_user"));
				tweetObjectAll.setMessage(" "+rset.getString("message"));
				tweetObjectAll.setDate(" "+rset.getString("date"));
				tweetDataAll.add(tweetObjectAll);
				log.trace("found Tweet: "+tweetObjectAll.toString());
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} finally{
			try { if (rset != null) rset.close(); } catch(Exception e) { e.printStackTrace(); }
			try { if (ps != null) ps.close(); } catch(Exception e) { e.printStackTrace(); }
			try { if (connection != null) connection.close(); } catch(Exception e) { e.printStackTrace(); }
		}
		log.info("found a total of "+tweetDataAll.size()+" tweet(s)"); 
		return tweetDataAll;
	}
	
	public static List<Tweet> getTweet(long id_user) throws Exception
	{
		Database database = new Database();
		
		List<Tweet> tweetData = new ArrayList<Tweet>();
		//Statement stmt=null;
		ResultSet rset=null;
		PreparedStatement ps =null;
			
		
		Connection connection = database.Get_Connection();
		// get a connection to the DB
		
		
		try
		{
			ps = connection.prepareStatement("SELECT * FROM tweet WHERE id_user = '"+id_user+"'");
			rset = ps.executeQuery();
			
			// analyze results
			while(rset.next()){
				Tweet tweetObject = new Tweet();
				tweetObject.setTweetId(rset.getInt("id_tweet"));
				tweetObject.setUserId(rset.getInt("id_user"));
				tweetObject.setMessage(rset.getString("message"));
				tweetObject.setDate(rset.getString("date"));
				tweetData.add(tweetObject);
				log.trace("found Tweet: "+tweetObject.toString());
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} finally{
			try { if (rset != null) rset.close(); } catch(Exception e) { e.printStackTrace(); }
			try { if (ps != null) ps.close(); } catch(Exception e) { e.printStackTrace(); }
			try { if (connection != null) connection.close(); } catch(Exception e) { e.printStackTrace(); }
		}
		
		log.info("found a total of "+tweetData.size()+" tweet(s)"); 
		return tweetData;
		
	}
	
}
