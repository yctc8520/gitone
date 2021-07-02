package com.test.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginForm {

    //@NotBlank用于String 可以判断空格
    //@NotEmpty用于集合
    //@NotNull仅判断对象是否为空
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
