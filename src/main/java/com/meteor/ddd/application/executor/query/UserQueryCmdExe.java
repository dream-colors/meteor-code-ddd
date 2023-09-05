package com.meteor.ddd.application.executor.query;

import com.meteor.ddd.infrastructure.repository.mapper.IUserMapper;
import com.meteor.ddd.infrastructure.repository.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 单纯的查询业务跳过领域层，直接查询
 *
 * @author 钟宗兵
 * @since 1.0.0
 */
@Slf4j
@Component
public class UserQueryCmdExe {
    @Resource
    private IUserMapper userMapper;
    public UserPO getUser(Long userId) {
        return userMapper.tempUser();
    }
}
