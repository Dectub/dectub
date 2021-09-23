package com.dectub.usecase.iam;

import com.dectub.IntegrationTest;
import com.dectub.iam.domain.SystemRepository;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/23 5:59 下午
 */
public class SystemRepositoryTest extends IntegrationTest {
    private @Resource
    SystemRepository systemRepository;

    @Test
    void should_replace_tags() {
        systemRepository.save("test","test#%tet&%");
        assertThat(systemRepository.getConfig("test")).isEqualTo("testtet");
        systemRepository.remove("test");
    }

    @Test
    void should_replace_tags_3() {
        systemRepository.save("test","test#%tests&%#%tests&%");
        systemRepository.save("tests","test#%testt&%s");
        systemRepository.save("testt","t");
        assertThat(systemRepository.getConfig("test")).isEqualTo("testtesttstestts");
        systemRepository.remove("test");
        systemRepository.remove("tests");
        systemRepository.remove("testt");
    }

    @Test
    void should_replace_tag_4() {
        systemRepository.save("test","#%tes#%testt&%s&%");
        systemRepository.save("tests","test#%testt&%s");
        systemRepository.save("testt","t");
        assertThat(systemRepository.getConfig("test")).isEqualTo("testts");
        systemRepository.remove("test");
        systemRepository.remove("tests");
        systemRepository.remove("testt");
    }

    @Test
    void should_replace_tag_5() {
        systemRepository.save("test","#%tes#%tes&%s&%");
        systemRepository.save("tests","test#%testt&%s");
        systemRepository.save("testt","t");
        assertThat(systemRepository.getConfig("test")).isEqualTo("testess");
        systemRepository.remove("test");
        systemRepository.remove("tests");
        systemRepository.remove("testt");
    }

    @Test
    void should_replace_tag_6() {
        systemRepository.save("test","#%#%testt&%es#%testt&%s&%");
        systemRepository.save("tests","test#%testt&%s");
        systemRepository.save("testt","t");
        assertThat(systemRepository.getConfig("test")).isEqualTo("testts");
        systemRepository.remove("test");
        systemRepository.remove("tests");
        systemRepository.remove("testt");
    }

    @Test
    void should_replace_tags_2() {
        systemRepository.save("test","test#%tet");
        assertThat(systemRepository.getConfig("test")).isEqualTo("test#%tet");
        systemRepository.remove("test");
    }

}
