package com.bbg.STATISTICS.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbg.STATISTICS.common.Params;
import com.bbg.STATISTICS.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:  yangkunlin
 * Date:    2018/10/12
 * Domain:  pla.hc10
 */
@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/city/statistics", method = RequestMethod.POST)
    public String stateStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return userInfoService.cityQuery(category);
    }

    @RequestMapping(value = "/click/statistics", method = RequestMethod.POST)
    public String clickStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return userInfoService.clickQuery(category);
    }

}
