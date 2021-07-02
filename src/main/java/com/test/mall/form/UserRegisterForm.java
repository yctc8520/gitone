package com.test.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 注册表单
 */
@Data
public class UserRegisterForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String email;
}
