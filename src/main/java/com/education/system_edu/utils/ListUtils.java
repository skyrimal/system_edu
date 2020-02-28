package com.education.system_edu.utils;

import com.education.system_edu.pojo.SysDataTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListUtils<T> {
    public ListUtils() {
    }

    public List<T> mapToList(Map map) {
        List<T> list = new ArrayList<>();
        Iterator mapIt = map.entrySet().iterator();
        while (mapIt.hasNext()) {
            Map.Entry entry = (Map.Entry) mapIt.next();
            list.add((T) entry.getValue());
        }
        return list;
    }
}
