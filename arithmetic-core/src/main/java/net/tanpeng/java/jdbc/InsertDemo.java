package net.tanpeng.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by peng.tan on 17/10/20.
 */
public class InsertDemo {

    public static void main(String[] args) throws SQLException {
        String serverName = "127.0.0.1";
        int port = 3306;
        String databaseName = "";
        String dbname = "";
        String url = String.format("jdbc:mysql://%s:%d/%s", serverName, port, databaseName);
        String username = "";
        String password = "";

        String sql = String.format("insert into %s(name) values(\"%s\")", dbname,"tp");
        System.out.println(sql);
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement();
        int count = 200;
        while (count-- > 0) {
            statement.executeUpdate(sql);
        }
        System.out.println("已经插入270万条数据！");
    }
}
