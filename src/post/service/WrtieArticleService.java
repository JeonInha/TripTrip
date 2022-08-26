package post.service;

import java.io.Writer;
import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JDBCListener;
import post.dao.PostDao;
import post.dao.Post_contentsDao;
import post.model.Post;
import post.model.Post_contents;
import user.model.UserAccount;

public class WrtieArticleService {
	
	private PostDao pd = new PostDao();
	private Post_contentsDao pcd = new Post_contentsDao();
	
	public Integer writeAddPlan(WriteRequest req) {
		
		// req에 담긴거 :: postNum; writer;title; content;
		
		Connection conn = null;
		
		
		try {
			conn = JDBCListener.getConnection();
			conn.setAutoCommit(false);
			
			Post_contents savedContent = pcd.insert(conn, req.getContent());
			
			if (savedContent == null) {
				throw new RuntimeException("fail to insert post_contents");
			}
			
			Post post = new Post(req.getPostNum(), req.getTitle(), req.getWriter());
			Post savedPost = pd.updateContentsNum(conn, savedContent.getNumber(), post);
			
			if (savedPost == null) {
				throw new RuntimeException("fail to update post");
			}
			
			conn.commit();
			
			return savedPost.getPost_id();
			
			
		} catch (SQLException e) {
			JDBCListener.rollback(conn);
			System.out.println("sql에러에러");
			throw new RuntimeException(e);
		} catch (RuntimeException e) {
			JDBCListener.rollback(conn);
			System.out.println("런타임 에러에러");
			throw e;
		} finally {
			JDBCListener.closeConn(conn);
		}
	}
}
