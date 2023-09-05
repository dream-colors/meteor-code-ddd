package com.meteor.ddd.adapter.controller.web;

import com.meteor.ddd.adapter.assembler.UserAssembler;
import com.meteor.ddd.application.service.IUserApplicationService;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.infrastructure.repository.po.UserPO;
import com.meteor.ddd.interfaces.dto.UserLoginCmd;
import com.meteor.ddd.interfaces.dto.vo.CommonResponse;
import com.meteor.ddd.interfaces.dto.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@RestController
public class UserWebController {
    @Resource
    private IUserApplicationService userApplicationService;

    @PostMapping("/web/user/login")
    public CommonResponse<UserVO> login(@RequestBody @Valid UserLoginCmd loginCmd) {
        User user = userApplicationService.login(loginCmd);
        UserVO userVo = UserAssembler.toUserVo(user);
        return CommonResponse.success(userVo);
    }

    @GetMapping("/web/user/{userId}")
    public CommonResponse<UserVO> getUser(@PathVariable Long userId) {
        UserPO user = userApplicationService.getUser(userId);
        UserVO userVo = UserAssembler.toUserVo(user);
        return CommonResponse.success(userVo);
    }
}
