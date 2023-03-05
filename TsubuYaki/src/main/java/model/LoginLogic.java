package model;

public class LoginLogic {

	public boolean execute( String name , String pass ) {
		
		UserDao dao = new UserDao();
		User user = dao.doSelect( name , pass );
		
		if( user.getName() != null) {
			return true;
		}
		
		return false;
		
	}
}