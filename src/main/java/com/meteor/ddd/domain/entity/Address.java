package com.meteor.ddd.domain.entity;

import lombok.Data;

/**
 * @author 钟宗兵
 * @since 1.0.0
 */
@Data
public class Address {
    private String province;
    private String city;
    private String area;
    private String street;
}
