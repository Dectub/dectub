package com.dectub.usecase.iam;

import com.dectub.IntegrationTest;
import com.dectub.frameworks.domain.core.GlobalIdentityService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/18 3:35 下午
 */
public class IdentityServiceTest extends IntegrationTest {
    @Test
    void should_identity_service_generate_18_numbers() {
        System.out.println(GlobalIdentityService.next());
        assertThat(String.valueOf(GlobalIdentityService.next())).hasSize(18);
    }
}
