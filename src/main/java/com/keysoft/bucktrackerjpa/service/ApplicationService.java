package com.keysoft.bucktrackerjpa.service;

import com.keysoft.bucktrackerjpa.dao.IApplicationDAO;
import com.keysoft.bucktrackerjpa.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService implements IApplicationService{

    @Autowired
    private IApplicationDAO applicationDAO;

    @Override
    public synchronized boolean addApplication(Application application) {
        if (applicationDAO.applicationExists(application.getName(), application.getOwner())) {
            return false;
        } else{
            applicationDAO.addApplication(application);
            return true;
        }
    }

    @Override
    public Application getApplicationById(int applicationId) {
        return applicationDAO.getApplicationById(applicationId);
    }

    @Override
    public void updateApplication(Application application) {
        applicationDAO.updateApplication(application);

    }

    @Override
    public void deleteApplication(int applicationId) {
        applicationDAO.deleteApplication(applicationId);
    }
}
