package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/10
 * author:贺少伟(盗)
 * function:
 */
public class CurrencyNoticeListBean {

    /**
     * result : [{"content":"您通过领取签到奖励获得了1H币","createTime":1575980543000,"id":332881},{"content":"恭喜您成功注册维度健康，注册奖励已发放到您的钱包，快去查看吧！","createTime":1575977336000,"id":332857}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * content : 您通过领取签到奖励获得了1H币
         * createTime : 1575980543000
         * id : 332881
         */

        public String content;
        public long createTime;
        public int id;
    }
}
