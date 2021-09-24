package com.dectub.usecase.iam;

import com.dectub.IntegrationTest;
import com.dectub.TestResponse;
import com.dectub.frameworks.domain.core.SystemConfig;
import com.dectub.iam.domain.*;
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
    private @Resource
    CacheRepository cacheRepository;

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
        systemRepository.save(SystemConfig.REGISTER_EMAIL, "on");
        systemRepository.save(SystemConfig.REGISTER_EMAIL_HOST, "smtp.gmail.com");
        systemRepository.save(SystemConfig.REGISTER_EMAIL_PORT, "465");
        systemRepository.save(SystemConfig.REGISTER_EMAIL_USERNAME, "neilwangextraty@gmail.com");
        systemRepository.save(SystemConfig.REGISTER_EMAIL_PASSWORD, "pL1lAs!L_u3jJ59G|)Al");
        systemRepository.save(SystemConfig.REGISTER_EMAIL_DEFAULT_ENCODING, "UTF-8");
        TestResponse response = post("/account/register", ImmutableMap.of("name", "test1", "email", "wangweili457@gmail.com", "roleIds", Set.of(491997312445317120L, 491997312445317121L), "password", "1234"));
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED);
        User user = userRepository.userForEmail("wangweili457@gmail.com");
        assertThat(user.name()).isEqualTo("test1");
        assertThat(user.email()).isEqualTo("wangweili457@gmail.com");
        assertThat(handler.verify("1234", user.password())).isTrue();
        assertThat(user.roleIds()).contains(491997312445317120L);
        assertThat(user.roleIds()).contains(491997312445317121L);
        assertThat(user.state()).isEqualTo("new");
        String code = cacheRepository.get("register.email", "wangweili457@gmail.com");
        assertThat(code).hasSize(18);
        get("/account/active/" + code);
        User user2 = userRepository.userForEmail("wangweili457@gmail.com");
        assertThat(user2.state()).isEqualTo("active");
    }

    @AfterEach
    void tearDown() {
        userRepository.removeAll();
        cacheRepository.remove("register.email", "wangweili457@gmail.com");
    }
}
