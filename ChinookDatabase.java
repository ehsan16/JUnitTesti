package javaweb.part1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChinookDatabase {
private static final String URL = "jdbc:sqlite:C:\\sqlite\\Chinook_Sqlite.sqlite";
public Connection connect() throws SQLException, ClassNotFoundException {
Class.forName("org.sqlite.JDBC");
return DriverManager.getConnection(URL);
}
public static void closeAll(Connection conn, PreparedStatement stmt, ResultSet rs) {
    try {
        if (rs != null) { // Suljetaan rs 
                            // olemassa
            rs.close();
        }
        if (stmt != null) { // Suljetaan stmt 
                            // olemassa
            stmt.close();
        }
        if (conn != null) { // Suljetaan conn 
            conn.close();
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
	
}

