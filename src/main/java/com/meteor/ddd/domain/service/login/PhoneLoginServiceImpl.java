package com.meteor.ddd.domain.service.login;

import com.meteor.ddd.domain.entity.LoginTypeEnum;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.domain.repository.IUserRepository;
import org.springframework.stereotype.Component;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Component
public class PhoneLoginServiceImpl extends AbstractLoginService {
    public PhoneLoginServiceImpl(IUserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public LoginTypeEnum getLoginType() {
        return LoginTypeEnum.PHONE;
    }

    @Override
    public User loginCheck(String account, String password) {
        User user = userRepository.getByPhone(account);
        if (user == null) {
            throw new IllegalArgumentException("手机号未注册");
        }
        user.checkPassword(password);
        return user;
    }
}
