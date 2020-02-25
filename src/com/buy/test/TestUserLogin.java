package com.buy.test;

import com.buy.dao.user.EasybuyUserImpl;
import com.buy.entity.easybuy_user;

import java.sql.SQLException;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/25 14:01
 * @Modified By:
 */
public class TestUserLogin {
    public static void main(String[] args) throws SQLException {
        EasybuyUserImpl user=new EasybuyUserImpl();
        easybuy_user admin=user.getUserByloginByName("admin");
        System.out.println(admin.getPassword());
    }
}
