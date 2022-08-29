package user.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdbc.JDBCListener;
import user.dao.UserDao;
import user.model.UserAccount;

public class IdCheckService {

	UserDao ud = new UserDao();
	
	public boolean idCheck(String id) {
		Connection conn = null;
		try {
			conn = JDBCListener.getConnection();
			UserAccount user = ud.userSelectById(conn, id);
			if (user != null) {
				return true;
			}
			return false;
			
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {
			JDBCListener.closeConn(conn);
		}
	}
}
