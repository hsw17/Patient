package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/10
 * author:贺少伟(盗)
 * function:
 */
public class SystemNoticeListBean {

    /**
     * result : [{"content":"恭喜您成为维度健康用户，快去体验它带来的便捷已经它强大的功能吧!","createTime":1575977336000,"id":332856}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * content : 恭喜您成为维度健康用户，快去体验它带来的便捷已经它强大的功能吧!
         * createTime : 1575977336000
         * id : 332856
         */

        public String content;
        public long createTime;
        public int id;
    }
}
