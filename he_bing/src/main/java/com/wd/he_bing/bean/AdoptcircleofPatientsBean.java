package com.wd.he_bing.bean;
/**
 *@describe(描述)：AdoptcircleofPatientsBean  采纳病友圈优秀评论
 *@data（日期）: 2019/12/24
 *@time（时间）: 10:04
 *@author（作者）: Liuhe
 **/
public class AdoptcircleofPatientsBean {

    /**
     * message : 已有采纳的评论
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
