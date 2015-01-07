package dto;

public class Tweet {
	
	private int id_user;
	private String message;
	private String date;
	/**
	 * @return the id_user
	 */
	public int getId() {
		return id_user;
	}
	/**
	 * @param id_user the id_user to set
	 */
	public void setId(int id_user) {
		this.id_user = id_user;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
}