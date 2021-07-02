package com.test.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 添加商品
 */
@Data
public class CartAddForm {

    @NotNull
    private Integer productId;

    private Boolean selected = true;
}
