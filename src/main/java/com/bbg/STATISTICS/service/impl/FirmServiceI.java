package com.bbg.STATISTICS.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.bbg.STATISTICS.common.Params;
import com.bbg.STATISTICS.common.utils.SortUtil;
import com.bbg.STATISTICS.mapper.FirmMapper;
import com.bbg.STATISTICS.model.ResultModel.FirmQueryResult;
import com.bbg.STATISTICS.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:  yangkunlin
 * Date:    2018/10/11
 * Domain:  pla.hc10
 */
@Service(value = "FirmService")
public class FirmServiceI implements FirmService {

    @Autowired
    private FirmMapper firmMapper;

    @Override
    public String stateQuery(String category) {

        List<FirmQueryResult> stateQueryResults;
        if (category.equals(Params.day)) {
            stateQueryResults = firmMapper.stateQueryByDay(category);
        } else if (category.equals(Params.month)) {
            stateQueryResults = firmMapper.stateQueryByMonth(category);
        } else {
            stateQueryResults = firmMapper.stateQueryByYear(category);
        }

        Map<String, Object> resultMap = new HashMap<>();

        for (FirmQueryResult stateQueryResult : stateQueryResults) {
            if (stateQueryResult.getCreateTime() != null){
                List<String> tempList = new ArrayList<>();
                tempList.add(stateQueryResult.getStateCount());
                tempList.add(stateQueryResult.getState1Count());
                tempList.add(stateQueryResult.getState2Count());
                tempList.add(stateQueryResult.getState3Count());
                resultMap.put(stateQueryResult.getCreateTime(), tempList);
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public String scaleQuery(String category) {
        List<FirmQueryResult> scaleQueryResults;
        scaleQueryResults = firmMapper.scaleQuery(category);
        Map<String, String> resultMap = new HashMap<>();

        for (FirmQueryResult scaleQueryResult : scaleQueryResults) {
            if (scaleQueryResult.getScale() != null) {
                resultMap.put(scaleQueryResult.getScale(), scaleQueryResult.getScaleCount());
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByValue(resultMap, resultMap.size()));
    }

    @Override
    public String categoryQuery(String category) {
        List<FirmQueryResult> categoryQueryResults;
        categoryQueryResults = firmMapper.categoryQuery(category);
        Map<String, String> resultMap = new HashMap<>();

        for (FirmQueryResult categoryQueryResult : categoryQueryResults) {
            if (categoryQueryResult.getCategory() != null) {
                resultMap.put(categoryQueryResult.getCategory(), categoryQueryResult.getCategoryCount());
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByValue(resultMap, resultMap.size()));
    }
}
