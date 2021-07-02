package com.shop.mall.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {

    ON_SALE(1,"在售"),

    OFF_SALE(2,"下架"),

    DELETE(3,"删除"),
    ;
    Integer code;
    String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
