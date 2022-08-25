package post.dao;
import java.sql.Statement;

import post.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDao {
	public Post insert(Connection conn, Post post) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt =null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO `triptrip`.`location_post` (`location_post_title`, `post_contents_number`, `user_id`) VALUES (?, ?, ?)");			
			pstmt.setString(1, post.getTitle());
			pstmt.setInt(2, post.getContents_number());
			pstmt.setString(3, post.getUser_id());
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id() from location_post");
				if (rs.next()) {
					Integer newNum = rs.getInt(1);
//					return new Post(title, contents_number, user_id);
				}
			}
			
		} finally {
			
		}
		return post;
	}
}
