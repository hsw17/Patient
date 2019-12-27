package com.wd.mymodlue.modle.bean;

/**
 * date:2019/12/24
 * author:贺少伟(盗)
 * function:
 */
public class DoctorEvaluateBean {


    /**
     * result : {"content":"张梦龙爱吃粑粑","majorDegree":4,"satisfactionDegree":5}
     * message : 查询成功
     * status : 0000
     */

    public ResultBean result;
    public String message;
    public String status;

    public static class ResultBean {
        /**
         * content : 张梦龙爱吃粑粑
         * majorDegree : 4
         * satisfactionDegree : 5
         */

        public String content;
        public String giftPicUrl;
        public int majorDegree;
        public int satisfactionDegree;
    }
}
