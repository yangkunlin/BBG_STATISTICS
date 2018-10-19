package com.bbg.STATISTICS.mapper;

import com.bbg.STATISTICS.model.Firm;
import com.bbg.STATISTICS.model.ResultModel.FirmQueryResult;

import java.util.List;

public interface FirmMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Firm record);

    int insertSelective(Firm record);

    Firm selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Firm record);

    int updateByPrimaryKey(Firm record);

    List<FirmQueryResult> stateQueryByDay(String category);

    List<FirmQueryResult> stateQueryByMonth(String category);

    List<FirmQueryResult> stateQueryByYear(String category);

    List<FirmQueryResult> scaleQuery(String category);

    List<FirmQueryResult> categoryQuery(String category);
}