package com.buy.utils;

import java.io.Serializable;

/**
 * @Author: GmSz
 * @Description:
 * @Date:Created in 2020/2/24 9:44
 * @Modified By:
 */
public class ReturnResult implements Serializable {
    private int status;
    private Object data;
    private String message="�����ɹ�";

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    /**
     * ���سɹ�״̬
     * @param obj
     */
    public ReturnResult returnSuccess(Object obj){
        this.status=Constants.ReturnResult.SUCCESS;
        this.data=obj;
        return this;
    }
    /**
     * ����Ĭ�ϳɹ�״̬
     */
    public ReturnResult returnSuccess(){
        this.status=Constants.ReturnResult.SUCCESS;
        return this;
    }
    /**
     * ����ʧ��״̬
     * @param message
     */
    public ReturnResult returnFail(String message){
        this.status=Constants.ReturnResult.FAIL;
        this.message=message;
        return this;
    }

    public ReturnResult(String message, int status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public ReturnResult(Object data) {
        this.status=Constants.ReturnResult.SUCCESS;
        this.data = data;
    }

    public ReturnResult(){

    }
}
