package com.gkyt.jwgk.domain.version;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class VersionServiceUnitTest {
    @Mock
    private VersionRepository versionRepository;

    @InjectMocks
    private VersionService versionService;

    @Test
    public void getBeSuccessful() {
        //Given
        String id = UUID.randomUUID().toString();

        Version version = new Version();
        BDDMockito.given(versionRepository.getOne(id)).willReturn(version);

        //When
        Version result = versionService.get(id);

        //Then
        BDDAssertions.then(result).isSameAs(version);
    }
}
