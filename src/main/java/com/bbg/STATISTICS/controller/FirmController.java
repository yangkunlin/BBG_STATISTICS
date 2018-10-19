package com.bbg.STATISTICS.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbg.STATISTICS.common.Params;
import com.bbg.STATISTICS.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:  yangkunlin
 * Date:    2018/10/11
 * Domain:  pla.hc10
 */
@RestController
@RequestMapping(value = "/firm")
public class FirmController {

    @Autowired
    private FirmService firmService;

    @RequestMapping(value = "/state/statistics", method = RequestMethod.POST)
    public String stateStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return firmService.stateQuery(category);
    }

    @RequestMapping(value = "/scale/statistics", method = RequestMethod.POST)
    public String scaleStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return firmService.scaleQuery(category);
    }

    @RequestMapping(value = "/category/statistics", method = RequestMethod.POST)
    public String categoryStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return firmService.categoryQuery(category);
    }
}
