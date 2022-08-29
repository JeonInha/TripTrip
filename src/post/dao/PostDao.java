package post.dao;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.StatementEvent;

import jdbc.JDBCListener;
import post.model.Plan;
import post.model.Post;
import user.dao.UserDao;
import user.model.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDao {

	private Post resultMapping(ResultSet rs, Connection conn, UserDao ud) throws SQLException {
		int post_id = rs.getInt("id");
		String title = rs.getString("location_post_title");
		int contents_number = rs.getInt("post_contents_number");
		String user_id = rs.getString("user_id");
		
		UserAccount writer = ud.userSelectByIdnoPw(conn, user_id);
		Post post = new Post(post_id, title, contents_number, writer);
		System.out.println(post);
		return post;
	}

	public Post insertPost(Connection conn, Post post) throws SQLException {
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
	
	// Read Collections By ID Except 이미 쓰인 포스팅 // 이너조인 사용
	public List<Post> readNonPostedCollectionByID(Connection conn, String id) throws SQLException {
		List<Post> plans = new ArrayList<>();
		UserDao ud = new UserDao();
		String sql = "select * from location_post where user_id = ? and post_contents_number is null";
		ResultSet rs = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				plans.add(resultMapping(rs, conn, ud));
			}
			return plans;
			
		} finally {
			if (rs != null) {
				JDBCListener.closeRs(rs);
			}
		}		
	}
	
	public Post readPostByPostNum(Connection conn, int postNum) throws SQLException {
		Post post = null;
		String sql = "select * from location_post where id = ?";
		UserDao ud = new UserDao();
		ResultSet rs = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, postNum);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				post = resultMapping(rs, conn, ud);
			}
			return post;
		} finally {
			if (rs == null) {
				JDBCListener.closeRs(rs);
			}
		}
		
	}
	
	// Update // content_num add // 
	public Post updateContentsNum(Connection conn, int content_num, Post post) throws SQLException {
		String sql = " UPDATE location_post SET post_contents_number = ? WHERE id = ?";
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, content_num);
			pstmt.setInt(2, post.getPost_id());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				post.setContents_number(content_num);
				return post;
			}
			return null;
		} 
	}
	
	// 조회수
	public int selectCount(Connection conn) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select count(*) from location_post");
			if (rs.next()) {
				return rs.getInt(1);
			}
			return 0;
		} finally {
			JDBCListener.closeRs(rs);
			JDBCListener.closeStmt(stmt);
		}
	}
	
}
