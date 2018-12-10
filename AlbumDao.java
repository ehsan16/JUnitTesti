package javaweb.part1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaweb.part1.dao.ChinookDatabase;
import javaweb.part1.model.Album;


public class AlbumDao extends ChinookDatabase {
	public List<Album> findAllTracks() throws ClassNotFoundException   {
	List<Album> allAlbums = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
	
		try {
			conn = new ChinookDatabase().connect();
			stmt = conn.prepareStatement("SELECT * FROM Album");
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				long id = rs.getLong("AlbumId");
				String name = rs.getString("Name");
				Album albumsss = new Album(id, name);
				allAlbums.add(albumsss);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
		ChinookDatabase.closeAll(conn, stmt, rs);
			
		}
		return allAlbums;
	}
	
}

