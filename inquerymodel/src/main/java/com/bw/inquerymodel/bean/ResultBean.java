package com.bw.inquerymodel.bean;

/*
 * @Auther:张贺祥(Lenovo)
 * @Date:2019/12/24
 * @Description:
 */
public class ResultBean {


    /**
     * doctorUserName : cNGZ2W6BNaoY9v4ylogpXGPzf24RIkMP8GowgwSF2uH7DmFE4Z837j3oP6tCgIwUatSZu0P2bmpXsFe7IwvIoi9eBjXq+aCnyDe4memv4tnWIPa17/PJsG0ORdSVLiaeN8nx1Q3bVY78uIcvW0BDwuzT/NfJ66qnbqOyey+lVW0=
     * message : 查询成功
     * status : 0000
     */

    private String doctorUserName;
    private String message;
    private String status;

    public String getDoctorUserName() {
        return doctorUserName;
    }

    public void setDoctorUserName(String doctorUserName) {
        this.doctorUserName = doctorUserName;
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
}
