package com.shop.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data

public class UserRegisterForm {

    //@NotEmpty 用于判断集合是否为空
    //@NotBlank 用于 String 判断空格
    //@NotNull  判断是否为空
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;

}
