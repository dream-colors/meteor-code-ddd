package com.meteor.ddd.infrastructure.repository.impl;

import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.domain.repository.IUserRepository;
import com.meteor.ddd.infrastructure.repository.convert.UserConvert;
import com.meteor.ddd.infrastructure.repository.mapper.IUserMapper;
import com.meteor.ddd.infrastructure.repository.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Slf4j
@Repository
public class UserRepositoryImpl implements IUserRepository {
    @Resource
    private IUserMapper userMapper;

    @Override
    public void save(User user) {
        UserPO userPo = UserConvert.toUserPo(user);
        if (userPo.getUserId() == null) {
            userPo.setCreateTime(LocalDateTime.now());
            userPo.setUserId(123L);
//            userMapper.insert(userPo);
            user.setUserId(userPo.getUserId());
            log.info("保存成功");
        } else {
//            userMapper.updateById(userPo);
            log.info("更新成功");
        }
    }

    @Override
    public User getByPhone(String phone) {
        UserPO userPO = userMapper.tempUser();
        return UserConvert.toUser(userPO);
    }

    @Override
    public User getByOpenId(String openId) {
        UserPO userPO = userMapper.tempUser();
        return UserConvert.toUser(userPO);
    }
}
