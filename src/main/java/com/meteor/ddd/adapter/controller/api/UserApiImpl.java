package com.meteor.ddd.adapter.controller.api;

import com.meteor.ddd.adapter.assembler.UserAssembler;
import com.meteor.ddd.application.service.IUserApplicationService;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.interfaces.dto.UserLoginCmd;
import com.meteor.ddd.interfaces.dto.vo.UserVO;
import com.meteor.ddd.interfaces.facade.IUserApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Service
public class UserApiImpl implements IUserApi {
    @Resource
    private IUserApplicationService userApplicationService;

    @Override
    public UserVO login(UserLoginCmd loginCmd) {
        User user = userApplicationService.login(loginCmd);
        return UserAssembler.toUserVo(user);
    }
}
