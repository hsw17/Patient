package com.wd.he_bing.bean;

import java.util.List;

/**
 *@describe(描述)：PatientCircleReviewBean 病友圈评论
 *@data（日期）: 2019/12/24
 *@time（时间）: 10:01
 *@author（作者）: Liuhe
 **/
public class PatientCircleReviewBean {

    /**
     * result : [{"commentId":7759,"commentTime":1576569801000,"commentUserId":432,"content":"好的","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_4.jpg","nickName":"bh_VXCEF","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2},{"commentId":7373,"commentTime":1576115756000,"commentUserId":134,"content":"多喝水多运动","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"太振业","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1},{"commentId":7334,"commentTime":1575977898000,"commentUserId":432,"content":"好的","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_4.jpg","nickName":"bh_VXCEF","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":2}]
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
         * commentId : 7759
         * commentTime : 1576569801000
         * commentUserId : 432
         * content : 好的
         * headPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_4.jpg
         * nickName : bh_VXCEF
         * opinion : 0
         * opposeNum : 0
         * supportNum : 0
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
