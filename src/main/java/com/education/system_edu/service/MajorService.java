package com.education.system_edu.service;

import com.education.system_edu.pojo.pojo.Major;

import java.util.List;

public interface MajorService {
    int addMajor(Major major, String loginCode);
    List<Major> findMajorByMajor(Major major, String keyword, String faculty);

    Major findMajorByMajorByMajorCode(String majorCode);

    Integer updateMajor(Major major,String userCode);
}