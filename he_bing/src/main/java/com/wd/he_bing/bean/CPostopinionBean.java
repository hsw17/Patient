package com.wd.he_bing.bean;

/**
 *@describe(描述)：CPostopinionBean  发表观点
 *@data（日期）: 2019/12/24
 *@time（时间）: 10:06
 *@author（作者）: Liuhe
 **/
public class CPostopinionBean {

    /**
     * message : 发表成功
     * status : 0000
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
