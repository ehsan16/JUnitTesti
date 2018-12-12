package javaweb.part1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaweb.part1.dao.ChinookDatabase;
import javaweb.part1.model.Artist;

public class ArtistDao extends ChinookDatabase {
	public List<Artist> findAllArtists() throws ClassNotFoundException   {
	List<Artist> allArtists = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			conn = new ChinookDatabase().connect();
			stmt = conn.prepareStatement("SELECT * FROM Artist");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				long id = rs.getLong("artistid");
				String name = rs.getString("name");
				Artist artistsss = new Artist(id, name);
				allArtists.add(artistsss);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		ChinookDatabase.closeAll(conn, stmt, rs);
			
		}
		return allArtists;
	}
	  
	
	public static void removeArtist(long ArtistId) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = new ChinookDatabase().connect();
			stmt = conn.prepareStatement("DELETE FROM Artist WHERE ArtistId = ?");
		stmt.setLong(1, ArtistId);
		stmt.executeUpdate();
		} catch (RuntimeException e) {
			throw new RuntimeException (e);
		} finally {
			conn.close();
			stmt.close();
		}
	}

	
}

