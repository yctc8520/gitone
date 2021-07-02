package com.test.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@Data
public class ShippingForm {

    @NotBlank
    private String receiverName;

    @NotBlank
    private String receiverPhone;

    @NotBlank
    private String receiverProvince;

    @NotBlank
    private String receiverCity;

    @NotBlank
    private String receiverDistrict;

    @NotBlank
    private String receiverAddress;

    @NotBlank
    private String receiverZip;
}
