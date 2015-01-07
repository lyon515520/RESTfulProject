package dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	//@Column(name = "id_user")
	private int id_user;
	
	//@Column(name = "name")
	private String name;
	
	//@Column(name = "nickname")
	private String nickname;
	
	//@Column(name = "joindate")
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
	
	@Column(name = "id_user")
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
	
	@Column(name = "name")
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
	
	@Column(name = "nickname")
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
	
	@Column(name = "joindate")
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
}
