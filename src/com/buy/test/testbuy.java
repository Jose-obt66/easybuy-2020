package com.buy.test;

import com.buy.utils.DataSourceUtil;

import java.sql.Connection;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/19 9:36
 * @Modified By:
 */
public class testbuy {
    public static void main(String[] args) {
//        DataSourceUtil dataSourceUtil=new DataSourceUtil();
//        Connection connection=dataSourceUtil.getConn();
//        if (connection!=null){
//            System.out.println("连接成功");
//        }
//    }
        DataSourceUtil.getConn();
    }
}
