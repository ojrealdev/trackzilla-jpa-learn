package com.keysoft.bucktrackerjpa.service;

import com.keysoft.bucktrackerjpa.entity.Application;

import java.util.List;

public interface IApplicationService {
    boolean addApplication(Application application);
    Application getApplicationById(int applicationId);
    void updateApplication(Application application);
    void deleteApplication(int applicationId);
}
