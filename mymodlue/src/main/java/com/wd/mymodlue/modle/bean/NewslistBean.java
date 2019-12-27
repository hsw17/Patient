package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 *@describe(描述)：NewslistBean  咨询列表
 *@data（日期）: 2019/12/15
 *@time（时间）: 18:53
 *@author（作者）: Liuhe
 **/
public class NewslistBean {


    /**
     * result : [{"id":6,"plateId":1,"releaseTime":1569464574000,"source":"@weidu","thumbnail":"https://jkcdn.pajk.com.cn/image/T1uRESB4dT1RCvBVdK","title":"灵芝、铁皮石斛有国际标准了！农残重金属等指标被明确规范"},{"id":7,"plateId":1,"releaseTime":1569464574000,"source":"@weidu","thumbnail":"https://jkcdn.pajk.com.cn/image/T1EiDABjb_1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1tPVABCb_1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1HzEkBvE_1RCvBVdK","title":"姜的功效有哪些？专家解密老姜、嫩姜营养差异！"},{"id":8,"plateId":1,"releaseTime":1569464574000,"source":"@weidu","thumbnail":"https://jkcdn.pajk.com.cn/image/T1kjdOBQJT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1U1EOBKD_1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1.1JOBXZ_1RCvBVdK","title":"为什么献血无偿，用血却要收费？真相来了！"},{"id":9,"plateId":1,"releaseTime":1569464574000,"source":"@weidu","thumbnail":"https://jkcdn.pajk.com.cn/image/T1dQWOB7Ev1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1g1JOB7LT1RCvBVdK;https://jkcdn.pajk.com.cn/image/T1jf_OBKE_1RCvBVdK","title":"决明子泡水喝有什么功效？这4个作用，还有很多人不清楚"},{"id":10,"plateId":1,"releaseTime":1569464574000,"source":"@weidu","thumbnail":"https://jkcdn.pajk.com.cn/image/T15fLOBCKv1RCvBVdK","title":"肠道微生物通过其代谢物丙酸盐对血脑屏障起保护作用"}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;


    public static class ResultBean {
        /**
         * id : 6
         * plateId : 1
         * releaseTime : 1569464574000
         * source : @weidu
         * thumbnail : https://jkcdn.pajk.com.cn/image/T1uRESB4dT1RCvBVdK
         * title : 灵芝、铁皮石斛有国际标准了！农残重金属等指标被明确规范
         */
        public String content;
        public String id;
        public String plateId;
        public long releaseTime;
        public String source;
        public String thumbnail;
        public String title;

    }
}
