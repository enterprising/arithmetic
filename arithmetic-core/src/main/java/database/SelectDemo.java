package database;

import java.sql.*;

/**
 * Created by peng.tan on 17/10/20.
 */
public class SelectDemo {
    public static void main(String[] args) throws SQLException {
        String serverName = "127.0.0.1";
        int port = 3306;
        String databaseName = "";
        String dbname = "";
        String url = String.format("jdbc:mysql://%s:%d/%s", serverName, port, databaseName);
        String username = "";
        String password = "";

        String sql = String.format("select * from %s where id>%s and id<=%s", dbname,20,30);

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.last()){
            System.out.println("lenth = "+resultSet.getRow());
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getRow());
            System.out.println();
            resultSet.beforeFirst();
        }

        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

    }
}
