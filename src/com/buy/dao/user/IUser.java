package com.buy.dao.user;
import com.buy.dao.user.IUser;
import com.buy.entity.easybuy_user;

import java.sql.SQLException;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/25 11:24
 * @Modified By:
 */
public interface IUser {
    //��¼
    easybuy_user getUserByloginByName(String loginName) throws SQLException;
    //ע��
    int save(easybuy_user user);
}

