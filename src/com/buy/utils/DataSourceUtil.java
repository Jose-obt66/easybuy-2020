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

    //����druid����Դ����
    private static DruidDataSource druidDataSource = null;

    static {
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * ���ð���Ͱ�����Դ
     */

    private static void init() throws SQLException {
        //ʵ����DruidDataSource
        druidDataSource = new DruidDataSource();
        //�������Ե�ֵ
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
     *
     * @return ���Ӷ���
     */
    public static Connection getConn() {
         conn = null;
        //����mysql��������������
        try {
            Class.forName(DRIVER);
            //������ݿ⴦��û������״̬���򴴽�һ������
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
     * �ر����ӵķ���
     *
     * @param conn ���ݿ����Ӷ���
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
     * ִ��SQL��䣬���Խ�������ɾ���ĵĲ���������ִ�в�ѯ
     *
     * @param sql   Ԥ����� SQL ���
     * @param param Ԥ����� SQL ����еġ������������ַ�������
     * @return Ӱ�������
     */
    public int executeUpdate(String sql, Object... param) {
        int num = 0;
        /* ����SQL,ִ��SQL */
        try {
            getConn(); // �õ����ݿ�����
            pstmt = conn.prepareStatement(sql); // �õ�PreparedStatement����
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
                }
            }
            num = pstmt.executeUpdate(); // ִ��SQL���
        } catch (SQLException e) {
            e.printStackTrace(); // ����SQLException�쳣
        } finally {
            this.closeAll(conn, pstmt, null);
        }
        return num;
    }

    public ResultSet executeQuery(String preparedSql, Object... param) throws ClassNotFoundException, SQLException {
        try {
            getConn(); // �õ����ݿ�����
            pstmt = conn.prepareStatement(preparedSql);// �õ�PreparedStatement����
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]); // ΪԤ����sql���ò���
                }
            }
            rs = pstmt.executeQuery(); // ִ��SQL���
        } catch (SQLException e) {
            e.printStackTrace();// ����SQLException�쳣
        }
        return rs;
    }

    /**
     * �ͷ���Դ
     *
     * @param conn  ���ݿ�����
     * @param pstmt PreparedStatement����
     * @param rs    �����
     */
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {

        /* ���rs���գ��ر�rs */
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /* ���pstmt���գ��ر�pstmt */
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        /* ���conn���գ��ر�conn */
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
        /* ����SQL,ִ��SQL */
        try {
            getConn(); // �õ����ݿ�����
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // �õ�PreparedStatement����
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]); // ΪԤ����sql���ò���
                }
            }
          num=Long.valueOf(pstmt.executeUpdate());

            ResultSet rs = pstmt.getGeneratedKeys(); // ִ��SQL���
            if (rs.next())
                num = rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace(); // ����SQLException�쳣
        } finally {
            this.closeAll(conn, pstmt, null);
        }
        return num.intValue();
    }
}