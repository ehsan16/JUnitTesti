import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumDao {
	public Album findAlbum(long artistId) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = new ChinookDatabase().connect();
			statement = connection.prepareStatement("SELECT * FROM Album WHERE AlbumId = ?");
			statement.setLong(1, artistId);
			result = statement.executeQuery();
			if (result.next()) {
				long id = result.getLong("AlbumId");
				String name = result.getString("Name");
				return new Album(id, name);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ChinookDatabase.closeQuietly(connection, statement, result);
		}
	}
	
	
}
