package javaweb.part1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaweb.part1.dao.ChinookDatabase;
import javaweb.part1.model.Track;

public class TrackDao extends ChinookDatabase {
	public List<Track> findAllTracks() throws ClassNotFoundException   {
	List<Track> allTracks = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			conn = new ChinookDatabase().connect();
			stmt = conn.prepareStatement("SELECT * FROM Track");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				long id = rs.getLong("TrackId");
				String name = rs.getString("Name");
				Track tracksss = new Track(id, name);
				allTracks.add(tracksss);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		ChinookDatabase.closeAll(conn, stmt, rs);
			
		}
		return allTracks;
	}
	  

	
}

