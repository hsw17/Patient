package com.bw.inquerymodel.bean;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/24
 * @Description:
 */
public class CurrentBean {

    /**
     * result : {"department":"小儿科","departmentId":5,"doctorId":86,"doctorName":"曾淑雨","evaluateStatus":1,"inquiryTime":1577105057000,"jiGuangPwd":"k2Krj2dtgiGOnuvkJBm3sUhZYUX03yrhGARknfrBdfulMrn41RLnrkXwtuWaVTaviRdD4o5BZ5u0BYhRw10wK/jVKmPXsv8YpP9U9rYAMWKE0SIjZP1Eu9OhNMc2uk7+I1N9vfPsabgIppm/TjmbhUnJsqrFUVxm/wn/eX8OfEU=","jobTitle":"主任医师","recordId":3830,"userName":"g354hT2387902884"}
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
         * department : 小儿科
         * departmentId : 5
         * doctorId : 86
         * doctorName : 曾淑雨
         * evaluateStatus : 1
         * inquiryTime : 1577105057000
         * jiGuangPwd : k2Krj2dtgiGOnuvkJBm3sUhZYUX03yrhGARknfrBdfulMrn41RLnrkXwtuWaVTaviRdD4o5BZ5u0BYhRw10wK/jVKmPXsv8YpP9U9rYAMWKE0SIjZP1Eu9OhNMc2uk7+I1N9vfPsabgIppm/TjmbhUnJsqrFUVxm/wn/eX8OfEU=
         * jobTitle : 主任医师
         * recordId : 3830
         * userName : g354hT2387902884
         */

        private String department;
        private int departmentId;
        private int doctorId;
        private String doctorName;
        private int evaluateStatus;
        private long inquiryTime;
        private String jiGuangPwd;
        private String jobTitle;
        private int recordId;
        private String userName;

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public int getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public int getEvaluateStatus() {
            return evaluateStatus;
        }

        public void setEvaluateStatus(int evaluateStatus) {
            this.evaluateStatus = evaluateStatus;
        }

        public long getInquiryTime() {
            return inquiryTime;
        }

        public void setInquiryTime(long inquiryTime) {
            this.inquiryTime = inquiryTime;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
        }

        public String getJobTitle() {
            return jobTitle;
        }

        public void setJobTitle(String jobTitle) {
            this.jobTitle = jobTitle;
        }

        public int getRecordId() {
            return recordId;
        }

        public void setRecordId(int recordId) {
            this.recordId = recordId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
