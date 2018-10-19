package com.bbg.STATISTICS.model.ResultModel;

/**
 * Author:  yangkunlin
 * Date:    2018/10/15
 * Domain:  pla.hc10
 */
public class PositionResult {

    private String city;

    private String cityCount;

    private String createTime;

    private String positionCount;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPositionCount() {
        return positionCount;
    }

    public void setPositionCount(String positionCount) {
        this.positionCount = positionCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCount() {
        return cityCount;
    }

    public void setCityCount(String cityCount) {
        this.cityCount = cityCount;
    }

}
