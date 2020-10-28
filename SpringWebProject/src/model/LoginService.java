package model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService3")
public class LoginService {
	
	@Autowired
    private LoginDAO loginDao;
    
    public LoginService() {    	
    }
	
	public LoginService(LoginDAO loginDao) {
       this.loginDao = loginDao;
	}
	
	public void setLoginDao(LoginDAO loginDao) {
		this.loginDao = loginDao;
	}
	
	public boolean checkLogin(String user, String pwd) {
		return loginDao.checkLogin(user, pwd);
	}

}

