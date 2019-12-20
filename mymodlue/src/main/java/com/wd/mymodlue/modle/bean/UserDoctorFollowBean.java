package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/19
 * author:贺少伟(盗)
 * function:
 */
public class UserDoctorFollowBean {

    /**
     * result : []
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;
    public static class ResultBean {
        public int id;
        public int doctorId;
        public int departmentId;
        public int praiseNum;
        public int badNum;
        public int number;
        public String name;
        public String imagePic;
        public String jobTitle;
        public String inauguralHospital;
        public String departmentName;
    }
}
