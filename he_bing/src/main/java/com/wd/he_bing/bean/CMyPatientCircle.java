package com.wd.he_bing.bean;

import java.util.List;

/**
 *@describe(描述)：CMyPatientCircle  我的病友圈
 *@data（日期）: 2019/12/24
 *@time（时间）: 10:33
 *@author（作者）: Liuhe
 **/
public class CMyPatientCircle {

    /**
     * result : [{"amount":0,"collectionNum":0,"commentNum":2,"detail":"头疼的厉害","releaseTime":1575907200000,"sickCircleId":1662,"title":"骨科"}]
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
         * commentNum : 2
         * detail : 头疼的厉害
         * releaseTime : 1575907200000
         * sickCircleId : 1662
         * title : 骨科
         */

        private String amount;
        private String collectionNum;
        private String commentNum;
        private String detail;
        private long releaseTime;
        private String sickCircleId;
        private String title;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(String collectionNum) {
            this.collectionNum = collectionNum;
        }

        public String getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(String commentNum) {
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

        public String getSickCircleId() {
            return sickCircleId;
        }

        public void setSickCircleId(String sickCircleId) {
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
