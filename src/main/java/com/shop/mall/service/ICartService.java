package com.shop.mall.service;

import com.shop.mall.form.CartAddForm;
import com.shop.mall.form.CartUpdateForm;
import com.shop.mall.pojo.Cart;
import com.shop.mall.vo.CartVo;
import com.shop.mall.vo.ResponseVo;

import java.util.List;

public interface ICartService {

    ResponseVo<CartVo> add(Integer uid,CartAddForm form);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm form);

    ResponseVo<CartVo> delete(Integer uid,Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unSelectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);

    List<Cart> ListForCart(Integer uid);
}
