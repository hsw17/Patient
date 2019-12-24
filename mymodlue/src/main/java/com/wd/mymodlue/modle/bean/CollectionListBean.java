package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/24
 * author:贺少伟(盗)
 * function:
 */
public class CollectionListBean {

    /**
     * result : []
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        public int id;
        public int sickCircleId;
        public int collectionNum;
        public int commentNum;
        public String title;
        public String disease;
        public long createTime;



    }
}
