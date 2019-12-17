package com.wd.he_home.bean;

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

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 6
         * plateId : 1
         * releaseTime : 1569464574000
         * source : @weidu
         * thumbnail : https://jkcdn.pajk.com.cn/image/T1uRESB4dT1RCvBVdK
         * title : 灵芝、铁皮石斛有国际标准了！农残重金属等指标被明确规范
         */
        private String content;
        private String id;
        private String plateId;
        private long releaseTime;
        private String source;
        private String thumbnail;
        private String title;
        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPlateId() {
            return plateId;
        }

        public void setPlateId(String plateId) {
            this.plateId = plateId;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
