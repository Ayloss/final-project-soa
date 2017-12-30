package com.xmu.soa.payprovider.controller;

import com.xmu.soa.payprovider.dto.OrderDTO;
import com.xmu.soa.payprovider.entity.ExchangeOrder;
import com.xmu.soa.payprovider.service.OrderService;
import com.xmu.soa.payprovider.vo.OrderVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by status200 on 2017/12/29.
 */

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public OrderVO createOrder(@RequestBody OrderDTO dto) {

        ExchangeOrder order = orderService.createOrderByDTO(dto);

        OrderVO vo = new OrderVO();
        vo.setId(order.getId());
        vo.setPaymentKey(order.getPaymentKey());

        return vo;
    }
}
