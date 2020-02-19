package com.buy.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BaseDao {
    private String Driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/easybuy";
    private String name = "root";
    private String pwd = "123456";
    Connection conn=null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public Connection getConnection() {
        try {
            Class.forName(Driver);
            conn= DriverManager.getConnection(url,name,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
}
    public void cloesAll(){
        try {
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet getRs(String sql,Object...param){
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            if (param != null && param.length > 0) {
                for (int i = 0; i < param.length; i++){
                    ps.setObject((i + 1), param[i]);
                }
            }
            return ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getExecutUpdate(String sql,Object...param){
        try {
            conn=getConnection();
            ps=conn.prepareStatement(sql);
            if (param != null && param.length > 0) {
                for (int i = 0; i < param.length; i++) {
                    ps.setObject((i + 1), param[i]);
                }
            }
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            cloesAll();
        }
        return -1;
    }
}
