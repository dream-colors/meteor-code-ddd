package com.meteor.ddd.application.service.login;

import com.meteor.ddd.domain.entity.LoginTypeEnum;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.domain.service.IUserDomainService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Component
public class PhoneLoginServiceImpl implements ILoginService {

    @Resource
    private IUserDomainService userDomainService;

    @Override
    public LoginTypeEnum getLoginType() {
        return LoginTypeEnum.PHONE;
    }

    @Override
    public User login(String account, String password) {
        return userDomainService.loginWithPhone(account, password);
    }
}
