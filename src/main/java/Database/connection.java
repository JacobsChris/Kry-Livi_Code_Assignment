package Database;

import java.sql.*;
import java.util.ArrayList;

public class connection {
    public static ArrayList<Entry> retrieveDatabase() {

        String sqlSelectAllWebsites = "SELECT * FROM web_services";
        String connectionURL = "jdbc:mysql://localhost:3309/dev";
        String username = "dev";
        String password = "secret";

        try (Connection conn = DriverManager.getConnection(connectionURL, username, password);
             PreparedStatement ps = conn.prepareStatement(sqlSelectAllWebsites);
             ResultSet rs = ps.executeQuery()) {

            ArrayList<Entry> data = new ArrayList<>();

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String websiteURL = rs.getString("url");
                int status = rs.getInt("status");
                Timestamp creationDate = rs.getTimestamp("");

                Entry row = new Entry (id, name, websiteURL, status, creationDate);

                data.add(row);
            }
            return data;

        } catch (SQLException e) {
            // TODO: handle the exception
        }
        return null;
    }


}
