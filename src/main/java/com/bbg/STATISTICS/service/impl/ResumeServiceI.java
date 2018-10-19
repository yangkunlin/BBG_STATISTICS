package com.bbg.STATISTICS.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.bbg.STATISTICS.common.Params;
import com.bbg.STATISTICS.common.utils.SortUtil;
import com.bbg.STATISTICS.mapper.ResumeMapper;
import com.bbg.STATISTICS.model.ResultModel.FirmResumeResult;
import com.bbg.STATISTICS.model.ResultModel.ResumeResult;
import com.bbg.STATISTICS.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:  yangkunlin
 * Date:    2018/10/12
 * Domain:  pla.hc10
 */
@Service(value = "resumeService")
public class ResumeServiceI implements ResumeService {

    @Autowired
    private ResumeMapper resumeMapper;

    @Override
    public String cityQuery(String category) {
        List<ResumeResult> resumeResults;
        resumeResults = resumeMapper.resumeCityQuery(category);

        Map<String, Object> resultMap = new HashMap<>();

        for (ResumeResult resumeResult : resumeResults) {
            if (resumeResult.getCity() != null) {
                resultMap.put(resumeResult.getCity().substring(0, resumeResult.getCity().length() -1), resumeResult.getCityCount());
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public String veteranTimeQuery(String category) {

        List<ResumeResult> veteranTimeQueryResults;
        if (category.equals(Params.day)) {
            veteranTimeQueryResults = resumeMapper.veteranTimeQueryByDay(category);
        } else if (category.equals(Params.month)) {
            veteranTimeQueryResults = resumeMapper.veteranTimeQueryByMonth(category);
        } else {
            veteranTimeQueryResults = resumeMapper.veteranTimeQueryByYear(category);
        }

        Map<String, Object> resultMap = new HashMap<>();

        for (ResumeResult resumeResult : veteranTimeQueryResults) {
            if (resumeResult.getCreateTime() != null){
                List<String> tempList = new ArrayList<>();
                tempList.add(resumeResult.getVeteranTimeCount());
                tempList.add(resumeResult.getVeteranTimeCount1());
                tempList.add(resumeResult.getVeteranTimeCount2());
                tempList.add(resumeResult.getVeteranTimeCount3());
                resultMap.put(resumeResult.getCreateTime(), tempList);
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public String exceptedSalaryQuery(String category) {
        List<ResumeResult> resumeResults;
        resumeResults = resumeMapper.exceptedSalaryQuery(category);

        Map<String, Object> resultMap = new HashMap<>();

        for (ResumeResult resumeResult : resumeResults) {
            if (resumeResult.getSalary() != null) {
                resultMap.put(resumeResult.getSalary(), resumeResult.getSalaryCount());
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public String educationQuery(String category) {
        List<ResumeResult> resumeResults;
        resumeResults = resumeMapper.educationQuery(category);

        Map<String, Object> resultMap = new HashMap<>();

        int count = 0;
        for (ResumeResult resumeResult : resumeResults) {
            if (resumeResult.getEducation() != null) {
                resultMap.put(resumeResult.getEducation(), resumeResult.getEducationCount());
                count += Integer.valueOf(resumeResult.getEducationCount());
            }
        }

        resultMap.put("total", String.valueOf(count));
        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public String exceptedPositionQuery(String category) {
        List<ResumeResult> resumeResults;
        resumeResults = resumeMapper.exceptedPositionQuery(category);

        Map<String, Object> resultMap = new HashMap<>();

        for (ResumeResult resumeResult : resumeResults) {
            if (resumeResult.getPosition() != null) {
                resultMap.put(resumeResult.getPosition(), resumeResult.getPositionCount());
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public String exceptedNatureQuery(String category) {
        List<ResumeResult> resumeResults;
        resumeResults = resumeMapper.exceptedNatureQuery(category);

        Map<String, Object> resultMap = new HashMap<>();

        for (ResumeResult resumeResult : resumeResults) {
            if (resumeResult.getNature() != null) {
                resultMap.put(resumeResult.getNature(), resumeResult.getNatureCount());
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public String oldQuery(String category) {
        List<ResumeResult> resumeResults;
        resumeResults = resumeMapper.oldQuery(category);

        Map<String, Object> resultMap = new HashMap<>();

        for (ResumeResult resumeResult : resumeResults) {
            if (resumeResult.getOld() != null) {
                resultMap.put(resumeResult.getOld(), resumeResult.getOldCount());
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public String sendQuery(String category) {
        List<FirmResumeResult> firmResumeResults;
        firmResumeResults = resumeMapper.sendQuery(category);

        Map<String, Object> resultMap = new HashMap<>();

        int i = 1;
        for (FirmResumeResult firmResumeResult : firmResumeResults) {
            if (firmResumeResult.getFirmName() != null) {
                List<String> tempList = new ArrayList<>();
                tempList.add(firmResumeResult.getSendCount1());
                tempList.add(firmResumeResult.getSendCount2());
                tempList.add(firmResumeResult.getSendCount3());
                String temp;
                if (i < 10) {
                    temp = "0000" + i;
                } else if (i < 100) {
                    temp = "000" + i;
                } else if (i < 1000) {
                    temp = "00" + i;
                } else if (i < 10000) {
                    temp = "0" + i;
                } else {
                    temp = String.valueOf(i);
                }
                resultMap.put(temp + "-" + firmResumeResult.getFirmName().substring(0,4), tempList);
                i++;
            }
        }

        return JSONUtils.toJSONString(SortUtil.sortMapByKey(resultMap));
    }

    @Override
    public Integer getTotal() {
        return resumeMapper.getSendTotal();
    }

    @Override
    public List<FirmResumeResult> searchBySingleColumnSort(FirmResumeResult firmResumeResult) {
        return resumeMapper.searchBySingleColumnSort(firmResumeResult);
    }

    @Override
    public List<FirmResumeResult> getSendPageSort(FirmResumeResult firmResumeResult) {
        return resumeMapper.getSendPageSort(firmResumeResult);
    }

    @Override
    public List<FirmResumeResult> searchBySingleColumn(FirmResumeResult firmResumeResult) {
        return resumeMapper.searchBySingleColumn(firmResumeResult);
    }

    @Override
    public List<FirmResumeResult> getSendListPage(FirmResumeResult firmResumeResult) {
        return resumeMapper.getSendListPage(firmResumeResult);
    }
}
