package com.meteor.ddd.domain.service.login;

import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.domain.repository.IUserRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class AbstractLoginService implements ILoginService {
    protected final IUserRepository userRepository;

    @Override
    public User login(String account, String password) {
        User user = loginCheck(account, password);
        // 登录用户
        user.login();
        // 登录后处理
        afterLogin(user);
        return user;
    }

    /**
     * 登录检查
     *
     * @param account  /
     * @param password /
     * @return /
     */
    protected abstract User loginCheck(String account, String password);

    protected void afterLogin(User user) {
        // 保存用户信息
        userRepository.save(User.builder()
                .userId(user.getUserId())
                .loginStatus(user.getLoginStatus())
                .build());
    }
}
