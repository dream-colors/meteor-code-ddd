package com.meteor.ddd.domain.repository;

import com.meteor.ddd.domain.entity.User;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public interface IUserRepository {
    /**
     * 保存用户信息
     *
     * @param user /
     */
    void save(User user);

    /**
     * 手机号获取用户
     *
     * @param phone /
     * @return /
     */
    User getByPhone(String phone);

    /**
     * 通过openId查询用户
     *
     * @param openId 小程序openID
     * @return /
     */
    User getByOpenId(String openId);
}
