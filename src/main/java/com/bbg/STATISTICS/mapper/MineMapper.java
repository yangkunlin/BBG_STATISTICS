package com.bbg.STATISTICS.mapper;

import com.bbg.STATISTICS.model.Mine;

public interface MineMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Mine record);

    int insertSelective(Mine record);

    Mine selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Mine record);

    int updateByPrimaryKey(Mine record);

    Integer clickCount();
}