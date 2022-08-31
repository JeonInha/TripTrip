package location.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JDBCListener;
import location.dao.LocationDao;
import location.model.Location;

public class LocationOperationService {

	LocationDao ld = new LocationDao();

	public List<Location> insertPlace(List<Location> location) {
		try (Connection conn = JDBCListener.getConnection();) {
			List<Location> locaList = new ArrayList<>();
			for (Location key : location) {
				locaList.add(ld.insertLocation(conn, key));
			}
			return location;
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
