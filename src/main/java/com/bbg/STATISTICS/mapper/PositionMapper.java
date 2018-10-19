package com.bbg.STATISTICS.mapper;

import com.bbg.STATISTICS.model.Position;
import com.bbg.STATISTICS.model.ResultModel.PositionResult;

import java.util.List;

public interface PositionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

    Integer positionCount();

    List<PositionResult> positionCityQuery(String category);

    List<PositionResult> createTimeQuery(String category);
}