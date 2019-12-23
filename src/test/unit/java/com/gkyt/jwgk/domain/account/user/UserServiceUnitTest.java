package com.gkyt.jwgk.domain.account.user;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceUnitTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void getBeSuccessful() {
        //Given
        String id = UUID.randomUUID().toString();

        User user = new User();
        BDDMockito.given(userRepository.findOne(id)).willReturn(user);

        //When
        User result = userService.get(id);

        //Then
        BDDAssertions.then(result).isSameAs(user);
    }
}
