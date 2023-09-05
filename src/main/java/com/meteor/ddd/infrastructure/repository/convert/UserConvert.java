package com.meteor.ddd.infrastructure.repository.convert;

import cn.hutool.core.bean.BeanUtil;
import com.meteor.ddd.domain.entity.Address;
import com.meteor.ddd.domain.entity.LoginStatusEnum;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.domain.entity.UserTypeEnum;
import com.meteor.ddd.infrastructure.repository.po.UserPO;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public class UserConvert {

    public static UserPO toUserPo(User user) {
        UserPO userPo = new UserPO();
        BeanUtil.copyProperties(user, userPo);
        if (user.getUserType() != null) {
            userPo.setUserType(user.getUserType().name());
        }
        if (user.getLoginStatus() != null) {
            userPo.setLoginStatus(user.getLoginStatus().name());
        }
        Address address = user.getAddress();
        if (address != null) {
            userPo.setProvince(address.getProvince());
            userPo.setCity(address.getCity());
            userPo.setArea(address.getArea());
            userPo.setStreet(address.getStreet());
        }
        return userPo;
    }

    public static User toUser(UserPO userPo) {
        User user = new User();
        BeanUtil.copyProperties(userPo, user);
        user.setUserType(UserTypeEnum.valueOf(userPo.getUserType()));
        user.setLoginStatus(LoginStatusEnum.valueOf(userPo.getLoginStatus()));
        Address address = new Address();
        address.setProvince(userPo.getProvince());
        address.setCity(userPo.getCity());
        address.setArea(userPo.getArea());
        address.setStreet(userPo.getStreet());
        user.setAddress(address);
        return user;
    }
}
