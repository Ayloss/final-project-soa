package com.xmu.soa.payprovider.controller;

import com.xmu.soa.payprovider.dto.PaymentDTO;
import com.xmu.soa.payprovider.entity.User;
import com.xmu.soa.payprovider.service.OrderService;
import com.xmu.soa.payprovider.service.TransferService;
import com.xmu.soa.payprovider.service.UserService;
import com.xmu.soa.payprovider.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by status200 on 2017/12/29.
 */
@RestController
public class PayController {

    private final OrderService orderService;

    private final TransferService transferService;

    private final UserService userService;

    public PayController(OrderService orderService, TransferService transferService, UserService userService) {
        this.orderService = orderService;
        this.transferService = transferService;
        this.userService = userService;
    }

    @PostMapping("/do-pay")
    public ResponseEntity doPay(@RequestBody PaymentDTO dto) {

        Claims orderData = JwtUtil.getClaimsFromToken(dto.getPaymentKey());

        // 转账
        User payer = userService.getUserInfo(orderData.get("payerId", Integer.class));
        User to = userService.getUserInfo(orderData.get("targetId", Integer.class));
        transferService.transferAToB(payer.getBankcard(),to.getBankcard());

        // 完成订单
        orderService.finishOrder(orderData.get("id",Integer.class));

        return new ResponseEntity(HttpStatus.OK);
    }
}
