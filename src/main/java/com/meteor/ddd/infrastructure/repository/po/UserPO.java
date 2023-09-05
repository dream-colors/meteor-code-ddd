package com.meteor.ddd.infrastructure.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Data
public class UserPO {
    @TableId(type = IdType.AUTO)
    private Long userId;
    private String name;
    private String mobile;
    private String openId;
    private String unionId;
    private String password;
    private String userType;
    private String province;
    private String city;
    private String area;
    private String street;
    private String loginStatus;
    private LocalDateTime createTime;
}
