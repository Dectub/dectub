package com.dectub.usecase.iam;

import com.dectub.IntegrationTest;
import com.dectub.TestResponse;
import com.dectub.iam.domain.SecurityPasswordHandler;
import com.dectub.iam.domain.SystemRepository;
import com.dectub.iam.domain.User;
import com.dectub.iam.domain.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;

import javax.annotation.Resource;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 4:02 下午
 */
public class RegisterUserTest extends IntegrationTest {
    private @Resource
    UserRepository userRepository;
    private @Resource
    SecurityPasswordHandler handler;

    private @Resource
    SystemRepository systemRepository;

    @Test
    void should_register_user_correctly_when_no_email_config() {
        systemRepository.save("register.email", "off");
        TestResponse response = post("/account/register", ImmutableMap.of("name", "test1", "email", "wangweili457@gmail.com", "roleIds", Set.of(491997312445317120L, 491997312445317121L), "password", "1234"));
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED);
        User user = userRepository.userForEmail("wangweili457@gmail.com");
        assertThat(user.name()).isEqualTo("test1");
        assertThat(user.email()).isEqualTo("wangweili457@gmail.com");
        assertThat(handler.verify("1234", user.password())).isTrue();
        assertThat(user.roleIds()).contains(491997312445317120L);
        assertThat(user.roleIds()).contains(491997312445317121L);
        assertThat(user.state()).isEqualTo("active");
    }

    @Test
    void should_register_user_correctly_when_have_email_config() {
        systemRepository.save("register.email", "on");
        TestResponse response = post("/account/register", ImmutableMap.of("name", "test1", "email", "wangweili457@gmail.com", "roleIds", Set.of(491997312445317120L, 491997312445317121L), "password", "1234"));
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED);
        User user = userRepository.userForEmail("wangweili457@gmail.com");
        assertThat(user.name()).isEqualTo("test1");
        assertThat(user.email()).isEqualTo("wangweili457@gmail.com");
        assertThat(handler.verify("1234", user.password())).isTrue();
        assertThat(user.roleIds()).contains(491997312445317120L);
        assertThat(user.roleIds()).contains(491997312445317121L);
        assertThat(user.state()).isEqualTo("active");
    }

    @AfterEach
    void tearDown() {
        userRepository.removeAll();
    }
}
