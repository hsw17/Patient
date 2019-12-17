package com.wd.he_home.bean;

/**
 *@describe(描述)：ConditionDetailsBean 病状详情
 *@data（日期）: 2019/12/16
 *@time（时间）: 19:36
 *@author（作者）: Liuhe
 **/
public class ConditionDetailsBean {

    /**
     * result : {"benefitTaboo":" 1．滑囊炎不是严重的疾病，通常它会在1~2周内自动痊愈，所以不用着急。 2．加强劳动保护，养成劳作后用温水洗手的习惯。 3．经常按摩关节附近的穴位和肌肉。","chineseMedicineTreatment":" 1．可用小活络片和消炎痛。 2．中药洗方薰洗如桑枝、桂枝、槐枝、柳枝、榆枝各60克，水煎外洗。 3．外敷三色敷药。","createTime":1547108512000,"diseaseCategoryId":18,"id":18,"pathology":"在关节附近的皮肤与皮下骨骼之间，或在腱与骨骼间有一种充满润滑液的软囊，可使身体组织相互间在活动时的磨擦减到最小。如果滑囊受到过重的压力，或是受到关节或关节附近组织损伤的刺激，就会发炎，形成滑囊炎。肘、拇趾底、髋、跟及肩等关节容易患滑囊炎。","symptom":"滑囊炎是一种常见的疾病，会造成囊四周肿胀、疼痛。"}
     * message : 查询成功
     * status : 0000
     */

    private ResultBean result;
    private String message;
    private String status;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

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

    public static class ResultBean {
        /**
         * benefitTaboo :  1．滑囊炎不是严重的疾病，通常它会在1~2周内自动痊愈，所以不用着急。 2．加强劳动保护，养成劳作后用温水洗手的习惯。 3．经常按摩关节附近的穴位和肌肉。
         * chineseMedicineTreatment :  1．可用小活络片和消炎痛。 2．中药洗方薰洗如桑枝、桂枝、槐枝、柳枝、榆枝各60克，水煎外洗。 3．外敷三色敷药。
         * createTime : 1547108512000
         * diseaseCategoryId : 18
         * id : 18
         * pathology : 在关节附近的皮肤与皮下骨骼之间，或在腱与骨骼间有一种充满润滑液的软囊，可使身体组织相互间在活动时的磨擦减到最小。如果滑囊受到过重的压力，或是受到关节或关节附近组织损伤的刺激，就会发炎，形成滑囊炎。肘、拇趾底、髋、跟及肩等关节容易患滑囊炎。
         * symptom : 滑囊炎是一种常见的疾病，会造成囊四周肿胀、疼痛。
         */

        private String benefitTaboo;
        private String chineseMedicineTreatment;
        private long createTime;
        private String diseaseCategoryId;
        private String id;
        private String pathology;
        private String symptom;

        public String getBenefitTaboo() {
            return benefitTaboo;
        }

        public void setBenefitTaboo(String benefitTaboo) {
            this.benefitTaboo = benefitTaboo;
        }

        public String getChineseMedicineTreatment() {
            return chineseMedicineTreatment;
        }

        public void setChineseMedicineTreatment(String chineseMedicineTreatment) {
            this.chineseMedicineTreatment = chineseMedicineTreatment;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getDiseaseCategoryId() {
            return diseaseCategoryId;
        }

        public void setDiseaseCategoryId(String diseaseCategoryId) {
            this.diseaseCategoryId = diseaseCategoryId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPathology() {
            return pathology;
        }

        public void setPathology(String pathology) {
            this.pathology = pathology;
        }

        public String getSymptom() {
            return symptom;
        }

        public void setSymptom(String symptom) {
            this.symptom = symptom;
        }
    }
}
