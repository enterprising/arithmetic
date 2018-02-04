package net.tanpeng.arithmetic.c3p0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by peng.tan on 18/2/1.
 */
public class C3P0Test {

    public static void main(String[] args) {
        Connection conn = JDBCUtil.getConnection();
        System.out.println("连接成功");
        //插入信息的sql语句
        String sql = "select * from skill";
        try {
            //获取PreparedStatement对象
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getRow());
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭数据库连接
            JDBCUtil.close(conn);
        }
    }
}