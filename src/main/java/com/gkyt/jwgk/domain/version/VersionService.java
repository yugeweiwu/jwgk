package com.gkyt.jwgk.domain.version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VersionService {
    private final VersionRepository versionRepository;

    @Autowired
    public VersionService(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    public Version get(String id) {
        return versionRepository.getOne(id);
    }
}
