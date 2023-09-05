package com.meteor.ddd.application.service;

import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.infrastructure.repository.po.UserPO;
import com.meteor.ddd.interfaces.dto.UserLoginCmd;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public interface IUserApplicationService {
    /**
     * 用户登录
     *
     * @param loginCmd /
     * @return /
     */
    User login(UserLoginCmd loginCmd);

    /**
     * 查询用户
     *
     * @param userId /
     * @return /
     */
    UserPO getUser(Long userId);
}
