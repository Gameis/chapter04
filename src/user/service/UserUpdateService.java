package user.service;

import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Setter
	UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정 할 아이디 입력 : ");
		String id = sc.next();
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO != null) {
			System.out.println(userDTO.getName() + "\t"
					 + userDTO.getId() + "\t"
					 + userDTO.getPwd());
			
			System.out.print("수정할 이름 입력 : ");
			userDTO.setName(sc.next());
			System.out.print("수정할 비밀번호 입력 : ");
			userDTO.setPwd(sc.next());
			
			userDAO.update(userDTO);
			
		}else {
			System.out.println("찾고자하는 아이디가 없습니다.");
		}
		
		

	}

}
