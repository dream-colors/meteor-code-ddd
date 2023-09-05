package com.meteor.ddd.application.service.impl;

import com.meteor.ddd.application.executor.UserLoginCmdExe;
import com.meteor.ddd.application.executor.query.UserQueryCmdExe;
import com.meteor.ddd.application.service.IUserApplicationService;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.infrastructure.repository.po.UserPO;
import com.meteor.ddd.interfaces.dto.UserLoginCmd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Service
public class UserApplicationServiceImpl implements IUserApplicationService {
    @Resource
    public UserLoginCmdExe userLoginCmdExe;
    @Resource
    private UserQueryCmdExe userQueryCmdExe;

    @Override
    public User login(UserLoginCmd loginCmd) {
        return userLoginCmdExe.execute(loginCmd);
    }

    @Override
    public UserPO getUser(Long userId) {
        return userQueryCmdExe.getUser(userId);
    }
}
