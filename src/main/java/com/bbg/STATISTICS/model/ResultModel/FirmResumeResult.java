package com.bbg.STATISTICS.model.ResultModel;

import com.bbg.STATISTICS.common.Page;

/**
 * Author:  yangkunlin
 * Date:    2018/10/14
 * Domain:  pla.hc10
 */
public class FirmResumeResult extends Page{

    private String firmName;

    private String firmId;

    private String resumeId;

    private String userName;

    private String openId;

    private String sendState;

    private String positionName;

    private String createTime;

    private String userPhone;

    private String firmPhone;

    private String sendCount;

    private String sendCount1;

    private String sendCount2;

    private String sendCount3;

    private String address;

    private String state;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getSendCount() {
        return sendCount;
    }

    public void setSendCount(String sendCount) {
        this.sendCount = sendCount;
    }

    public String getSendCount1() {
        return sendCount1;
    }

    public void setSendCount1(String sendCount1) {
        this.sendCount1 = sendCount1;
    }

    public String getSendCount2() {
        return sendCount2;
    }

    public void setSendCount2(String sendCount2) {
        this.sendCount2 = sendCount2;
    }

    public String getSendCount3() {
        return sendCount3;
    }

    public void setSendCount3(String sendCount3) {
        this.sendCount3 = sendCount3;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public String getFirmId() {
        return firmId;
    }

    public void setFirmId(String firmId) {
        this.firmId = firmId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSendState() {
        return sendState;
    }

    public void setSendState(String sendState) {
        this.sendState = sendState;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getFirmPhone() {
        return firmPhone;
    }

    public void setFirmPhone(String firmPhone) {
        this.firmPhone = firmPhone;
    }
}
