package user.service;

import lombok.Setter;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Setter
	UserDAO userDAO;
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
