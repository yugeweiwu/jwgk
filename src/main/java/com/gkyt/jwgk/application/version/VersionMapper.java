package com.gkyt.jwgk.application.version;

import com.gkyt.jwgk.domain.version.Version;
import com.gkzx.shared.application.model.Mapper;
import org.springframework.stereotype.Component;

@Component
public class VersionMapper {
    VersionModel mapToVersionModel(Version version) {
        return new Mapper().map(version, VersionModel.class);
    }
}
