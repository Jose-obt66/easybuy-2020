package com.buy.service.user;

import com.buy.dao.user.EasybuyUserImpl;
import com.buy.dao.user.IUser;
import com.buy.entity.easybuy_user;

import java.sql.SQLException;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/25 14:15
 * @Modified By:
 */
public class UserServiceImpl implements IUserService{
    IUser uDao=new EasybuyUserImpl();
    @Override
    public easybuy_user getUserByName(String loginName) throws SQLException {
        return uDao.getUserByloginByName(loginName);
    }

    @Override
    public boolean save(easybuy_user user) {

        return uDao.save(user)>0?true:false;
    }
}
