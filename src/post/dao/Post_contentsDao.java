package post.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.JDBCListener;
import post.model.Post_contents;

public class Post_contentsDao {
	
	
	
	public Post_contents insert(Connection conn, String contents) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "insert into triptrip.location_post_contents (contents) values (?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contents);
			int count = pstmt.executeUpdate();
			
			if (count > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id()");
				if (rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Post_contents(newNum, contents);
				}				
			}
			return null;
		} finally {
			if (rs != null) {
				JDBCListener.closeRs(rs);
			}
			if (stmt != null) {
				JDBCListener.closeStmt(stmt);
			}
			if (pstmt != null) {
				JDBCListener.closeStmt(pstmt);
			}
		}

	}
	
	// post_contents의 id값으로 내용 조회하는 기능
	public Post_contents selectByIdContents(Connection conn, int id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from location_post_contents where id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			Post_contents contents = null;
			if (rs.next()) {
				contents = new Post_contents(rs.getInt("id"), rs.getString("contents"));
			}
			return contents;
		} finally {
			JDBCListener.closeRs(rs);
			JDBCListener.closeStmt(pstmt);
		}
	}
}
