package user.service;
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JDBCListener;
import user.dao.UserDao;
import user.model.UserAccount;
import util.SHA256Util;

public class LoginService {
	
	private UserDao md = new UserDao();
	
	public UserAccount login(String id, String pw) {
		
		try (Connection conn = JDBCListener.getConnection()) {
			
			UserAccount user = md.userSelectById(conn, id);
			String salt = md.saltSelectById(conn, id);
			pw = SHA256Util.getEncrypt(pw, salt);
			
			if (user==null) {
				throw new LoginFailExcepion();
			}
			if (! user.matchPassword(pw)) {
				throw new LoginFailExcepion();
			}
			return new UserAccount(user.getId(), user.getName());
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}		
	}
}
