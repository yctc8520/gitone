package com.test.mall.controller;

import com.github.pagehelper.PageInfo;
import com.test.mall.form.OrderCreateForm;
import com.test.mall.pojo.User;
import com.test.mall.service.IOrderService;
import com.test.mall.vo.OrderVo;
import com.test.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.test.mall.consts.MallConsts.CURRENT_USER;

/**
 * @author: liu
 * @date: 2020.9.13
 * @description: 订单
 */
@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    //创建订单（商品下单）
    @PostMapping("/orders")
    public ResponseVo<OrderVo> create(@Valid @RequestBody OrderCreateForm form,
                                      HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return orderService.create(user.getId(), form.getShippingId());
    }

    //分页查看订单
    @GetMapping("/orders")
    public ResponseVo<PageInfo> list(@RequestParam Integer pageNum,
                                     @RequestParam Integer pageSize,
                                     HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return orderService.list(user.getId(), pageNum, pageSize);
    }

    //订单详情
    @GetMapping("/orders/{orderNo}")
    public ResponseVo<OrderVo> detail(@PathVariable Long orderNo,
                                      HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return orderService.detail(user.getId(), orderNo);
    }

    //取消订单
    @PutMapping("/orders/{orderNo}")
    public ResponseVo cancel(@PathVariable Long orderNo,
                             HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return orderService.cancel(user.getId(), orderNo);
    }
}
