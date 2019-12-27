package com.wd.he_bing.bean;

import java.util.List;

/**
 *@describe(描述)：CListBean 病友圈列表
 *@data（日期）: 2019/12/19
 *@time（时间）: 19:10
 *@author（作者）: Liuhe
 **/
public class CListBean {

    /**
     * result : [{"amount":0,"collectionNum":0,"commentNum":2,"detail":"骨折","releaseTime":1576512000000,"sickCircleId":1741,"title":"徐晨曦"},{"amount":0,"collectionNum":0,"commentNum":7,"detail":"7888","releaseTime":1576166400000,"sickCircleId":1665,"title":"1122"},{"amount":0,"collectionNum":0,"commentNum":34,"detail":"尴尬","releaseTime":1575734400000,"sickCircleId":1658,"title":"如果"},{"amount":0,"collectionNum":1,"commentNum":16,"detail":"4too宏观经济","releaseTime":1575561600000,"sickCircleId":1655,"title":"挂机了"},{"amount":0,"collectionNum":0,"commentNum":23,"detail":"天通苑","releaseTime":1575561600000,"sickCircleId":1651,"title":"英语"}]
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
         * detail : 骨折
         * releaseTime : 1576512000000
         * sickCircleId : 1741
         * title : 徐晨曦
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
