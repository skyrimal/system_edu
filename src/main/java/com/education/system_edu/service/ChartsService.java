package com.education.system_edu.service;

import com.education.system_edu.pojo.charts.Chart;

import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月20日 14:50
 */
public interface ChartsService {
    List<Chart> getPieData();

    List<List<Integer>> getLineData();

    List<List<Integer>> getLine2Data();
}
