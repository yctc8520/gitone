package com.test.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 购物车
 */
@Data
public class CartVo {

    private List<CartProductVo> cartProductVoList;

    private Boolean selectedAll;

    private BigDecimal cartTotalPrice;

    private Integer cartTotalQuantity;
}
