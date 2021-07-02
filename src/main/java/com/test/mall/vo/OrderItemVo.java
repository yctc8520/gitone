package com.test.mall.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@Data
public class OrderItemVo {

    private Long orderNo;

    private Integer productId;

    private String productName;

    private String productImage;

    private BigDecimal currentUnitPrice;

    private Integer quantity;

    private BigDecimal totalPrice;

    private Date createTime;
}
