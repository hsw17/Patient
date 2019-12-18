package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/17
 * author:贺少伟(盗)
 * function:
 */
public class UserCommentListBean {

    /**
     * result : []
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;
    public static class ResultBean {

        public int releaseUserId;
        public String releaseUserNickName;
        public String releaseUserHeadPic;
        public String title;
        public String disease;
        public long adoptTime;
        public String content;

    }
}
