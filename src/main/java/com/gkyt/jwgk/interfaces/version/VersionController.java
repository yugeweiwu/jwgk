package com.gkyt.jwgk.interfaces.version;

import com.gkyt.jwgk.application.version.VersionApplicationService;
import com.gkyt.jwgk.application.version.VersionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
public class VersionController {
    private final VersionApplicationService versionApplicationService;

    @Autowired
    public VersionController(VersionApplicationService versionApplicationService) {
        this.versionApplicationService = versionApplicationService;
    }

    @GetMapping("/{id}")
    public VersionModel get(@PathVariable("id") String versionId) {
        return versionApplicationService.get(versionId);
    }
}
