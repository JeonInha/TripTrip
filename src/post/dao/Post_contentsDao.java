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

		}

	}
}
