package com.bbg.STATISTICS.service;

/**
 * Author:  yangkunlin
 * Date:    2018/10/15
 * Domain:  pla.hc10
 */
public interface PositionService {
    String positionQuery(String category);

    String positionCityQuery(String category);

    String createTimeQuery(String category);
}
