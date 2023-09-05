package com.meteor.ddd.domain.entity;

import cn.hutool.crypto.SecureUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String name;
    private String mobile;
    private String openId;
    private String unionId;
    private String password;
    private UserTypeEnum userType;
    private Address address;
    private LoginStatusEnum loginStatus;

    public void login() {
        this.loginStatus = LoginStatusEnum.ONLINE;
    }

    public void checkPassword(String password) {
        if (!Objects.equals(encryptPassword(password), this.password)) {
            throw new IllegalArgumentException("密码错误");
        }
    }

    public String encryptPassword(String password) {
        return SecureUtil.md5(password);
    }
}
