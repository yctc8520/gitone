package com.test.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@Data
public class CartProductVo {

    private Integer productId;

    //购买的数量
    private Integer quantity;

    private String productName;

    private String productSubTitle;

    private String productMainImage;

    private BigDecimal productPrice;

    private Integer productStatus;

    //等于 productPrice * quantity
    private BigDecimal productTotalPrice;

    private Integer productStock;

    //商品是否选中
    private Boolean productSelected;

    public CartProductVo(Integer productId, Integer quantity, String productName, String productSubTitle, String productMainImage, BigDecimal productPrice, Integer productStatus, BigDecimal productTotalPrice, Integer productStock, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productName = productName;
        this.productSubTitle = productSubTitle;
        this.productMainImage = productMainImage;
        this.productPrice = productPrice;
        this.productStatus = productStatus;
        this.productTotalPrice = productTotalPrice;
        this.productStock = productStock;
        this.productSelected = productSelected;
    }
}
