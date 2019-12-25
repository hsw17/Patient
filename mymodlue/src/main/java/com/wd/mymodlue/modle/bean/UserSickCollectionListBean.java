package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/10
 * author:贺少伟(盗)
 * function:
 */
public class UserSickCollectionListBean {

    /**
     * result : [{"collectionNum":0,"commentNum":0,"createTime":1575981740000,"id":820,"sickCircleId":1}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * collectionNum : 0
         * commentNum : 0
         * createTime : 1575981740000
         * id : 820
         * sickCircleId : 1
         */

        public int collectionNum;
        public int commentNum;
        public long createTime;
        public String title;
        public String disease;
        public int id;
        public int sickCircleId;
    }
}
