package com.test.mall.enums;

import lombok.Getter;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 角色枚举
 */
@Getter
public enum  RoleEnum {
    /**
     * 0-管理员，1-顾客
     *
     */
    ADMIN(0),

    CUSTOMER(1),

    ;
    Integer code;

    RoleEnum(Integer code) {
        this.code = code;
    }
}
