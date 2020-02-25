package com.buy.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/24 11:08
 * @Modified By:
 */
public class SercurityUtils {

    /**
     * md5加密
     *
     * @param value 要加密的值
     * @return md5加密后的值
     */
    public static String md5Hex(String value) {
        return DigestUtils.md5Hex(value);
    }

    /**
     * 3次md5操作
     * @param value
     * @return
     */
    public static String md5Hex3(String value) {
        for (int i = 0; i < 3; i++) {
            value = DigestUtils.md5Hex(value);
        }
        return value;
    }


    /**
     * sha256加密
     *
     * @param value 要加密的值
     * @return sha256加密后的值
     */
    public static String sha256Hex(String value) {
        return DigestUtils.sha256Hex(value);
    }

    public static String sha512Hex(String value) {
        return DigestUtils.sha512Hex(value);
    }

    public static void main(String[] args) {
        System.out.println(SercurityUtils.md5Hex("123456"));
    }
}
