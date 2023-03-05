package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Mutter implements Serializable{
	
	private String userName;
	private String text;
	private Timestamp time;
	
	public Mutter() {}
	
	public Mutter( String userName , String text , Timestamp time ) {
		this.userName = userName;
		this.text = text;
		this.time = time;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	

}
