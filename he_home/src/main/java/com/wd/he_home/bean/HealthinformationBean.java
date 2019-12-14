package com.wd.he_home.bean;

import java.util.List;

/**
 *@describe(描述)：HealthinformationBean  健康资讯
 *@data（日期）: 2019/12/14
 *@time（时间）: 8:57
 *@author（作者）: Liuhe
 **/
public class HealthinformationBean {

    /**
     * result : [{"id":1,"name":"健康养生","sort":1},{"id":2,"name":"健康减肥","sort":2},{"id":3,"name":"健康美食","sort":3},{"id":4,"name":"健康美容","sort":4},{"id":5,"name":"慢性疾病","sort":5}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1
         * name : 健康养生
         * sort : 1
         */

        private String id;
        private String name;
        private String sort;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }
    }
}
