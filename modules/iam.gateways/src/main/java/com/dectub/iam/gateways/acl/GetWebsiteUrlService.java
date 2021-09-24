package com.dectub.iam.gateways.acl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Created by Neil Wang
 * @version 1.0.0
 * @date 2021/9/24 10:46 上午
 */
@Component
public class GetWebsiteUrlService {

    @Value("${website.url}")
    private String url;

    public String url() {
        return url;
    }
}
