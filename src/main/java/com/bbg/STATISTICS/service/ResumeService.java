package com.bbg.STATISTICS.service;

import com.bbg.STATISTICS.model.ResultModel.FirmResumeResult;

import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/10/12
 * Domain:  pla.hc10
 */
public interface ResumeService {
    String cityQuery(String category);

    String veteranTimeQuery(String category);

    String exceptedSalaryQuery(String category);

    String educationQuery(String category);

    String exceptedPositionQuery(String category);

    String exceptedNatureQuery(String category);

    String oldQuery(String category);

    String sendQuery(String category);

    Integer getTotal();

    List<FirmResumeResult> searchBySingleColumnSort(FirmResumeResult firmResumeResult);

    List<FirmResumeResult> getSendPageSort(FirmResumeResult firmResumeResult);

    List<FirmResumeResult> searchBySingleColumn(FirmResumeResult firmResumeResult);

    List<FirmResumeResult> getSendListPage(FirmResumeResult firmResumeResult);
}
