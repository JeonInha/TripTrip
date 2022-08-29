package user.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JDBCListener;
import user.dao.UserDao;
import user.model.UserAccount;
import util.SHA256Util;

public class SignUpService {
	
	private UserDao ud = new UserDao();

	public UserAccount signUp(UserAccount user) {
		Connection conn = null;
		try {
			conn = JDBCListener.getConnection();
			conn.setAutoCommit(false);
			
			String salt = SHA256Util.generateSalt();
			user.setSalt(salt);
			user.setPw(SHA256Util.getEncrypt(user.getPw(), salt));
			
			ud.signUpByOwn(conn, user);
			conn.commit();
			return new UserAccount(user.getId(), user.getName());
			
		} catch (SQLException e) {
			JDBCListener.rollback(conn);
			throw new RuntimeException();
			
		} finally {
			JDBCListener.closeConn(conn);
		}
	}
}
