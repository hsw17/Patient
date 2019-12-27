package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/20
 * author:贺少伟(盗)
 * function:
 */
public class CurrentInquiryRecordBean {

    public String message;
    public String status;
    public ResultBean result;

    public static class ResultBean {


        public String imagePic;
        public String doctorName;
        public String department;
        public String jobTitle;
        public String userName;
        public String jiGuangPwd;
        public long inquiryTime;
        public int recordId;
        public int doctorId;
        public int evaluateStatus;
    }
}
