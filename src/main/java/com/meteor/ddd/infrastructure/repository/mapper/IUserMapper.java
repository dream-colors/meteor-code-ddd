package com.meteor.ddd.infrastructure.repository.mapper;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.meteor.ddd.infrastructure.repository.po.UserPO;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
public interface IUserMapper extends BaseMapper<UserPO> {

    default UserPO tempUser() {
        UserPO userPO = new UserPO();
        userPO.setUserId(123L);
        userPO.setName("test");
        userPO.setMobile("12345678901");
        userPO.setPassword(SecureUtil.md5("abc123"));
        userPO.setOpenId("");
        userPO.setUnionId("");
        userPO.setUserType("SYSTEM");
        userPO.setProvince("江西");
        userPO.setCity("赣州");
        userPO.setArea("兴国");
        userPO.setStreet("");
        userPO.setLoginStatus("ONLINE");
        return userPO;
    }
}
