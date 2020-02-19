package com.buy.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    private static final String URL="jdbc:mysql://localhost:3306/easybuy";
    private static final String USER="root";
    private static final String PASSWORD="123456";
    private static final String DRIVER="com.mysql.jdbc.Driver";

    //创建druid数据源对象
    private static DruidDataSource druidDataSource = null;

    static {
        try{
            init();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * 配置阿里巴巴数据源
     */

    public static void init() throws SQLException {
        //实例化druid数据源对象
        druidDataSource = new DruidDataSource();
        //设置druid数据源对象的属性
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
     * @return 连接对象
     */
    public static Connection getConn(){
        Connection conn=null;
        try {
            Class.forName(DRIVER);
            //如果数据库处于没有连接状态，则创建一个连接
            if (conn == null) {
                conn = druidDataSource.getConnection(USER,PASSWORD);
                System.out.println("数据库连接成功。");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
        //加载mysql驱动（开启服务）
