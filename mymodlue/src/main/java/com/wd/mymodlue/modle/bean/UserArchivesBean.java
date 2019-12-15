package com.wd.mymodlue.modle.bean;

/**
 * date:2019/12/10
 * author:贺少伟(盗)
 * function:
 */
public class UserArchivesBean {

    /**
     * result : {"diseaseBefore":"递四方速递","diseaseMain":"递四方速递","diseaseNow":"递四方速递","id":584,"picture":"http://172.17.8.100/images/health/user/archives/2019-12-10/KJSEog20191210203408.jpg,http://172.17.8.100/images/health/user/archives/2019-12-10/emobVL20191210203408.jpg","treatmentEndTime":1554048000000,"treatmentHospitalRecent":"递四方速递","treatmentProcess":"递四方速递","treatmentStartTime":1554048000000,"userId":437}
     * message : 用户档案查询成功
     * status : 0000
     */

    public ResultBean result;
    public String message;
    public String status;

    public static class ResultBean {
        /**
         * diseaseBefore : 递四方速递
         * diseaseMain : 递四方速递
         * diseaseNow : 递四方速递
         * id : 584
         * picture : http://172.17.8.100/images/health/user/archives/2019-12-10/KJSEog20191210203408.jpg,http://172.17.8.100/images/health/user/archives/2019-12-10/emobVL20191210203408.jpg
         * treatmentEndTime : 1554048000000
         * treatmentHospitalRecent : 递四方速递
         * treatmentProcess : 递四方速递
         * treatmentStartTime : 1554048000000
         * userId : 437
         */

        public String diseaseBefore;
        public String diseaseMain;
        public String diseaseNow;
        public int id;
        public String picture;
        public long treatmentEndTime;
        public String treatmentHospitalRecent;
        public String treatmentProcess;
        public long treatmentStartTime;
        public int userId;
    }
}
