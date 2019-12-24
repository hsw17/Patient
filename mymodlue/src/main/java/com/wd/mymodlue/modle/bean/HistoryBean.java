package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/24
 * author:贺少伟(盗)
 * function:
 */
public class HistoryBean {

    /**
     * result : [{"departmentId":0,"doctorId":156,"doctorName":"王晓","evaluateStatus":1,"imagePic":"http://172.17.8.100/images/health/doctor/image_pic/2019-12-20/RSgiFt20191220095144.jpg","inquiryTime":1577154513000,"jiGuangPwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","jobTitle":"主任","recordId":3841,"userName":"23IiRS1748624086"},{"departmentId":0,"doctorId":87,"doctorName":"李医生","evaluateStatus":1,"imagePic":"http://172.17.8.100/images/health/doctor/system_image_pic/system_image7.jpg","inquiryTime":1577149209000,"jiGuangPwd":"R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=","jobTitle":"院长","recordId":3838,"userName":"xBOEht568277818"}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * departmentId : 0
         * doctorId : 156
         * doctorName : 王晓
         * evaluateStatus : 1
         * imagePic : http://172.17.8.100/images/health/doctor/image_pic/2019-12-20/RSgiFt20191220095144.jpg
         * inquiryTime : 1577154513000
         * jiGuangPwd : R+0jdN3P4MXHPMFVe9cX5MbX5ulIXHJkfigPLKEeTBY5lUgxJWUNg0js1oGtbsKiLFL4ScqdmUbtHXIfrgQnWrwTNjf09OJLycbeJ+ka4+CV7I1eEqG8DtZPnQoCyxjoYMjO4soDl6EX9YgqaZp3DlUH4pXrYHYz58YyFkSeJEk=
         * jobTitle : 主任
         * recordId : 3841
         * userName : 23IiRS1748624086
         */

        public int departmentId;
        public int doctorId;
        public String doctorName;
        public int evaluateStatus;
        public String imagePic;
        public long inquiryTime;
        public String jiGuangPwd;
        public String jobTitle;
        public int recordId;
        public String userName;
    }
}
