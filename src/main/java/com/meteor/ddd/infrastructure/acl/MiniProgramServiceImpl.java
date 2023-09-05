package com.meteor.ddd.infrastructure.acl;

import com.meteor.ddd.domain.acl.IMiniProgramService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 小程序防腐层
 *
 * @author 钟宗兵
 * @since 1.0.0
 */
@Component
public class MiniProgramServiceImpl implements IMiniProgramService {

    @Override
    public String getPhoneNumber(String phoneCode) {
        // 实现小程序逻辑，或调用通用微服务
        return "";
    }

    @Override
    public Map<String, String> getAccessInfo(String openIdCode) {
        // 实现小程序逻辑，或调用通用微服务
        return new HashMap<>();
    }
}
