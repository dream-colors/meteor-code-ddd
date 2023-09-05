package com.meteor.ddd.domain.service.login;

import com.meteor.ddd.domain.acl.IMiniProgramService;
import com.meteor.ddd.domain.entity.LoginTypeEnum;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.domain.repository.IUserRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Map;

/**
 * 小程序一键登录
 *
 * @author 钟宗兵
 * @since 1.0.0
 */
@Component
public class MiniProgramLoginService extends AbstractLoginService {
    private final IMiniProgramService miniProgramService;

    public MiniProgramLoginService(IUserRepository userRepository,
                                   IMiniProgramService miniProgramService) {
        super(userRepository);
        this.miniProgramService = miniProgramService;
    }

    @Override
    public LoginTypeEnum getLoginType() {
        return LoginTypeEnum.MINI_PROGRAM;
    }

    @Override
    protected User loginCheck(String phoneCode, String openIdCode) {
        // account - 获取手机号的code, password - 获取openId的code
        String phoneNumber = miniProgramService.getPhoneNumber(phoneCode);
        if (ObjectUtils.isEmpty(phoneNumber)) {
            throw new IllegalArgumentException("获取手机号失败");
        }
        User user = userRepository.getByPhone(phoneNumber);
        if (user == null) {
            // 校验openId是否注册
            Map<String, String> accessInfo = miniProgramService.getAccessInfo(openIdCode);
            String openId = accessInfo.get("openId");
            if (ObjectUtils.isEmpty(openId)) {
                throw new IllegalArgumentException("获取openId失败");
            }
            user = userRepository.getByOpenId(openId);
            if (user == null) {
                user = User.builder()
                        .mobile(phoneNumber)
                        .openId(openId)
                        .unionId(accessInfo.get("unionId"))
                        .build();
                // 注册用户
                userRepository.save(user);
            }
        }

        return user;
    }
}
