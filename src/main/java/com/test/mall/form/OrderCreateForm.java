package com.test.mall.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@Data
public class OrderCreateForm {

    @NotNull
    private Integer shippingId;

}
