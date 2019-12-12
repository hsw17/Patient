package com.wd.mymainmodule.modle.bean;

import java.util.List;

/**
 * date:2019/12/10
 * author:贺少伟(盗)
 * function:
 */
public class UserConsumptionRecordListBean {

    /**
     * result : [{"changeNum":1,"createTime":1575980543000,"direction":1,"remark":"签到","type":1}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * changeNum : 1
         * createTime : 1575980543000
         * direction : 1
         * remark : 签到
         * type : 1
         */

        public int changeNum;
        public long createTime;
        public int direction;
        public String remark;
        public int type;
    }
}
