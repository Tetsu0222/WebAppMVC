package model;

public class LoginLogic {

	//SQLへアクセス、結果を処理する予定
	public boolean execute( User user ) {
		return user.getPass().equals( "1234" );
	}
	
}