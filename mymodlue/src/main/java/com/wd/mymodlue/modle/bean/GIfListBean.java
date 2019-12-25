package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/25
 * author:贺少伟(盗)
 * function:
 */
public class GIfListBean {


    /**
     * result : [{"id":1001,"meaning":"鲜花是一种认可","name":"鲜花","pic":"http://172.17.8.100/images/health/gift/gift1.jpg","worth":20},{"id":1002,"meaning":"证书是一种象征","name":"证书","pic":"http://172.17.8.100/images/health/gift/gift2.jpg","worth":50},{"id":1003,"meaning":"奖杯是一种荣誉","name":"奖杯","pic":"http://172.17.8.100/images/health/gift/gift3.jpg","worth":100}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * id : 1001
         * meaning : 鲜花是一种认可
         * name : 鲜花
         * pic : http://172.17.8.100/images/health/gift/gift1.jpg
         * worth : 20
         */

        public int id;
        public String meaning;
        public String name;
        public String pic;
        public int worth;
    }
}
