package com.meteor.ddd.application.acl;

import java.util.Map;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public interface IMiniProgramService {
    /**
     * 小程序获取手机号
     *
     * @param phoneCode 获取手机号code
     * @return /
     */
    String getPhoneNumber(String phoneCode);

    /**
     * 获取授权信息
     *
     * @param openIdCode 获取openId的 code
     * @return /
     */
    Map<String, String> getAccessInfo(String openIdCode);
}
