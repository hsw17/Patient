package com.wd.he_bing.bean;

import java.util.List;

/**
 * author: [Liu He] 病友圈帖子
 * data: 2019/12/24.
 * function：
 */
public class PatientCirclePostsBean {

    /**
     * result : {"otherSickCircleCommentList":[{"commentId":2,"commentTime":1554693644000,"commentUserId":1,"content":"可以吃点止痛药","headPic":"http://172.17.8.100/images/health/user/head_pic/2019-07-26/20190726142345.png","nickName":"下雨吧","opinion":0,"opposeNum":1,"supportNum":2,"whetherDoctor":2},{"commentId":1,"commentTime":1552377518000,"commentUserId":2,"content":"请问","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_3.jpg","nickName":"Tu_EHSDN","opinion":0,"opposeNum":3,"supportNum":4,"whetherDoctor":2}]}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
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

    public static class ResultBean {
        private List<OtherSickCircleCommentListBean> otherSickCircleCommentList;

        public List<OtherSickCircleCommentListBean> getOtherSickCircleCommentList() {
            return otherSickCircleCommentList;
        }

        public void setOtherSickCircleCommentList(List<OtherSickCircleCommentListBean> otherSickCircleCommentList) {
            this.otherSickCircleCommentList = otherSickCircleCommentList;
        }

        public static class OtherSickCircleCommentListBean {
            /**
             * commentId : 2
             * commentTime : 1554693644000
             * commentUserId : 1
             * content : 可以吃点止痛药
             * headPic : http://172.17.8.100/images/health/user/head_pic/2019-07-26/20190726142345.png
             * nickName : 下雨吧
             * opinion : 0
             * opposeNum : 1
             * supportNum : 2
             * whetherDoctor : 2
             */

            private String commentId;
            private long commentTime;
            private String commentUserId;
            private String content;
            private String headPic;
            private String nickName;
            private String opinion;
            private String opposeNum;
            private String supportNum;
            private String whetherDoctor;

            public String getCommentId() {
                return commentId;
            }

            public void setCommentId(String commentId) {
                this.commentId = commentId;
            }

            public long getCommentTime() {
                return commentTime;
            }

            public void setCommentTime(long commentTime) {
                this.commentTime = commentTime;
            }

            public String getCommentUserId() {
                return commentUserId;
            }

            public void setCommentUserId(String commentUserId) {
                this.commentUserId = commentUserId;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getHeadPic() {
                return headPic;
            }

            public void setHeadPic(String headPic) {
                this.headPic = headPic;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getOpinion() {
                return opinion;
            }

            public void setOpinion(String opinion) {
                this.opinion = opinion;
            }

            public String getOpposeNum() {
                return opposeNum;
            }

            public void setOpposeNum(String opposeNum) {
                this.opposeNum = opposeNum;
            }

            public String getSupportNum() {
                return supportNum;
            }

            public void setSupportNum(String supportNum) {
                this.supportNum = supportNum;
            }

            public String getWhetherDoctor() {
                return whetherDoctor;
            }

            public void setWhetherDoctor(String whetherDoctor) {
                this.whetherDoctor = whetherDoctor;
            }
        }
    }
}
