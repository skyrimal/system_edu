package com.education.system_edu.service.impl;

import com.education.system_edu.mapper.ChartsMapper;
import com.education.system_edu.pojo.charts.Chart;
import com.education.system_edu.service.ChartsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月20日 14:50
 */
@Service
public class ChartsServiceImpl implements ChartsService {
    @Resource
    ChartsMapper chartsMapper;
    @Override
    public List<Chart> getPieData() {
        return chartsMapper.selectPieData();
    }

    @Override
    public List<List<Integer>> getLineData() {
        List<Chart> line = chartsMapper.selectLineData();
        List<List<Integer>> lineData = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for(Chart chart: line){
            x.add(Integer.valueOf(chart.getX()));
            y.add(Integer.valueOf(chart.getY()));
        }
        lineData.add(x);
        lineData.add(y);
        return lineData;
    }

    @Override
    public List<List<Integer>> getLine2Data() {
        List<Chart> line = chartsMapper.selectLine2Data();
        List<List<Integer>> lineData = new ArrayList<>();
        List<Integer> x = new ArrayList<>();
        for(Chart chart: line){
            x.add(Integer.valueOf(chart.getX()));
        }
        lineData.add(x);
        return lineData;
    }
}
