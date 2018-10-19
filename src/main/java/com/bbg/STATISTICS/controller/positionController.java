package com.bbg.STATISTICS.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbg.STATISTICS.common.Params;
import com.bbg.STATISTICS.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:  yangkunlin
 * Date:    2018/10/15
 * Domain:  pla.hc10
 */
@RestController
@RequestMapping(value = "/position")
public class positionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/city/statistics", method = RequestMethod.POST)
    public String positionCityStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return positionService.positionCityQuery(category);
    }

    @RequestMapping(value = "/count/statistics", method = RequestMethod.POST)
    public String positionStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return positionService.positionQuery(category);
    }

    @RequestMapping(value = "/createTime/statistics", method = RequestMethod.POST)
    public String positionCreateTimeStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return positionService.createTimeQuery(category);
    }

}
