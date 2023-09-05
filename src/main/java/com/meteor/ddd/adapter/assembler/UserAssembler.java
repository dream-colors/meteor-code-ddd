package com.meteor.ddd.adapter.assembler;

import cn.hutool.core.bean.BeanUtil;
import com.meteor.ddd.domain.entity.Address;
import com.meteor.ddd.domain.entity.User;
import com.meteor.ddd.infrastructure.repository.po.UserPO;
import com.meteor.ddd.interfaces.dto.vo.UserVO;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public class UserAssembler {

    public static UserVO toUserVo(User user) {
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(user, userVO);
        userVO.setUserType(user.getUserType().name());
        userVO.setLoginStatus(user.getLoginStatus().name());
        Address address = user.getAddress();
        if (address != null) {
            userVO.setProvince(address.getProvince());
            userVO.setCity(address.getCity());
            userVO.setArea(address.getArea());
            userVO.setStreet(address.getStreet());
        }
        return userVO;
    }

    public static UserVO toUserVo(UserPO userPo) {
        UserVO userVO = new UserVO();
        BeanUtil.copyProperties(userPo, userVO);
        return userVO;
    }
}
