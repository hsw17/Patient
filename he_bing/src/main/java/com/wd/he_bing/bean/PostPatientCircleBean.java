package com.wd.he_bing.bean;

/**
 * author: [Liu He]  发布病友圈
 * data: 2019/12/25.
 * function：
 */
public class PostPatientCircleBean {
    /**
     * result : 1918
     * message : 发表成功
     * status : 0000
     */

    private int result;
    private String message;
    private String status;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

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
