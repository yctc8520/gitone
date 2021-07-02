package com.test.mall.enums;

import lombok.Getter;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 商品状态枚举
 */
@Getter
public enum ProductStatusEnum {

    ON_SALE(1),

    OFF_SALE(2),

    DELETE(3),

    ;

    Integer code;

    ProductStatusEnum(Integer code) {
        this.code = code;
    }
}
