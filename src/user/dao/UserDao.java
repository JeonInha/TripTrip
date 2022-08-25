package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JDBCListener;
import user.model.UserAccount;

public class UserDao {
	 
	private UserAccount resultMapping(ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String name = rs.getString("name");
		String pw = rs.getString("pw");
		return new UserAccount(id, name, pw);
	}
	
	// c:: sign Up logic // hasing f(x) use
	public int signUpByOwn(Connection conn, UserAccount user, String pw) {
		// TODO
		return 0;
	}
	
	// r:: read // selectById
	public UserAccount userSelectById(Connection conn, String id) throws SQLException {
		String sql = "select * from triptrip.user where id = ?";
		ResultSet rs = null;
		UserAccount user = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				user = resultMapping(rs);
			} 
			return user;
		} finally {
			JDBCListener.closeRs(rs);
		}
	}
	
	public String pwSelectById(Connection conn, String id) throws SQLException {
		String sql = "select * from triptrip.user where id = ?";
		ResultSet rs = null;
		String pw = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				pw = rs.getString("name");
			} 
			return pw;
		} finally {
			JDBCListener.closeRs(rs);
		}
	}
	
	public String saltSelectById(Connection conn, String id) throws SQLException {
		String sql = "select salt from triptrip.user where id = ?";
		ResultSet rs = null;
		String salt = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				salt = rs.getString("salt");
			} 
			return salt;
		} finally {
			JDBCListener.closeRs(rs);
		}
	}
	
	
	//u:: update
	
	//d:: delete	
}
