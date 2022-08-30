package post.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.JDBCListener;
import post.dao.PostDao;
import post.model.Post;

public class ListPostService {
	private PostDao postDao = new PostDao();
	private int size = 5;	// 1페이지에 몇개씩 보게 할껀지 
	
	public PostPage getPostPage(int pageNum) {
		try (Connection conn = JDBCListener.getConnection()) {
			int total = postDao.selectCount(conn);
			System.out.println("총 몇개의 게시물인지 확인하기" + total);
			List<Post> content = postDao.select(conn, (pageNum - 1) * size, size);
			return new PostPage(total, pageNum, size, content);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
