package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/25
 * author:贺少伟(盗)
 * function:
 */
public class VideoBuyBean {


    /**
     * result : [{"createTime":1577332503000,"duration":55,"id":754,"originalUrl":"http://172.17.8.100/video/health/original/ek/ek2.mp4","title":"儿科医生雨滴","videoId":2}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * createTime : 1577332503000
         * duration : 55
         * id : 754
         * originalUrl : http://172.17.8.100/video/health/original/ek/ek2.mp4
         * title : 儿科医生雨滴
         * videoId : 2
         */

        public long createTime;
        public int duration;
        public int id;
        public String originalUrl;
        public String title;
        public int videoId;
    }
}
