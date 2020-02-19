package com.buy.entity;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/18 11:17
 * @Modified By:
 */
public class easybuy_order {
    private int id;
    private int userld;
    private String loginName;
    private String userAddress;
    private String datetime;
    private float cost;
    private String serialNumber;

    public easybuy_order(int id, int userld, String loginName, String userAddress, String datetime, float cost, String serialNumber) {
        this.id = id;
        this.userld = userld;
        this.loginName = loginName;
        this.userAddress = userAddress;
        this.datetime = datetime;
        this.cost = cost;
        this.serialNumber = serialNumber;
    }

    public easybuy_order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserld() {
        return userld;
    }

    public void setUserld(int userld) {
        this.userld = userld;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
