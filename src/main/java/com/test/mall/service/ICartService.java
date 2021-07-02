package com.test.mall.service;

import com.test.mall.form.CartAddForm;
import com.test.mall.form.CartUpdateForm;
import com.test.mall.pojo.Cart;
import com.test.mall.vo.CartVo;
import com.test.mall.vo.ResponseVo;

import java.util.List;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 添加购物车add()
 *              购物车列表查看list()
 *              更新购物车update()
 *              删除购物车某个产品delete()
 */
public interface ICartService {

    ResponseVo<CartVo> add(Integer uid, CartAddForm cartAddForm);

    ResponseVo<CartVo> list(Integer uid);

    ResponseVo<CartVo> update(Integer uid, Integer productId, CartUpdateForm cartUpdateForm);

    ResponseVo<CartVo> delete(Integer uid, Integer productId);

    ResponseVo<CartVo> selectAll(Integer uid);

    ResponseVo<CartVo> unSelectAll(Integer uid);

    ResponseVo<Integer> sum(Integer uid);

    List<Cart> listForCart(Integer uid);
}
