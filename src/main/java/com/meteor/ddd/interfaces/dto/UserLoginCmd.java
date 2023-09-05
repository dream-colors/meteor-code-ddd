package com.meteor.ddd.interfaces.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Data
public class UserLoginCmd {
    @NotBlank(message = "账号不能为空")
    private String account;

    @NotBlank(message = "密码不能为空")
    private String password;
    /**
     * 登录类型
     */
    private String type;
}
