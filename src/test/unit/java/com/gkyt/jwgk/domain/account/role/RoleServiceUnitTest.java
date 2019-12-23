package com.gkyt.jwgk.domain.account.role;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class RoleServiceUnitTest {
    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    public void getBeSuccessful() {
        //Given
        String id = UUID.randomUUID().toString();

        Role role = new Role();
        BDDMockito.given(roleRepository.findOne(id)).willReturn(role);

        //When
        Role result = roleService.get(id);

        //Then
        BDDAssertions.then(result).isSameAs(role);
    }
}
