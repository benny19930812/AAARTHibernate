package tw.springmvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountService {

	@Autowired
	private AccountDAO accountDao;

	public boolean checkLogin(Account account) {
		return accountDao.checkLogin(account);
	}
}

