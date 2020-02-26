package com.buy.dao.user;

import com.buy.entity.easybuy_user;
import com.buy.utils.DataSourceUtil;
import com.buy.utils.EmptyUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/25 11:26
 * @Modified By:
 */
public class EasybuyUserImpl extends DataSourceUtil implements IUser {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    public easybuy_user TableClass(ResultSet rs) throws SQLException {

        easybuy_user user = new easybuy_user();
        user.setEmail(rs.getString("email"));
        user.setId(rs.getInt("id"));
        user.setIdentityCode(rs.getString("identitycode"));
        user.setLoginName(rs.getString("loginName"));
        user.setUserName(rs.getString("userName"));
        user.setMobile(rs.getString("mobile"));
        user.setPassword(rs.getString("password"));
        user.setSex(rs.getInt("sex"));
        user.setType(rs.getInt("type"));
        return user;
    }


    @Override
    public easybuy_user getUserByloginByName(String loginName) throws SQLException {
        easybuy_user user = null;

        //编写sql语句
//        StringBuffer sql=new StringBuffer("select * from easybuy_user where 1=1");
        String sql_1 = "select * from easybuy_user where 1=1 and loginName='" + loginName + "'";
        //判断用户名是否为空
//        if (!EmptyUtils.isEmpty(loginName)){
//            sql.append(" and loginName='?'");
//
//        }
        //执行sql
        conn = getConn();
        pstmt = conn.prepareStatement(sql_1);
//       pstmt.setObject(1,loginName);

        rs = pstmt.executeQuery();

        //执行sql
        //conn=getConn();
        //pstmt=conn.prepareStatement(sql,toString());
        //pstmt.setObject(1,loginName);
        //rs=pstmt.executeQuery();

//        this.executeQuery(sql,toString(),loginName)

        //处理结果集
        while (rs.next()) {
            user = TableClass(rs);
        }
        return user;
    }

    @Override
    public int save(easybuy_user user) {
        int num = 0;
        try {
            StringBuffer sql = new StringBuffer("insert into easybuy_user");
            sql.append("loginName,userName,password,sex,indentityCode,email,mobile,type");
            sql.append("values(?,?,?,?,?,?,?,?)");

//            conn=DataSourceUtil.getConn();
//            pstmt=conn.prepareStatement(sql,toString());
//            pstmt.setObject(1,user.getLoginName());
//            pstmt.setObject(2,user.getUserName());
//            pstmt.setObject(3,user.getPassword());
//            pstmt.setObject(4,user.getSex());
//            pstmt.setObject(5,user.getIdentityCode());
//            pstmt.setObject(6,user.getEmail());
//            pstmt.setObject(7,user.getMobile());
//            pstmt.setObject(8,user.getType());
//
//          num=pstmt.executeUpdate();
            this.executeInsert(sql.toString(),user.getLoginName(),user.getUserName(),user.getPassword(),
                    user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getType());
            user.setId(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }
}
