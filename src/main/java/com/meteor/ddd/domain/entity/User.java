package com.meteor.ddd.domain.entity;

import lombok.Data;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Data
public class User {
    private Long userId;
    private String name;
    private String mobile;
    private String password;
    private UserTypeEnum userType;
    private Address address;
}
