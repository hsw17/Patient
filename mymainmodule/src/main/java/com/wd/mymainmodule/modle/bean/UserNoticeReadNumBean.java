package com.wd.mymainmodule.modle.bean;

import java.util.List;

/**
 * date:2019/12/10
 * author:贺少伟(盗)
 * function:
 */
public class UserNoticeReadNumBean {

    /**
     * result : [{"notReadNum":0,"noticeType":1},{"notReadNum":0,"noticeType":2},{"notReadNum":1,"noticeType":3}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * notReadNum : 0
         * noticeType : 1
         */

        public int notReadNum;
        public int noticeType;
    }
}
