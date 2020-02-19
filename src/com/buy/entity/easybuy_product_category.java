package com.buy.entity;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/18 11:27
 * @Modified By:
 */
public class easybuy_product_category {
    private int id;
    private String name;
    private int parentld;
    private int type;
    private String iconClass;

    public easybuy_product_category(int id, String name, int parentld, int type, String iconClass) {
        this.id = id;
        this.name = name;
        this.parentld = parentld;
        this.type = type;
        this.iconClass = iconClass;
    }

    public easybuy_product_category() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentld() {
        return parentld;
    }

    public void setParentld(int parentld) {
        this.parentld = parentld;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }
}
