package com.bw.videomodule.bean;

import java.util.List;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/16
 * @Description:
 */
public class VideoCategoryListBean {

    /**
     * result : [{"id":1,"name":"儿科"},{"id":2,"name":"常识"},{"id":3,"name":"健身"},{"id":4,"name":"美容"},{"id":5,"name":"心理"},{"id":6,"name":"养生"}]
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
         * name : 儿科
         */

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
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
