package post.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCListener;
import post.dao.PostDao;
import post.model.Post;

public class ReadNoPostedPlanListService {
	private PostDao pd = new PostDao();
	
	public List<Post> readList(String id) {
		
		List<Post> planList = new ArrayList<>();
		try (Connection conn = JDBCListener.getConnection();) {
			
		planList = pd.readNonPostedCollectionByID(conn, id);
		return planList;
		
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
}
