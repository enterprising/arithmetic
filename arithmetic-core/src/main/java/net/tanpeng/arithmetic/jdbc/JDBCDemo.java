package net.tanpeng.arithmetic.jdbc;

import java.sql.*;

public class JDBCDemo {

    public static void main(String[] args) {
        try {

            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            // 查询city表中所有的数据
            try (ResultSet resultSet = statement.executeQuery("select * from gzs_shop_a")) {
                while (resultSet.next()) {
                    // 依次打印出查询结果中Name的字符串
                    System.out.println(resultSet.getString("id"));
                }
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        String serverName = "";
        String database = "";
        String url = "jdbc:mysql://" + serverName + "/" + database;

        // 数据配置用户和密码
        String user = "";
        String password = "";

        return DriverManager.getConnection(url, user, password);
    }

}
