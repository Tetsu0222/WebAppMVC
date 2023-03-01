package model;

public class ExecuteLoginBL {
	public UserInfoDto executeSelectUserInfo(String userId, String passWord) {
		UserInfoDao dao = new UserInfoDao();
		UserInfoDto dto = dao.doSelect(userId, passWord);
		return dto;
	}
}