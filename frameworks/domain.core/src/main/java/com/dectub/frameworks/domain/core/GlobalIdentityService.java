package com.dectub.frameworks.domain.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalIdentityService {
    private static IdentityService identityService;

    public static long next() {
        return identityService.nextIdentity();
    }

    public static void reset(IdentityService identityService) {
        GlobalIdentityService.identityService = identityService;
    }
}
