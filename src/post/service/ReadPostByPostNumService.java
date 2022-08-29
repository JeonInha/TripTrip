package post.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JDBCListener;
import post.dao.PostDao;
import post.model.Post;

public class ReadPostByPostNumService {
	private PostDao pd = new PostDao();

	public Post readPostByNum(int id) {

		Post post = null;
		try (Connection conn = JDBCListener.getConnection();) {

			post = pd.readPostByPostNum(conn, id);
			return post;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
