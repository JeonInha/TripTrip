package location.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCListener;
import location.model.Location;

public class LocationDao {

	// 필요한 부가적 메소드
	private Location resultMappingNoLatLng(ResultSet rs) throws SQLException {
		int num = rs.getInt("id");
		String name = rs.getString("location_name");
		return new Location(num, name);
	}
	
	private Location resultMappingWithLatLng(ResultSet rs) {
		return null;
		//TODO
	}
	
	
	// create
	
	
	
	// read
	public List<Location> readAllLocation(Connection conn) throws SQLException {
		List<Location> locaList = new ArrayList<>();
		String sql = "select * from triptrip.location";

		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				locaList.add(resultMappingNoLatLng(rs));
			}
			return locaList;
		}
	}
	
	public List<Location> readBookmarkLocation(Connection conn, String user_id) throws SQLException {
		List<Location> locaList = new ArrayList<>();
		String sql = "select location.*, location_like.user_id  from location "
				+ "inner join location_like "
				+ "on location.id = location_like.location_number "
				+ "where location_like.user_id = ? ";
		ResultSet rs = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				locaList.add(resultMappingNoLatLng(rs));
			}
			return locaList;
		} finally {
			if (rs != null) {
				JDBCListener.closeRs(rs);
			}
		}
	}
	
	public List<Location> readKategorieLocation(Connection conn, int post_num) throws SQLException {
		List<Location> locaList = new ArrayList<>();
		String sql = "select location.* /*, location_post.location_post_title, location_post.user_id*/ from location\r\n" + 
				"	inner join location_post_storage\r\n" + 
				"    on location.id = location_post_storage.location_number\r\n" + 
				"    inner join location_post\r\n" + 
				"    on location_post_storage.location_post_number = location_post.id\r\n" + 
				"    where location_post.id = ? ;";
			ResultSet rs = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, post_num);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				locaList.add(resultMappingNoLatLng(rs));
			}
			return locaList;
		} finally {
			if (rs != null) {
				JDBCListener.closeRs(rs);
			}
		}
	}
	
	// update: 관리자만
	
	// delete: 관리자만
}
