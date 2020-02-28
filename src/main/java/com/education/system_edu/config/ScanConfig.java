package com.education.system_edu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.education.system_edu.mapper")
public class ScanConfig {
}
