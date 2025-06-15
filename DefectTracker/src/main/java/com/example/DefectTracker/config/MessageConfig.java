package com.defecttracker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    @Value("${error.defect.notfound}")
    private String defectNotFound;

    @Value("${error.invalid.status}")
    private String invalidStatus;

    public String getDefectNotFound() {
        return defectNotFound;
    }

    public String getInvalidStatus() {
        return invalidStatus;
    }
}
