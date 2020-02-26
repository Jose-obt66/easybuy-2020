package com.buy.test;

import com.buy.dao.user.EasybuyUserImpl;
import com.buy.dao.user.IUser;
import com.buy.entity.easybuy_user;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/26 14:18
 * @Modified By:
 */
public class TestSaveUser {
    public static void main(String[] args) {
        IUser easybuyUser=new EasybuyUserImpl();
        easybuy_user user=new easybuy_user();
        user.setUserName("∆’Õ®”√ªß");
        user.setType(0);
        user.setPassword("123456");
        user.setLoginName("guess111");
        user.setSex(0);
        user.setMobile("18630715108");
        user.setIdentityCode("130921199905221010");
        user.setEmail("2094296458@qq.com");
        int id = easybuyUser.save(user);
        System.out.println(id);

    }
}
