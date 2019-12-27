package com.wd.he_bing.bean;

/**
 *@describe(描述)：CPatientCircleDetailsBean  病友圈详情
 *@data（日期）: 2019/12/19
 *@time（时间）: 18:40
 *@author（作者）: Liuhe
 **/
public class CPatientCircleDetailsBean {

    /**
     * result : {"adoptComment":"这是我的建议内容","adoptCommentId":1645,"adoptFlag":1,"adoptHeadPic":"http://172.17.8.100/images/health/user/head_pic/2019-11-26/hf0hPx20191126145259.jpg","adoptNickName":"梦","adoptTime":1575907200000,"amount":0,"authorUserId":264,"collectionFlag":2,"collectionNum":1,"commentNum":3,"department":"骨科","departmentId":2,"detail":"奖学金","disease":"类风湿性关节炎","picture":"","sickCircleId":1645,"title":"就直接","treatmentEndTime":1575475200000,"treatmentHospital":"包子吧","treatmentProcess":"白血病","treatmentStartTime":1575475200000}
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
        /**
         * adoptComment : 这是我的建议内容
         * adoptCommentId : 1645
         * adoptFlag : 1
         * adoptHeadPic : http://172.17.8.100/images/health/user/head_pic/2019-11-26/hf0hPx20191126145259.jpg
         * adoptNickName : 梦
         * adoptTime : 1575907200000
         * amount : 0
         * authorUserId : 264
         * collectionFlag : 2
         * collectionNum : 1
         * commentNum : 3
         * department : 骨科
         * departmentId : 2
         * detail : 奖学金
         * disease : 类风湿性关节炎
         * picture : 
         * sickCircleId : 1645
         * title : 就直接
         * treatmentEndTime : 1575475200000
         * treatmentHospital : 包子吧
         * treatmentProcess : 白血病
         * treatmentStartTime : 1575475200000
         */

        private String adoptComment;
        private String adoptCommentId;
        private String adoptFlag;
        private String adoptHeadPic;
        private String adoptNickName;
        private long adoptTime;
        private String amount;
        private String authorUserId;
        private String collectionFlag;
        private String collectionNum;
        private String commentNum;
        private String department;
        private String departmentId;
        private String detail;
        private String disease;
        private String picture;
        private String sickCircleId;
        private String title;
        private long treatmentEndTime;
        private String treatmentHospital;
        private String treatmentProcess;
        private long treatmentStartTime;

        public String getAdoptComment() {
            return adoptComment;
        }

        public void setAdoptComment(String adoptComment) {
            this.adoptComment = adoptComment;
        }

        public String getAdoptCommentId() {
            return adoptCommentId;
        }

        public void setAdoptCommentId(String adoptCommentId) {
            this.adoptCommentId = adoptCommentId;
        }

        public String getAdoptFlag() {
            return adoptFlag;
        }

        public void setAdoptFlag(String adoptFlag) {
            this.adoptFlag = adoptFlag;
        }

        public String getAdoptHeadPic() {
            return adoptHeadPic;
        }

        public void setAdoptHeadPic(String adoptHeadPic) {
            this.adoptHeadPic = adoptHeadPic;
        }

        public String getAdoptNickName() {
            return adoptNickName;
        }

        public void setAdoptNickName(String adoptNickName) {
            this.adoptNickName = adoptNickName;
        }

        public long getAdoptTime() {
            return adoptTime;
        }

        public void setAdoptTime(long adoptTime) {
            this.adoptTime = adoptTime;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getAuthorUserId() {
            return authorUserId;
        }

        public void setAuthorUserId(String authorUserId) {
            this.authorUserId = authorUserId;
        }

        public String getCollectionFlag() {
            return collectionFlag;
        }

        public void setCollectionFlag(String collectionFlag) {
            this.collectionFlag = collectionFlag;
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

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getDisease() {
            return disease;
        }

        public void setDisease(String disease) {
            this.disease = disease;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
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

        public long getTreatmentEndTime() {
            return treatmentEndTime;
        }

        public void setTreatmentEndTime(long treatmentEndTime) {
            this.treatmentEndTime = treatmentEndTime;
        }

        public String getTreatmentHospital() {
            return treatmentHospital;
        }

        public void setTreatmentHospital(String treatmentHospital) {
            this.treatmentHospital = treatmentHospital;
        }

        public String getTreatmentProcess() {
            return treatmentProcess;
        }

        public void setTreatmentProcess(String treatmentProcess) {
            this.treatmentProcess = treatmentProcess;
        }

        public long getTreatmentStartTime() {
            return treatmentStartTime;
        }

        public void setTreatmentStartTime(long treatmentStartTime) {
            this.treatmentStartTime = treatmentStartTime;
        }
    }
}
