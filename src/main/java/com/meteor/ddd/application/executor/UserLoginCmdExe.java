package com.meteor.ddd.application.executor;

import com.meteor.ddd.application.event.UserEventPublisher;
import com.meteor.ddd.application.service.login.ILoginService;
import com.meteor.ddd.application.service.login.LoginServiceFactory;
import com.meteor.ddd.domain.entity.LoginTypeEnum;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.interfaces.dto.UserLoginCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Component
public class UserLoginCmdExe {
    @Resource
    private LoginServiceFactory loginServiceFactory;
    @Resource
    private UserEventPublisher userEventPublisher;

    public User execute(UserLoginCmd loginCmd) {
        LoginTypeEnum loginType = LoginTypeEnum.valueOf(loginCmd.getType());
        ILoginService loginService = loginServiceFactory.getLoginService(loginType);
        // 执行登录处理
        User user = loginService.login(loginCmd.getAccount(), loginCmd.getPassword());
        // 发布登录事件, 进行非必要事物的后处理逻辑
        userEventPublisher.publishLoginEvent(user);
        return user;
    }
}
