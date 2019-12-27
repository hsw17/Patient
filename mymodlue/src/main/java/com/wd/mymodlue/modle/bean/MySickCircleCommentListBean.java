package com.wd.mymodlue.modle.bean;


/*
 *@auther:胡明明
 *@Date: 2019/12/21
 *@Time:9:17
 *@Description:查询我的病友圈帖子的评论列表
 **/

import java.util.List;

public class MySickCircleCommentListBean {

    /**
     * result : {"otherSickCircleCommentList":[{"commentId":8028,"commentTime":1576828957000,"commentUserId":157,"content":"刚刚好","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"小明","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1},{"commentId":7872,"commentTime":1576737579000,"commentUserId":158,"content":"哈哈哈","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"董先生","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1},{"commentId":7826,"commentTime":1576677986000,"commentUserId":156,"content":"游你妈","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"王晓","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1},{"commentId":7823,"commentTime":1576677791000,"commentUserId":155,"content":"哈哈","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"任二","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1},{"commentId":7820,"commentTime":1576669777000,"commentUserId":154,"content":"梦游","headPic":"http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg","nickName":"任二","opinion":0,"opposeNum":0,"supportNum":0,"whetherDoctor":1}]}
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
             * commentId : 8028
             * commentTime : 1576828957000
             * commentUserId : 157
             * content : 刚刚好
             * headPic : http://172.17.8.100/images/health/doctor/image_pic/default/default_image_pic.jpg
             * nickName : 小明
             * opinion : 0
             * opposeNum : 0
             * supportNum : 0
             * whetherDoctor : 1
             */

            private int commentId;
            private long commentTime;
            private int commentUserId;
            private String content;
            private String headPic;
            private String nickName;
            private int opinion;
            private int opposeNum;
            private int supportNum;
            private int whetherDoctor;

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }

            public long getCommentTime() {
                return commentTime;
            }

            public void setCommentTime(long commentTime) {
                this.commentTime = commentTime;
            }

            public int getCommentUserId() {
                return commentUserId;
            }

            public void setCommentUserId(int commentUserId) {
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

            public int getOpinion() {
                return opinion;
            }

            public void setOpinion(int opinion) {
                this.opinion = opinion;
            }

            public int getOpposeNum() {
                return opposeNum;
            }

            public void setOpposeNum(int opposeNum) {
                this.opposeNum = opposeNum;
            }

            public int getSupportNum() {
                return supportNum;
            }

            public void setSupportNum(int supportNum) {
                this.supportNum = supportNum;
            }

            public int getWhetherDoctor() {
                return whetherDoctor;
            }

            public void setWhetherDoctor(int whetherDoctor) {
                this.whetherDoctor = whetherDoctor;
            }
        }
    }
}
