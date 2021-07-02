package com.test.mall.enums;

import lombok.Getter;
/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 自定义状态码
 */
@Getter
public enum  ResponseEnum {

    ERROR(-1, "服务端错误"),

    SUCCESS(0, "成功"),

    PASSWORD_ERROR(1, "密码错误"),

    USER_EXIST(2, "用户已存在"),

    PARAM_ERROR(3, "参数错误"),

    EMAIL_EXIST(4, "邮箱已存在"),

    NEED_LOGIN(10, "用户未登录，请先登录"),

    USERNAME_OR_PASSWORD_ERROR(11, "用户名或密码错误"),

    PRODUCT_OFF_SALE_OR_DELETE( 12, "商品下架或者删除"),

    PRODUCT_NOT_EXIST(13, "商品不存在"),

    PRODUCT_STOCK_ERROR(14, "库存不正确"),

    CART_PRODUCT_NOT_EXIST(15, "购物车无此商品"),

    DELETE_SHIPPING_FAILED(16, "删除收货地址失败"),

    SHIPPING_NOT_EXIST(17,"地址不存在"),

    CART_SELECTED_IS_EMPTY(18, "请选择商品后下单"),

    ORDER_NOT_EXIST(19, "订单不存在"),

    ORDER_STATUS_ERROR(20, "订单状态有误"),

        ;

    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
