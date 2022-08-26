package post.dao;
import java.sql.Statement;
import java.util.List;

import jdbc.JDBCListener;
import post.model.Plan;
import post.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDao {

	/*
	public Post(String title, Integer contents_number, String user_id) {
		super();
		this.title = title;
		this.contents_number = contents_number;
		this.user_id = user_id;
	}
	*/
	
	// C
	public Post insert(Connection conn, Post post) throws SQLException {
		PreparedStatement pstmt = null;
		Statement stmt =null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO triptrip.location_post (location_post_title, post_contents_number, user_id) VALUES (?, ?, ?)");			
			pstmt.setString(1, post.getTitle());
			pstmt.setInt(2, post.getContents_number());
			pstmt.setString(3, post.getWriter().getId());
			int insertedCount = pstmt.executeUpdate();
			
			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select last_insert_id();");
				if (rs.next()) {
					Integer newNum = rs.getInt(1);
					return new Post(newNum, post.getTitle(), post.getContents_number(), post.getWriter());
				}
			}
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
		return post;
	}
	
	// R
	// Read Collections By ID
	
	// Read Collections By ID Except 이미 쓰인 포스팅 // 이너조인 사용
//	public List<Plan> readNonPostedCollectionByID(String id) {
//		String sql = "select * from location_post where user_id = ? and post_contents_number is null";
//	}
	
	
}
