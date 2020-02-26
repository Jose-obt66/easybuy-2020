package com.buy.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.*;

import static com.alibaba.druid.util.FnvHash.Constants.PASSWORD;
import static sun.net.ftp.FtpDirEntry.Permission.USER;
import static sun.plugin.javascript.navig.JSType.URL;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/19 8:53
 * @Modified By:
 */
public class DataSourceUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/easybuy";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    private PreparedStatement pstmt;
    private static Connection conn=null;
    private ResultSet rs;

    //创建druid数据源对象
    private static DruidDataSource druidDataSource = null;

    static {
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 配置阿里巴巴数据源
     */

    private static void init() throws SQLException {
        //实例化DruidDataSource
        druidDataSource = new DruidDataSource();
        //设置属性的值
        druidDataSource.setDriverClassName(DRIVER);
        druidDataSource.setUrl(URL);
        //设置连接池相关属性
        druidDataSource.setInitialSize(5);//初始化连接池数量
        druidDataSource.setMaxActive(100);//最大连接数
        druidDataSource.setMinIdle(1);//最大空闲连接数
        druidDataSource.setMaxWait(1000);//连接等待时长，单位：毫秒
        druidDataSource.setFilters("stat");//设置监控
    }

    /**
     * 连接数据源的方法
     *
     * @return 连接对象
     */
    public static Connection getConn() {
         conn = null;
        //加载mysql驱动（开启服务）
        try {
            Class.forName(DRIVER);
            //如果数据库处于没有连接状态，则创建一个连接
            if (conn == null) {
                conn = druidDataSource.getConnection(USER, PASSWORD);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接的方法
     *
     * @param conn 数据库连接对象
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 执行SQL语句，可以进行增、删、改的操作，不能执行查询
     *
     * @param sql   预编译的 SQL 语句
     * @param param 预编译的 SQL 语句中的‘？’参数的字符串数组
     * @return 影响的条数
     */
    public int executeUpdate(String sql, Object... param) {
        int num = 0;
        /* 处理SQL,执行SQL */
        try {
            getConn(); // 得到数据库连接
            pstmt = conn.prepareStatement(sql); // 得到PreparedStatement对象
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
                }
            }
            num = pstmt.executeUpdate(); // 执行SQL语句
        } catch (SQLException e) {
            e.printStackTrace(); // 处理SQLException异常
        } finally {
            this.closeAll(conn, pstmt, null);
        }
        return num;
    }

    public ResultSet executeQuery(String preparedSql, Object... param) throws ClassNotFoundException, SQLException {
        try {
            getConn(); // 得到数据库连接
            pstmt = conn.prepareStatement(preparedSql);// 得到PreparedStatement对象
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // 为预编译sql设置参数
                }
            }
            rs = pstmt.executeQuery(); // 执行SQL语句
        } catch (SQLException e) {
            e.printStackTrace();// 处理SQLException异常
        }
        return rs;
    }

    /**
     * 释放资源
     *
     * @param conn  数据库连接
     * @param pstmt PreparedStatement对象
     * @param rs    结果集
     */
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

        /* 如果rs不空，关闭rs */
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /* 如果pstmt不空，关闭pstmt */
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /* 如果conn不空，关闭conn */
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int executeInsert(String sql, Object... params) {
        Long num = 0L;
        /* 处理SQL,执行SQL */
        try {
            getConn(); // 得到数据库连接
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // 得到PreparedStatement对象
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]); // 为预编译sql设置参数
                }
            }
          num=Long.valueOf(pstmt.executeUpdate());

            ResultSet rs = pstmt.getGeneratedKeys(); // 执行SQL语句
            if (rs.next())
                num = rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace(); // 处理SQLException异常
        } finally {
            this.closeAll(conn, pstmt, null);
        }
        return num.intValue();
    }
}