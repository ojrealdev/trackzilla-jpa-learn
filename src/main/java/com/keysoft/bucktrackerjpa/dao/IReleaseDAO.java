package com.keysoft.bucktrackerjpa.dao;

import com.keysoft.bucktrackerjpa.entity.Release;

public interface IReleaseDAO {
    void addRelease(Release release);
    void addApplication(Integer appId, Integer releaseId);
    Release getReleaseById(int releaseId);
}
