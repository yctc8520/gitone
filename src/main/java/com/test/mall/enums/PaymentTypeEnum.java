package com.test.mall.enums;

import lombok.Getter;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@Getter
public enum PaymentTypeEnum {

    PAY_ONLINE(1),

    ;
    Integer code;

    PaymentTypeEnum(Integer code) {
        this.code = code;
    }
}
