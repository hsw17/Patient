package com.wd.he_home.bean;

import java.util.List;

/**
 * author: [Liu He] 医生列表
 * data: 2019/12/20.
 * function：
 */
public class DoctorlistBean {

    /**
     * result : [{"badNum":0,"doctorId":148,"doctorName":"夏天","imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image2.jpg","inauguralHospital":"协和大学","jobTitle":"主任","praise":"0.00%","praiseNum":0,"serverNum":0,"servicePrice":500},{"badNum":0,"doctorId":186,"doctorName":"??","imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image5.jpg","inauguralHospital":"????????","jobTitle":"主任医师","praise":"0.00%","praiseNum":0,"serverNum":0,"servicePrice":500},{"badNum":0,"doctorId":184,"doctorName":"王可欣","imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image3.jpg","inauguralHospital":"清华大学附属医院","jobTitle":"主任医师","praise":"0.00%","praiseNum":0,"serverNum":0,"servicePrice":500},{"badNum":0,"doctorId":142,"doctorName":"xt","imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image3.jpg","inauguralHospital":"清华大学附属医院","jobTitle":"主治医师","praise":"0.00%","praiseNum":0,"serverNum":0,"servicePrice":500},{"badNum":0,"doctorId":178,"doctorName":"刘恒祥","imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image4.jpg","inauguralHospital":"清华大学附属医院","jobTitle":"主任","praise":"0.00%","praiseNum":0,"serverNum":2,"servicePrice":500}]
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
         * badNum : 0
         * doctorId : 148
         * doctorName : 夏天
         * imagePic : http://172.17.8.100/images/health/doctor/system_image_pic/system_image2.jpg
         * inauguralHospital : 协和大学
         * jobTitle : 主任
         * praise : 0.00%
         * praiseNum : 0
         * serverNum : 0
         * servicePrice : 500
         */

        private String badNum;
        private String doctorId;
        private String doctorName;
        private String imagePic;
        private String inauguralHospital;
        private String jobTitle;
        private String praise;
        private String praiseNum;
        private String serverNum;
        private String servicePrice;

        public String getBadNum() {
            return badNum;
        }

        public void setBadNum(String badNum) {
            this.badNum = badNum;
        }

        public String getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(String doctorId) {
            this.doctorId = doctorId;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getImagePic() {
            return imagePic;
        }

        public void setImagePic(String imagePic) {
            this.imagePic = imagePic;
        }

        public String getInauguralHospital() {
            return inauguralHospital;
        }

        public void setInauguralHospital(String inauguralHospital) {
            this.inauguralHospital = inauguralHospital;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public String getPraise() {
            return praise;
        }

        public void setPraise(String praise) {
            this.praise = praise;
        }

        public String getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(String praiseNum) {
            this.praiseNum = praiseNum;
        }

        public String getServerNum() {
            return serverNum;
        }

        public void setServerNum(String serverNum) {
            this.serverNum = serverNum;
        }

        public String getServicePrice() {
            return servicePrice;
        }

        public void setServicePrice(String servicePrice) {
            this.servicePrice = servicePrice;
        }
    }
}