package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Tweet;
import dto.User;


public class GetObjet {
	
	
	public void updateData() throws Exception
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
	
	
	public List<User> getUser() throws Exception
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
				//log.trace("found Book: "+userObject.toString());
			}			
		}catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} finally{
			try { if (rset != null) rset.close(); } catch(Exception e) { e.printStackTrace(); }
			try { if (ps != null) ps.close(); } catch(Exception e) { e.printStackTrace(); }
			try { if (connection != null) connection.close(); } catch(Exception e) { e.printStackTrace(); }
		}
		//log.info("found a total of "+result.size()+" book(s)"); 
		return userData;
	}
	
	
	public List<Tweet> getTweet(String nickname) throws Exception
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
			ps = connection.prepareStatement("SELECT message FROM tweet NATURAL JOIN user WHERE nickname = '"+nickname+"'");
			rset = ps.executeQuery();
			
			// analyze results
			while(rset.next()){
				Tweet tweetObject = new Tweet();
				tweetObject.setMessage(rset.getString("message"));
				tweetData.add(tweetObject);
				//log.trace("found Book: "+userObject.toString());
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace(); 
		} finally{
			try { if (rset != null) rset.close(); } catch(Exception e) { e.printStackTrace(); }
			try { if (ps != null) ps.close(); } catch(Exception e) { e.printStackTrace(); }
			try { if (connection != null) connection.close(); } catch(Exception e) { e.printStackTrace(); }
		}
		return tweetData;
		
	}
	
}
