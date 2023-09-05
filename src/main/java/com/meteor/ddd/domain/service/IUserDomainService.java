package com.meteor.ddd.domain.service;

import com.meteor.ddd.domain.entity.LoginTypeEnum;
import com.meteor.ddd.domain.entity.User;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public interface IUserDomainService {

    /**
     * 用户登录
     *
     * @param account   账户
     * @param password  密码
     * @param loginType 登录类型
     * @return /
     */
    User login(String account, String password, LoginTypeEnum loginType);
}
