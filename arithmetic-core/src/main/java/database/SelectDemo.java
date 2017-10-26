package database;

import java.sql.*;

/**
 * Created by peng.tan on 17/10/20.
 */
public class SelectDemo {
    public static void main(String[] args) throws SQLException {
        String serverName = "127.0.0.1";
        int port = 3306;
        String databaseName = "tanpeng";
        String dbname = "test";
        String url = String.format("jdbc:mysql://%s:%d/%s", serverName, port, databaseName);
        String username = "root";
        String password = "";

        String sql = String.format("select * from %s", dbname);

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

    }
}
