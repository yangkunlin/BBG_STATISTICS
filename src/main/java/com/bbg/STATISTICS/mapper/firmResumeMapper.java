package com.bbg.STATISTICS.mapper;

import com.bbg.STATISTICS.model.firmResume;

public interface firmResumeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(firmResume record);

    int insertSelective(firmResume record);

    firmResume selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(firmResume record);

    int updateByPrimaryKey(firmResume record);
}