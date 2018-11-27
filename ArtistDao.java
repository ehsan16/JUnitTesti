import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistDao {
	public Artist findArtist(long artistId) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		try {
			connection = new ChinookDatabase().connect();
			statement = connection.prepareStatement("SELECT * FROM Artist WHERE ArtistId = ?");
			statement.setLong(1, artistId);
			result = statement.executeQuery();
			if (result.next()) {
				long id = result.getLong("ArtistId");
				String name = result.getString("Name");
				return new Artist(id, name);
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
