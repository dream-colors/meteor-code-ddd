package com.meteor.ddd.application.service.login;

import com.meteor.ddd.domain.entity.LoginTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Slf4j
@Component
public class LoginServiceFactory {
    @Resource
    private List<ILoginService> loginServices;

    public ILoginService getLoginService(LoginTypeEnum loginType) {
        for (ILoginService loginService : loginServices) {
            if (Objects.equals(loginType, loginService.getLoginType())) {
                return loginService;
            }
        }

        throw new IllegalArgumentException("获取登录实现失败: " + loginType);
    }
}
