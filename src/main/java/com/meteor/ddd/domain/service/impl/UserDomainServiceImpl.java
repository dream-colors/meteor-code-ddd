package com.meteor.ddd.domain.service.impl;

import com.meteor.ddd.domain.entity.LoginStatusEnum;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.domain.repository.IUserRepository;
import com.meteor.ddd.domain.service.IUserDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class UserDomainServiceImpl implements IUserDomainService {
    private final IUserRepository userRepository;

    @Override
    public User loginWithPhone(String phone, String password) {
        User user = userRepository.getByPhone(phone);
        if (user == null) {
            throw new IllegalArgumentException("手机号未注册");
        }
        user.checkPassword(password);
        // 登录用户
        user.login();
        // 保存用户信息
        userRepository.save(User.builder()
                .userId(user.getUserId())
                .loginStatus(user.getLoginStatus())
                .build());
        return user;
    }

    @Override
    public User loginWithMiniProgram(String phone, String openId, String unionId) {
        User user = userRepository.getByPhone(phone);
        // 校验手机号是否注册
        if (user == null) {
            user = userRepository.getByOpenId(openId);
            // openId是否绑定：未绑定进行注册，绑定进行修改同步
            if (user == null) {
                user = User.builder()
                        .mobile(phone)
                        .openId(openId)
                        .unionId(unionId)
                        .loginStatus(LoginStatusEnum.ONLINE)
                        .build();
            } else {
                user.setOpenId(openId);
                user.setUnionId(unionId);
            }
        }
        user.login();
        // 保存用户信息
        userRepository.save(user);
        return user;
    }
}
