package com.bbg.STATISTICS.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.bbg.STATISTICS.common.utils.SortUtil;
import com.bbg.STATISTICS.mapper.PositionMapper;
import com.bbg.STATISTICS.model.ResultModel.PositionResult;
import com.bbg.STATISTICS.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:  yangkunlin
 * Date:    2018/10/15
 * Domain:  pla.hc10
 */
@Service(value = "PositionService")
public class PositionServiceI implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public String positionQuery(String category) {
        return  positionMapper.positionCount().toString();
    }

    @Override
    public String positionCityQuery(String category) {
        List<PositionResult> positionResults;
        positionResults = positionMapper.positionCityQuery(category);

        Map<String, Object> resultMap = new HashMap<>();

        for (PositionResult positionResult : positionResults) {
            if (positionResult.getCity() != null && !positionResult.getCity().equals("直辖县级")) {
                resultMap.put(positionResult.getCity().substring(0, positionResult.getCity().length() -1), positionResult.getCityCount());
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public String createTimeQuery(String category) {
        List<PositionResult> positionResults=  positionMapper.createTimeQuery(category);


        Map<String, Object> resultMap = new HashMap<>();

        for (PositionResult positionResult : positionResults) {
            if (positionResult.getCreateTime() != null){
                resultMap.put(positionResult.getCreateTime(), positionResult.getPositionCount());
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }
}
