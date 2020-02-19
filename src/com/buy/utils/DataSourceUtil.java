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

    //����druid����Դ����
    private static DruidDataSource druidDataSource = null;

    static {
        try{
            init();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * ���ð���Ͱ�����Դ
     */

    public static void init() throws SQLException {
        //ʵ����druid����Դ����
        druidDataSource = new DruidDataSource();
        //����druid����Դ���������
        druidDataSource.setDriverClassName(DRIVER);
        druidDataSource.setUrl(URL);
        //�������ӳ��������
        druidDataSource.setInitialSize(5);//��ʼ�����ӳ�����
        druidDataSource.setMaxActive(100);//���������
        druidDataSource.setMinIdle(1);//������������
        druidDataSource.setMaxWait(1000);//���ӵȴ�ʱ������λ������
        druidDataSource.setFilters("stat");//���ü��


    }

    /**
     * ��������Դ�ķ���
     * @return ���Ӷ���
     */
    public static Connection getConn(){
        Connection conn=null;
        try {
            Class.forName(DRIVER);
            //������ݿ⴦��û������״̬���򴴽�һ������
            if (conn == null) {
                conn = druidDataSource.getConnection(USER,PASSWORD);
                System.out.println("���ݿ����ӳɹ���");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
        //����mysql��������������
