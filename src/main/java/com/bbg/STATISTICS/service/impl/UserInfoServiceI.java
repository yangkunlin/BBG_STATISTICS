package com.bbg.STATISTICS.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.bbg.STATISTICS.common.utils.SortUtil;
import com.bbg.STATISTICS.mapper.MineMapper;
import com.bbg.STATISTICS.mapper.UserInfoMapper;
import com.bbg.STATISTICS.model.ResultModel.UserInfoResult;
import com.bbg.STATISTICS.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:  yangkunlin
 * Date:    2018/10/12
 * Domain:  pla.hc10
 */
@Service(value = "userInfoService")
public class UserInfoServiceI implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private MineMapper mineMapper;

    @Override
    public String cityQuery(String category) {
        List<UserInfoResult> userInfoResults;
        userInfoResults = userInfoMapper.cityQuery(category);

        Map<String, Object> resultMap = new HashMap<>();

        for (UserInfoResult userInfoResult : userInfoResults) {
            if (userInfoResult.getCity() != null && !userInfoResult.getCity().equals("直辖县级")) {
                resultMap.put(userInfoResult.getCity().substring(0, userInfoResult.getCity().length() -1), userInfoResult.getCityCount());
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public String clickQuery(String category) {
        int count = mineMapper.clickCount();
        return mineMapper.clickCount().toString();
    }
}
