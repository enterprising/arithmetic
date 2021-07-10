package net.tanpeng.database.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by peng.tan on 18/2/1.
 */
public class JDBCUtil {

    private static Connection conn;
    private static ComboPooledDataSource ds = new ComboPooledDataSource();

    /**
     * 这是一种方式，还一种方式是定义 xml 配置，效果是一样的
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/tanpeng_net?useUnicode=true&characterEncoding=UTF8&useServerPrepStmts=true&prepStmtCacheSqlLimit=256&cachePrepStmts=true&prepStmtCacheSize=256&rewriteBatchedStatements=true");
            ds.setUser("root");
            ds.setPassword("");
            conn = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 放回连接对象，close方法并不是关闭，而是更改该连接对象的状态为可用。
     *
     * @param conn
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}