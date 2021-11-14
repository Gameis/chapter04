package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Setter
	UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정 할 아이디 입력 : ");
		String id = sc.next();
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO != null) {
			userDAO.delete(id);
			
		}else {
			System.out.println("찾고자하는 아이디가 없습니다.");
		}

	}

}
