package com.wd.mymodlue.modle.bean;


/*
 *@auther:胡明明
 *@Date: 2019/12/23
 *@Time:20:43
 *@Description:删除档案
 **/

public class DeleteArchivesBean {

    /**
     * message : 删除成功
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
