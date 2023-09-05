package com.meteor.ddd.application.service.login;

import com.meteor.ddd.application.acl.IMiniProgramService;
import com.meteor.ddd.domain.entity.LoginTypeEnum;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.domain.service.IUserDomainService;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 小程序一键登录
 *
 * @author 钟宗兵
 * @since 1.0.0
 */
@Component
public class MiniProgramLoginService implements ILoginService {
    @Resource
    private IMiniProgramService miniProgramService;
    @Resource
    private IUserDomainService userDomainService;

    @Override
    public LoginTypeEnum getLoginType() {
        return LoginTypeEnum.MINI_PROGRAM;
    }

    @Override
    public User login(String phoneCode, String openIdCode) {
        // account - 获取手机号的code, password - 获取openId的code
        // 获取手机号和openID
        String phoneNumber = miniProgramService.getPhoneNumber(phoneCode);
        if (ObjectUtils.isEmpty(phoneNumber)) {
            throw new IllegalArgumentException("获取手机号失败");
        }
        // 获取openID
        Map<String, String> accessInfo = miniProgramService.getAccessInfo(openIdCode);
        String openId = accessInfo.get("openId");
        if (ObjectUtils.isEmpty(openId)) {
            throw new IllegalArgumentException("获取openId失败");
        }
        return userDomainService.loginWithMiniProgram(phoneNumber, openId, accessInfo.get("unionId"));
    }
}
