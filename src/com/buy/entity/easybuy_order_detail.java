package com.buy.entity;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/18 11:21
 * @Modified By:
 */
public class easybuy_order_detail {
    private int id;
    private int orderld;
    private int productld;
    private int puantity;
    private float cost;

    public easybuy_order_detail(int id, int orderld, int productld, int puantity, float cost) {
        this.id = id;
        this.orderld = orderld;
        this.productld = productld;
        this.puantity = puantity;
        this.cost = cost;
    }

    public easybuy_order_detail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderld() {
        return orderld;
    }

    public void setOrderld(int orderld) {
        this.orderld = orderld;
    }

    public int getProductld() {
        return productld;
    }

    public void setProductld(int productld) {
        this.productld = productld;
    }

    public int getPuantity() {
        return puantity;
    }

    public void setPuantity(int puantity) {
        this.puantity = puantity;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
