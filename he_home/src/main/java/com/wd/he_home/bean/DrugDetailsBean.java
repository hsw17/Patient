package com.wd.he_home.bean;

/**
 *@describe(描述)：DrugDetailsBean  药品详情
 *@data（日期）: 2019/12/16
 *@time（时间）: 20:27
 *@author（作者）: Liuhe
 **/
public class DrugDetailsBean {

    /**
     * result : {"approvalNumber":" 国药准字Z20030095 ","component":" 蒲公英、苦地丁、板蓝根、黄芩。 ","createTime":1547709514000,"drugsCategoryId":1,"effect":" 清热解毒，消肿利咽。用于疖肿、腮腺炎、咽炎、扁桃体炎。 ","id":5,"mindMatter":" 尚不明确。 ","name":" [济川]蒲地蓝消炎口服液 ","packing":" 10mlx10支 ","picture":"https://imgq.ddky.com/c/product/500578/big/z_1.jpg?t=9898&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100","shape":" 本品为棕红色至深棕色的液体；气微香，味甜、微苦。 ","sideEffects":" 尚不明确。 ","storage":" 密封。 ","taboo":" 尚不明确。 ","usage":" 口服。一次10ml，一日3次，小儿酌减。如有沉淀，摇匀后服用。 "}
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
         * approvalNumber :  国药准字Z20030095 
         * component :  蒲公英、苦地丁、板蓝根、黄芩。 
         * createTime : 1547709514000
         * drugsCategoryId : 1
         * effect :  清热解毒，消肿利咽。用于疖肿、腮腺炎、咽炎、扁桃体炎。 
         * id : 5
         * mindMatter :  尚不明确。 
         * name :  [济川]蒲地蓝消炎口服液 
         * packing :  10mlx10支 
         * picture : https://imgq.ddky.com/c/product/500578/big/z_1.jpg?t=9898&watermark%2F1%2Fimage%2FaHR0cHM6Ly9pbWdxLmRka3kuY29tL2Mvd2F0ZXJQaWMvMTA4MC5wbmc%3D%2Fdissolve%2F80%2Fgravity%2FCenter%2Fdx%2F0%2Fdy%2F0%7CimageMogr2%2Fauto-orient%2Fthumbnail%2F240x240%21%2Fquality%2F100
         * shape :  本品为棕红色至深棕色的液体；气微香，味甜、微苦。 
         * sideEffects :  尚不明确。 
         * storage :  密封。 
         * taboo :  尚不明确。 
         * usage :  口服。一次10ml，一日3次，小儿酌减。如有沉淀，摇匀后服用。 
         */

        private String approvalNumber;
        private String component;
        private long createTime;
        private String drugsCategoryId;
        private String effect;
        private String id;
        private String mindMatter;
        private String name;
        private String packing;
        private String picture;
        private String shape;
        private String sideEffects;
        private String storage;
        private String taboo;
        private String usage;

        public String getApprovalNumber() {
            return approvalNumber;
        }

        public void setApprovalNumber(String approvalNumber) {
            this.approvalNumber = approvalNumber;
        }

        public String getComponent() {
            return component;
        }

        public void setComponent(String component) {
            this.component = component;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getDrugsCategoryId() {
            return drugsCategoryId;
        }

        public void setDrugsCategoryId(String drugsCategoryId) {
            this.drugsCategoryId = drugsCategoryId;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMindMatter() {
            return mindMatter;
        }

        public void setMindMatter(String mindMatter) {
            this.mindMatter = mindMatter;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPacking() {
            return packing;
        }

        public void setPacking(String packing) {
            this.packing = packing;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getShape() {
            return shape;
        }

        public void setShape(String shape) {
            this.shape = shape;
        }

        public String getSideEffects() {
            return sideEffects;
        }

        public void setSideEffects(String sideEffects) {
            this.sideEffects = sideEffects;
        }

        public String getStorage() {
            return storage;
        }

        public void setStorage(String storage) {
            this.storage = storage;
        }

        public String getTaboo() {
            return taboo;
        }

        public void setTaboo(String taboo) {
            this.taboo = taboo;
        }

        public String getUsage() {
            return usage;
        }

        public void setUsage(String usage) {
            this.usage = usage;
        }
    }
}
