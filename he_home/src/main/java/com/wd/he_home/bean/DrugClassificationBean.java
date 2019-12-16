package com.wd.he_home.bean;

import java.util.List;

/**
  *@describe(描述)：DrugClassificationBean  药品分类
  *@data（日期）: 2019/12/16
  *@time（时间）: 11:53
  *@author（作者）: Liuhe
  **/
public class DrugClassificationBean {


    /**
     * result : [{"id":1,"name":"感冒用药","rank":1},{"id":3,"name":"风湿骨伤","rank":2},{"id":4,"name":"两性健康","rank":3},{"id":2,"name":"儿童用药","rank":4},{"id":5,"name":"三高用药","rank":5},{"id":6,"name":"其它药品","rank":6}]
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
         * name : 感冒用药
         * rank : 1
         */

        private String id;
        private String name;
        private String rank;

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

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }
    }
}
