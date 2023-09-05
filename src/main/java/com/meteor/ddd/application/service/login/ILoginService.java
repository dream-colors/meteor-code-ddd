package com.meteor.ddd.application.service.login;

import com.meteor.ddd.domain.entity.LoginTypeEnum;
import com.meteor.ddd.domain.entity.User;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public interface ILoginService {
    /**
     * 获取登录类型
     * @return /
     */
    LoginTypeEnum getLoginType();

    /**
     * 登录
     * @param account  /
     * @param password /
     * @return /
     */
    User login(String account, String password);
}
