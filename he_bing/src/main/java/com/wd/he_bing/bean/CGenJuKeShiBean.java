package com.wd.he_bing.bean;

import java.util.List;

/**
 * author: [Liu He]
 * data: 2019/12/26.
 * function：
 */
public class CGenJuKeShiBean {

    /**
     * result : [{"departmentId":6,"id":158,"name":"喉炎"},{"departmentId":6,"id":159,"name":"急性扁桃体炎"},{"departmentId":6,"id":160,"name":"咽炎"},{"departmentId":6,"id":161,"name":"萎缩性鼻炎"},{"departmentId":6,"id":162,"name":"慢性鼻炎"},{"departmentId":6,"id":163,"name":"急性鼻炎"},{"departmentId":6,"id":164,"name":"鼻出血"},{"departmentId":6,"id":165,"name":"鼻息肉"},{"departmentId":6,"id":166,"name":"鼻窦炎"},{"departmentId":6,"id":167,"name":"过敏性鼻炎"},{"departmentId":6,"id":168,"name":"美尼尔氏症"},{"departmentId":6,"id":169,"name":"慢性中耳炎"},{"departmentId":6,"id":170,"name":"急性中耳炎"},{"departmentId":6,"id":171,"name":"外耳道感染"}]
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
         * departmentId : 6
         * id : 158
         * name : 喉炎
         */

        private String departmentId;
        private String id;
        private String name;

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

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
    }
}
