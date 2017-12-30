package com.xmu.soa.payprovider.service;

import com.xmu.soa.payprovider.dto.OrderDTO;
import com.xmu.soa.payprovider.entity.ExchangeOrder;
import com.xmu.soa.payprovider.repository.OrderRepository;
import com.xmu.soa.payprovider.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by status200 on 2017/12/29.
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public ExchangeOrder createOrderByDTO(OrderDTO dto) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new java.util.Date());

        ExchangeOrder order = new ExchangeOrder();
        order.setPayerId(dto.getPayerId());
        order.setTargetId(dto.getTargetId());
        order.setType(dto.getType());
        order.setBeginTime(new Date(System.currentTimeMillis()));
        order.setStatus(0);

        // 设置交易时间为12个小时
        calendar.setTime(new java.util.Date());
        calendar.add(Calendar.HOUR,12);
        order.setEndTime(new Date(calendar.getTime().getTime()));

        order = orderRepository.save(order);

        Map<String, Object> map = new HashMap<>();
        map.put("id", order.getId());
        map.put("payerId", order.getPayerId());
        map.put("targetId", order.getTargetId());

        // 生成交易秘钥
        String paymentKey = JwtUtil.generateToken(map);

        order.setPaymentKey(paymentKey);

        order = orderRepository.save(order);

        return order;
    }


    public void finishOrder(Integer id) {
        ExchangeOrder order = orderRepository.findOne(id);

        order.setStatus(1);

        orderRepository.save(order);
    }

    public ExchangeOrder findById(Integer id) {
        return orderRepository.findById(id);
    }
}
