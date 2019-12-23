package com.gkyt.jwgk.application.version;

import com.gkyt.jwgk.domain.version.Version;
import com.gkyt.jwgk.domain.version.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersionApplicationService {
    private final VersionMapper versionMapper;
    private final VersionService versionService;

    @Autowired
    public VersionApplicationService(VersionMapper versionMapper, VersionService versionService) {
        this.versionMapper = versionMapper;
        this.versionService = versionService;
    }

    public VersionModel get(String versionId) {
        Version version = versionService.get(versionId);
        return versionMapper.mapToVersionModel(version);
    }
}
