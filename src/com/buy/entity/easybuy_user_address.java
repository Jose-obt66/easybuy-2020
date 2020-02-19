package com.buy.entity;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/18 11:33
 * @Modified By:
 */
public class easybuy_user_address {
    private int id;
    private int userld;
    private String address;
    private String createTime;
    private int isDefault;
    private String remark;

    public easybuy_user_address(int id, int userld, String address, String createTime, int isDefault, String remark) {
        this.id = id;
        this.userld = userld;
        this.address = address;
        this.createTime = createTime;
        this.isDefault = isDefault;
        this.remark = remark;
    }

    public easybuy_user_address() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
