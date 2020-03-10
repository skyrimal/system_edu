package com.education.system_edu.utils;

import com.education.system_edu.pojo.SysModelClass;
import com.education.system_edu.pojo.output.OutputClass;

import java.util.ArrayList;
import java.util.List;

public class OutPutEntryUtils {
    public static List<OutputClass> sysModelClassesToOutputClasses(List<SysModelClass> sysModelClasses) {
        List<OutputClass> outputClasses = new ArrayList<>();
        for (SysModelClass sysModelClass : sysModelClasses) {
            outputClasses.add(sysModelClassToOutputClass(sysModelClass));
        }
        return  outputClasses;
    }

    private static OutputClass sysModelClassToOutputClass(SysModelClass sysModelClass){
        OutputClass outputClass = new OutputClass();
        outputClass.setClassClassCode(sysModelClass.getClassCode());
        outputClass.setClassCode(sysModelClass.getCode());
        return  outputClass;
    }
}
