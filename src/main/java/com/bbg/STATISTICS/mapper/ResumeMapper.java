package com.bbg.STATISTICS.mapper;

import com.bbg.STATISTICS.model.ResultModel.FirmResumeResult;
import com.bbg.STATISTICS.model.ResultModel.ResumeResult;
import com.bbg.STATISTICS.model.Resume;

import java.util.List;

public interface ResumeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);

    List<ResumeResult> resumeCityQuery(String category);

    List<ResumeResult> veteranTimeQueryByDay(String category);

    List<ResumeResult> veteranTimeQueryByMonth(String category);

    List<ResumeResult> veteranTimeQueryByYear(String category);

    List<ResumeResult> exceptedSalaryQuery(String category);

    List<ResumeResult> educationQuery(String category);

    List<ResumeResult> exceptedPositionQuery(String category);

    List<ResumeResult> exceptedNatureQuery(String category);

    List<ResumeResult> oldQuery(String category);

    List<FirmResumeResult> sendQuery(String category);

    Integer getSendTotal();

    List<FirmResumeResult> searchBySingleColumnSort(FirmResumeResult firmResumeResult);

    List<FirmResumeResult> getSendPageSort(FirmResumeResult firmResumeResult);

    List<FirmResumeResult> searchBySingleColumn(FirmResumeResult firmResumeResult);

    List<FirmResumeResult> getSendListPage(FirmResumeResult firmResumeResult);
}