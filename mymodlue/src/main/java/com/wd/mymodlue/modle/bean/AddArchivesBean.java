package com.wd.mymodlue.modle.bean;


/*
 *@auther:胡明明
 *@Date: 2019/12/23
 *@Time:20:36
 *@Description:添加用户档案
 **/

public class AddArchivesBean {

    /**
     * message : 您已添加了档案，不可重复添加
     * status : 8001
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
