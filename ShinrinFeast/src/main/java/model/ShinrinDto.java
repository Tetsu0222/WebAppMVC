package model;

import java.sql.Timestamp;

public class ShinrinDto {

	private String    name   ;
	private String    email  ;
	private String    message;
	private Timestamp time   ;

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getMail() {return email;}
	public void setMail(String email) {this.email = email;}

	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }

	public Timestamp getTime() { return time; }
	public void setTime(Timestamp time) { this.time = time; }

}
