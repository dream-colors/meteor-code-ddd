package com.meteor.ddd.interfaces.dto.vo;

import lombok.Data;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Data
public class UserVO {
    private Long userId;
    private String name;
    private String mobile;
    private String userType;
    private String province;
    private String city;
    private String area;
    private String street;
    private String loginStatus;
}
