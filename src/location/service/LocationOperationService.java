package location.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.JDBCListener;
import location.dao.LocationDao;
import location.model.Location;

public class LocationOperationService {

	LocationDao ld = new LocationDao();

	public Location insertPlace(Location location) {
		try (Connection conn = JDBCListener.getConnection();) {

			return ld.insertLocation(conn, location);

		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
