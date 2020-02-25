package com.buy.service.user;

import com.buy.entity.easybuy_user;

import java.sql.SQLException;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/25 14:14
 * @Modified By:
 */
public interface IUserService {
    easybuy_user getUserByName(String loginName) throws SQLException;
}
