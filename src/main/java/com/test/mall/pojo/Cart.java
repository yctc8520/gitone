package com.test.mall.pojo;

import lombok.Data;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@Data
public class Cart {

    private Integer productId;

    private Integer quantity;

    private Boolean productSelected;

    public Cart() {
    }

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
