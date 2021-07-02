package com.test.mall.controller;

import com.test.mall.form.CartAddForm;
import com.test.mall.form.CartUpdateForm;
import com.test.mall.pojo.User;
import com.test.mall.service.ICartService;
import com.test.mall.vo.CartVo;
import com.test.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.test.mall.consts.MallConsts.CURRENT_USER;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description:
 */
@RestController
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private ICartService cartService;

    //查看购物车
    @GetMapping("/carts")
    public ResponseVo<CartVo> list(HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return cartService.list(user.getId());
    }

    //添加购物车
    @PostMapping("/carts")
    public ResponseVo<CartVo> add(@Valid @RequestBody CartAddForm cartAddForm,
                                  HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return cartService.add(user.getId(), cartAddForm);

    }

    //更新购物车
    @PutMapping("/carts/{productId}")
    public ResponseVo<CartVo> update(@PathVariable Integer productId,
                                     @Valid @RequestBody CartUpdateForm cartUpdateForm,
                                     HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return cartService.update(user.getId(), productId, cartUpdateForm);
    }

    //清除购物车
    @DeleteMapping("/carts/{productId}")
    public ResponseVo<CartVo> delete(@PathVariable Integer productId,
                                     HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return cartService.delete(user.getId(), productId);
    }

    //购物车全选
    @PutMapping("/carts/selectAll")
    public ResponseVo<CartVo> selectAll(HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return cartService.selectAll(user.getId());
    }

    //取消全选购物车
    @PutMapping("/carts/unSelectAll")
    public ResponseVo<CartVo> unSelectAll(HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return cartService.unSelectAll(user.getId());
    }

    //商品数量总和
    @GetMapping("/carts/products/sum")
    public ResponseVo<Integer> sum(HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return cartService.sum(user.getId());
    }
}
