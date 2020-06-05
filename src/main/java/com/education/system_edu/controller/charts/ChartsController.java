package com.education.system_edu.controller.charts;

import com.education.system_edu.pojo.charts.Chart;
import com.education.system_edu.service.ChartsService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Description: TODO
 * @author: skyrimal
 * @date: 2020年04月20日 14:45
 */
@RestController
public class ChartsController {
    ChartsService chartsService;

    @Autowired
    public void setChartsService(ChartsService chartsService) {
        this.chartsService = chartsService;
    }


    @RequiresRoles({"manager"})
    @GetMapping("pie")
    public List<Chart> getPieData() {
        List<Chart> charts =chartsService.getPieData();
        return charts;
    }

    @RequiresRoles({"manager"})
    @GetMapping("line")
    public List<List<Integer>> getLineData() {
        List<List<Integer>> line =chartsService.getLineData();
        return line;
    }
    @RequiresRoles({"manager"})
    @GetMapping("line2")
    public List<List<Integer>> getLine2Data() {
        List<List<Integer>> line =chartsService.getLine2Data();
        return line;
    }
}
