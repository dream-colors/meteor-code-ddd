package com.meteor.ddd.domain.service.impl;

import com.meteor.ddd.domain.entity.LoginTypeEnum;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.domain.service.IUserDomainService;
import com.meteor.ddd.domain.service.login.ILoginService;
import com.meteor.ddd.domain.service.login.LoginServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class UserDomainServiceImpl implements IUserDomainService {
    private final LoginServiceFactory loginServiceFactory;

    @Override
    public User login(String account, String password, LoginTypeEnum loginType) {
        ILoginService loginService = loginServiceFactory.getLoginService(loginType);
        return loginService.login(account, password);
    }
}
