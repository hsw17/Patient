package com.wd.mymodlue.modle.bean;

import java.util.List;

/**
 * date:2019/12/10
 * author:贺少伟(盗)
 * function:
 */
public class UserTaskListBean {

    /**
     * result : [{"id":1001,"reward":1,"taskName":"签到","taskType":1,"whetherFinish":1,"whetherReceive":1},{"id":1002,"reward":10,"taskName":"每日病友圈首评","taskType":1,"whetherFinish":2,"whetherReceive":3},{"id":1003,"reward":10,"taskName":"每日首发病友圈","taskType":1,"whetherFinish":2,"whetherReceive":3},{"id":1004,"reward":30,"taskName":"完善档案","taskType":2,"whetherFinish":2,"whetherReceive":3},{"id":1005,"reward":10,"taskName":"参与健康测评","taskType":2,"whetherFinish":2,"whetherReceive":3},{"id":1006,"reward":20,"taskName":"绑定身份证","taskType":2,"whetherFinish":2,"whetherReceive":3},{"id":1007,"reward":20,"taskName":"绑定银行卡","taskType":2,"whetherFinish":2,"whetherReceive":3}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> result;

    public static class ResultBean {
        /**
         * id : 1001
         * reward : 1
         * taskName : 签到
         * taskType : 1
         * whetherFinish : 1
         * whetherReceive : 1
         */

        public int id;
        public int reward;
        public String taskName;
        public int taskType;
        public int whetherFinish;
        public int whetherReceive;
    }
}
