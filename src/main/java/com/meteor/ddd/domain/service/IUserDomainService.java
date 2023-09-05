package com.meteor.ddd.domain.service;

import com.meteor.ddd.domain.entity.User;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public interface IUserDomainService {

    /**
     * 手机密码登录
     *
     * @param phone 手机号
     * @param password 密码
     * @return /
     */
    User loginWithPhone(String phone, String password);

    /**
     * 小程序登录
     *
     * @param phone 手机号
     * @param openId    openId
     * @param unionId /
     * @return /
     */
    User loginWithMiniProgram(String phone, String openId, String unionId);
}
