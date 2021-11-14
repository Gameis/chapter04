package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import user.bean.UserDTO;

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {

//	@Setter
//	private JdbcTemplate jdbcTemplate;	
	
	@Override
	public void write(UserDTO userDTO) {
		//String sql = "insert into usertable values(?, ?, ?)";
		//jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
		
		String sql = "insert into usertable values(:name, :id, :pwd)";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		
		String sql = "select * from usertable";

		return getJdbcTemplate().query(sql, 
				new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	public UserDTO getUser(String id) {

		String sql = "select * from usertable where id = " + "'" + id + "'";

		try {
			return getJdbcTemplate().queryForObject(sql,
					new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}


	@Override
	public void update(UserDTO userDTO) {

		String sql = "update usertable set name = :name, pwd = :pwd where id = :id";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userDTO.getId());
		map.put("name", userDTO.getName());
		map.put("pwd", userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
		
		System.out.println("수정 완료");
		
	}

	@Override
	public void delete(String id) {

		String sql = "delete usertable where id = " + "'" + id + "'";
		
		getJdbcTemplate().update(sql);
		
		System.out.println("삭제 완료");
		
	}

}
