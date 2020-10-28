package model;

import org.springframework.stereotype.Repository;

@Repository("loginDao1")
public class LoginDAO {
	public boolean checkLogin(String user,String pwd) {
		//"john".equals(user) user和.equals( "john")
		//"john".equals(user)較不會發生nullpoint exception
		if ("john".equals(user)&&"test123".equals(pwd)) {
				return true;
		}
		return false;
	}
}
