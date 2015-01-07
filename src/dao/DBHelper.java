package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import dto.User;

public class DBHelper {
	
	static Logger log = Logger.getLogger(DBHelper.class);
	private static final String PERSISTENCEUNIT="JPAService";
	private static EntityManagerFactory emfactory;
	
	static {
		log.trace("creating EntityManagerFactory");
		emfactory=Persistence.createEntityManagerFactory(PERSISTENCEUNIT);
	}
	
	public static boolean updateData(String name, String nickname, String joindate){
		System.out.println("finaly okay");
		EntityManager em=emfactory.createEntityManager();
		//log.trace("em="+em);
		em.getTransaction().begin();
		User user = new User();
		user.setName(name);
		user.setNickname(nickname);
		user.setJoindate(joindate);
		em.persist(user);
		em.getTransaction().commit();
		return true;
	}
	
	/*public static void updateData(){
		System.out.println("finaly okay");
		EntityManager em=emfactory.createEntityManager();
		//log.trace("em="+em);
		em.getTransaction().begin();
		User user = new User();
		user.setName("Billie");
		user.setNickname("bill");
		user.setJoindate("2008-12-29 00:0");
		em.persist(user);
		em.getTransaction().commit();
	}
	
	public static List<User> getUsers() {
		List<User> result=new ArrayList<User>();
		EntityManager em=emfactory.createEntityManager();
		//log.trace("em="+em);
		Query q=em.createQuery("SELECT * FROM user ORDER BY id_user ASC");
		List<User> users=q.getResultList();
		for (User b : users) {
			StringBuffer sb=new StringBuffer();
			sb.append(b.getId());
			sb.append(" "+b.getName());
			sb.append(" / "+b.getNickname());
			sb.append(" / "+b.getJoindate());
			result.add(sb.toString());
			//log.trace("found Book: "+sb.toString());
		}
		return result;
	}
	*/
	

}
