package net.tanpeng.database.jdbc;

import java.nio.charset.StandardCharsets;
import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        try {

            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            // 查询city表中所有的数据
            try (ResultSet resultSet = statement.executeQuery("select * from userinfo where uid = 11120")) {
                while (resultSet.next()) {
                    // 依次打印出查询结果中Name的字符串
                    System.out.println(resultSet.getString("uintroduction"));
                    System.out.println(new String(resultSet.getString("uintroduction").getBytes(StandardCharsets.UTF_8)));

                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        String serverName = "127.0.0.1:3306";
        String database = "spinach_kitchen";
        String url = "jdbc:mysql://" + serverName + "/" + database + "?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&useSSL=false";

        // 数据配置用户和密码
        String user = "root";
        String password = "";

        return DriverManager.getConnection(url, user, password);
    }

}
