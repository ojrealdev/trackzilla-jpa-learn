package com.keysoft.bucktrackerjpa.service;

import com.keysoft.bucktrackerjpa.entity.Release;

public interface IReleaseService {
    void addRelease(Release release);
    void addApplication(Integer appId, Integer releaseId);
}
