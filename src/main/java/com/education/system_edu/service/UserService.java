package com.education.system_edu.service;

public interface UserService {
    boolean updatePassword(String loginCode, String oldPassword, String newPassword);
}
