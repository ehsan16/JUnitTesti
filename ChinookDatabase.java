
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChinookDatabase {
private static final String URL = "jdbc:sqlite:M:\\sqlite\\Chinook_Sqlite.sqlite";
public Connection connect() throws SQLException, ClassNotFoundException {
Class.forName("org.sqlite.JDBC");
return DriverManager.getConnection(URL);
}
public static void closeQuietly(Connection connection, PreparedStatement statement, ResultSet result) {
	// TODO Auto-generated method stub
	
}
}
