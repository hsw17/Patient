package com.wd.he_home.bean;

import java.util.List;

/**
 *@describe(描述)：PopularSearchesBean   热门搜索
 *@data（日期）: 2019/12/17
 *@time（时间）: 19:35
 *@author（作者）: Liuhe
 **/
public class PopularSearchesBean {

    /**
     * result : [{"id":11,"name":"慢性胃炎"},{"id":1,"name":"头痛"},{"id":5,"name":"喉咙发炎"},{"id":6,"name":"咳嗽"},{"id":4,"name":"小儿感冒颗粒"},{"id":10,"name":"近视"},{"id":8,"name":"皮肤痒"},{"id":7,"name":"流鼻涕"},{"id":2,"name":"发烧"},{"id":3,"name":"脱发"},{"id":12,"name":"牛黄上清丸"},{"id":9,"name":"阿莫西林"}]
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
         * id : 11
         * name : 慢性胃炎
         */

        private String id;
        private String name;

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
