package com.bbg.STATISTICS.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bbg.STATISTICS.common.PageHelper;
import com.bbg.STATISTICS.common.Params;
import com.bbg.STATISTICS.model.ResultModel.FirmResumeResult;
import com.bbg.STATISTICS.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/10/12
 * Domain:  pla.hc10
 */
@RestController
@RequestMapping(value = "/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @RequestMapping(value = "/city/statistics", method = RequestMethod.POST)
    public String stateStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return resumeService.cityQuery(category);
    }

    @RequestMapping(value = "/veteran/time/statistics", method = RequestMethod.POST)
    public String veteranTimeStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return resumeService.veteranTimeQuery(category);
    }

    @RequestMapping(value = "/excepted/salary/statistics", method = RequestMethod.POST)
    public String exceptedSalaryStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return resumeService.exceptedSalaryQuery(category);
    }

    @RequestMapping(value = "/education/statistics", method = RequestMethod.POST)
    public String educationStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return resumeService.educationQuery(category);
    }

    @RequestMapping(value = "/excepted/position/statistics", method = RequestMethod.POST)
    public String exceptedPositionStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return resumeService.exceptedPositionQuery(category);
    }

    @RequestMapping(value = "/excepted/nature/statistics", method = RequestMethod.POST)
    public String exceptedNatureStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return resumeService.exceptedNatureQuery(category);
    }

    @RequestMapping(value = "/old/statistics", method = RequestMethod.POST)
    public String oldStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return resumeService.oldQuery(category);
    }

    @RequestMapping(value = "/send/statistics", method = RequestMethod.POST)
    public String sendStatistics(@RequestBody String body) throws Exception {

        JSONObject bodyJSON = JSON.parseObject(body);

        String category;
        if (bodyJSON.containsKey(Params.category)) {
            category = bodyJSON.getString(Params.category);
        } else {
            category = Params.category;
        }

        return resumeService.sendQuery(category);
    }

    @ResponseBody
    @PostMapping(value = "/send/information", produces = {"application/json;charset=UTF-8"})
    public PageHelper<FirmResumeResult> getAllCompanyInformation(FirmResumeResult firmResumeResult, HttpServletRequest request) {

        PageHelper<FirmResumeResult> pageHelper = new PageHelper<>();
        // 统计总记录数
        Integer total = resumeService.getTotal();
        pageHelper.setTotal(total);


        if (firmResumeResult.getSort() != null && firmResumeResult.getSortOrder() != null) {
            if (firmResumeResult.getSearchContent() != null && firmResumeResult.getSearchContent() != "" && firmResumeResult.getSearchTarget() != null && firmResumeResult.getSearchTarget() != "") {
                List<FirmResumeResult> list = resumeService.searchBySingleColumnSort(firmResumeResult);
                pageHelper.setRows(list);
            } else {
                List<FirmResumeResult> list = resumeService.getSendPageSort(firmResumeResult);
                pageHelper.setRows(list);
            }
        } else {
            if (firmResumeResult.getSearchContent() != null && firmResumeResult.getSearchContent() != "" && firmResumeResult.getSearchTarget() != null && firmResumeResult.getSearchTarget() != "") {
                List<FirmResumeResult> list = resumeService.searchBySingleColumn(firmResumeResult);
                pageHelper.setRows(list);
            } else {
                // 查询当前页实体对象
                List<FirmResumeResult> list = resumeService.getSendListPage(firmResumeResult);
                pageHelper.setRows(list);
            }
        }


        return pageHelper;


    }


}
