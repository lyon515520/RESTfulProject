package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User{
	
	private int id_user;
	
	private String name;
	
	private String nickname;
	
	private String joindate;
	
	/**
	 * @return the id_user
	 */
	public int getId(){
		return id_user;
	}
	/**
	 * @param id_user the id_user to set
	 */
	
	public void setId(int id_user) {
		this.id_user = id_user;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname the nickname to set
	 */
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the joindate
	 */
	public String getJoindate() {
		return joindate;
	}
	/**
	 * @param joindate the joindate to set
	 */
	
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
}
