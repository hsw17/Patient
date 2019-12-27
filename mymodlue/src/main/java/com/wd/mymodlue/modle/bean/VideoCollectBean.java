package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/25
 * author:贺少伟(盗)
 * function:
 */
public class VideoCollectBean {
    public String message;
    public String status;
    public List<ResultBean> result;
    public static class ResultBean {

        public int id;
        public int videoId;
        public int price;
        public int duration;
        public int whetherBuy;
        public int buyNum;
        public String original;
        public String shearUrl;
        public String title;
        public long createTime;
    }
}
