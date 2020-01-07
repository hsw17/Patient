package com.wd.he_bing.bean;

/**
 * author: [Liu He]
 * data: 2019/12/28.
 * function：
 */
public class LoginBean {

    /**
     * result : {"age":0,"email":"1528374475@qq.com","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_4.jpg","height":0,"id":432,"jiGuangPwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","nickName":"bh_VXCEF","sessionId":"1577494007307432","sex":1,"userName":"dRgt6r1528374475","weight":0,"whetherBingWeChat":2}
     * message : 登录成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * age : 0
         * email : 1528374475@qq.com
         * headPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_4.jpg
         * height : 0
         * id : 432
         * jiGuangPwd : R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=
         * nickName : bh_VXCEF
         * sessionId : 1577494007307432
         * sex : 1
         * userName : dRgt6r1528374475
         * weight : 0
         * whetherBingWeChat : 2
         */

        private String age;
        private String email;
        private String headPic;
        private String height;
        private String id;
        private String jiGuangPwd;
        private String nickName;
        private String sessionId;
        private String sex;
        private String userName;
        private String weight;
        private String whetherBingWeChat;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getHeight() {
            return height;
        }

        public void setHeight(String height) {
            this.height = height;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getJiGuangPwd() {
            return jiGuangPwd;
        }

        public void setJiGuangPwd(String jiGuangPwd) {
            this.jiGuangPwd = jiGuangPwd;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getWhetherBingWeChat() {
            return whetherBingWeChat;
        }

        public void setWhetherBingWeChat(String whetherBingWeChat) {
            this.whetherBingWeChat = whetherBingWeChat;
        }
    }
}
