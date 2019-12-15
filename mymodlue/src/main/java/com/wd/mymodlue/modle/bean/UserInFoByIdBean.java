package com.wd.mymodlue.modle.bean;

/**
 * date:2019/12/10
 * author:贺少伟(盗)
 * function:
 */
public class UserInFoByIdBean {

    /**
     * result : {"age":0,"email":"2251574132@qq.com","headPic":"http://172.17.8.100/images/health/user/head_pic/default/default_head_2.jpg","height":0,"id":437,"jiGuangPwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","nickName":"z3_DPSBA","sex":1,"userName":"x2SMLV2251574132","weight":0,"whetherBingWeChat":2}
     * message : 用户信息查询成功
     * status : 0000
     */

    public ResultBean result;
    public String message;
    public String status;

    public static class ResultBean {
        /**
         * age : 0
         * email : 2251574132@qq.com
         * headPic : http://172.17.8.100/images/health/user/head_pic/default/default_head_2.jpg
         * height : 0
         * id : 437
         * jiGuangPwd : R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=
         * nickName : z3_DPSBA
         * sex : 1
         * userName : x2SMLV2251574132
         * weight : 0
         * whetherBingWeChat : 2
         */

        public int age;
        public String email;
        public String headPic;
        public int height;
        public int id;
        public String jiGuangPwd;
        public String nickName;
        public int sex;
        public String userName;
        public int weight;
        public int whetherBingWeChat;
    }
}
