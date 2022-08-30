package post.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JDBCListener;
import post.dao.PostDao;
import post.dao.Post_contentsDao;
import post.model.Post;
import post.model.Post_contents;

public class ReadPostService {
	private PostDao postDao = new PostDao();
	private Post_contentsDao contentDao = new Post_contentsDao();
	
	public PostData getPost(int post_id, boolean increaseReadCount) {
		try (Connection conn = JDBCListener.getConnection()) {
			Post post = postDao.selectById(conn, post_id);
			if (post == null) {
				throw new PostNotFoundException();
			}
			Post_contents contents = contentDao.selectByIdContents(conn, post_id);
			if (contents == null) {
				throw new PostContentsNotFoundException();
			}
			return new PostData(post, contents);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
