package com.wd.mymodlue.modle.bean;


/*
 *@auther:胡明明
 *@Date: 2019/12/21
 *@Time:9:04
 *@Description:我的病友圈
 **/

import java.util.List;

public class MySickCircleListBean {

    /**
     * result : [{"amount":0,"collectionNum":0,"commentNum":0,"detail":"111","releaseTime":1576771200000,"sickCircleId":1861,"title":"㈱"},{"amount":0,"collectionNum":0,"commentNum":5,"detail":"来次一游","releaseTime":1576598400000,"sickCircleId":1796,"title":"呵呵^_^"},{"amount":0,"collectionNum":0,"commentNum":6,"detail":"123456","releaseTime":1576598400000,"sickCircleId":1795,"title":"♥"},{"amount":0,"collectionNum":0,"commentNum":1,"detail":"给个","releaseTime":1576512000000,"sickCircleId":1790,"title":"呵呵呵呵呵呵"},{"amount":0,"collectionNum":0,"commentNum":2,"detail":"11","releaseTime":1576512000000,"sickCircleId":1789,"title":"111"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * amount : 0
         * collectionNum : 0
         * commentNum : 0
         * detail : 111
         * releaseTime : 1576771200000
         * sickCircleId : 1861
         * title : ㈱
         */

        private int amount;
        private int collectionNum;
        private int commentNum;
        private String detail;
        private long releaseTime;
        private int sickCircleId;
        private String title;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public int getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(int collectionNum) {
            this.collectionNum = collectionNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(int sickCircleId) {
            this.sickCircleId = sickCircleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
