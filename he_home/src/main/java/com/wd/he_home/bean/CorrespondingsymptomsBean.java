package com.wd.he_home.bean;


import java.util.List;

/**
 *@describe(描述)：CorrespondingsymptomsBean  对应症状
 *@data（日期）: 2019/12/16
 *@time（时间）: 9:52
 *@author（作者）: Liuhe
 **/
public class CorrespondingsymptomsBean {

    /**
     * result : [{"departmentId":2,"id":17,"name":"颈椎病"},{"departmentId":2,"id":18,"name":"滑囊炎"},{"departmentId":2,"id":19,"name":"类风湿性关节炎"},{"departmentId":2,"id":20,"name":"退行性关节病"},{"departmentId":2,"id":21,"name":"颈椎骨关节炎"},{"departmentId":2,"id":22,"name":"椎关节强硬"},{"departmentId":2,"id":23,"name":"椎间盘突出"},{"departmentId":2,"id":24,"name":"背痛"},{"departmentId":2,"id":25,"name":"骨软化"},{"departmentId":2,"id":26,"name":"骨质疏松症"},{"departmentId":2,"id":27,"name":"重症肌无力"},{"departmentId":2,"id":28,"name":"腱鞘炎"},{"departmentId":2,"id":29,"name":"腱炎"},{"departmentId":2,"id":30,"name":"痛性痉挛"},{"departmentId":2,"id":31,"name":"疝"},{"departmentId":2,"id":32,"name":"骨折"},{"departmentId":2,"id":33,"name":"脱位"},{"departmentId":2,"id":34,"name":"扭伤"},{"departmentId":2,"id":35,"name":"肌肉拉伤"}]
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
         * departmentId : 2
         * id : 17
         * name : 颈椎病
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
