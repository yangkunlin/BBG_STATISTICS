package com.bbg.STATISTICS.mapper;

import com.bbg.STATISTICS.model.ResultModel.UserInfoResult;
import com.bbg.STATISTICS.model.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfoResult> cityQuery(String category);

}