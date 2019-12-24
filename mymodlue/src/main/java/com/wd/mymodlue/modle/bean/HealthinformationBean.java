package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 *@describe(描述)：HealthinformationBean  健康资讯
 *@data（日期）: 2019/12/14
 *@time（时间）: 8:57
 *@author（作者）:
 **/
public class HealthinformationBean {

    /**
     * result : [{"id":1,"name":"健康养生","sort":1},{"id":2,"name":"健康减肥","sort":2},{"id":3,"name":"健康美食","sort":3},{"id":4,"name":"健康美容","sort":4},{"id":5,"name":"慢性疾病","sort":5}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;



    public static class ResultBean {
        /**
         * id : 1
         * name : 健康养生
         * sort : 1
         */

        public String id;
        public String name;
        public String sort;
    }
}
