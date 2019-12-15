package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/10
 * author:贺少伟(盗)
 * function:
 */
public class UserInfoCollectionListBean {

    /**
     * result : [{"createTime":1575981518000,"id":717,"infoId":2,"thumbnail":"https://jkcdn.pajk.com.cn/image/T1wFLSBCLT1RCvBVdK","title":"黄芪泡水喝，能给我们的身体带来什么变化？医生用临床经验说话"}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * createTime : 1575981518000
         * id : 717
         * infoId : 2
         * thumbnail : https://jkcdn.pajk.com.cn/image/T1wFLSBCLT1RCvBVdK
         * title : 黄芪泡水喝，能给我们的身体带来什么变化？医生用临床经验说话
         */

        public long createTime;
        public int id;
        public int infoId;
        public String thumbnail;
        public String title;
    }
}
