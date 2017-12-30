package com.xmu.soa.payclient.controller;

import com.xmu.soa.payclient.dto.OrderDTO;
import com.xmu.soa.payclient.dto.PayPwdDTO;
import com.xmu.soa.payclient.dto.PaymentDTO;
import com.xmu.soa.payclient.service.PayAuthService;
import com.xmu.soa.payclient.service.PayService;
import com.xmu.soa.payclient.vo.OrderVO;
import com.xmu.soa.payclient.vo.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by status200 on 2017/12/28.
 */
@RestController
public class PayController {


    private final PayService payService;

    private final PayAuthService payAuthService;

    public PayController(PayService payService, PayAuthService payAuthService) {
        this.payService = payService;
        this.payAuthService = payAuthService;
    }

    @PostMapping("/create-order")
    public ResponseEntity<OrderVO> createOrder(@RequestBody OrderDTO dto, HttpSession session) {

        // 从session中获取支付方id
        if((Integer) session.getAttribute("id") == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        dto.setPayerId((Integer) session.getAttribute("id"));

        // 调用创建订单的服务
        OrderVO vo = payService.createOrder(dto);

        return ResponseEntity.ok(vo);

    }

    @PostMapping("/verify-pay-password")
    public ResponseEntity<SimpleResponse> verifyPayPassword(@RequestBody PayPwdDTO dto,HttpSession session) {

        // 从session中获取支付方id
        if((Integer) session.getAttribute("id") == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        dto.setId((Integer) session.getAttribute("id"));

        // 调用验证支付密码的服务
        // 验证错误,返回101,支付密码错误
        if (!payAuthService.authPaypwd(dto)) {
            return new ResponseEntity<>(new SimpleResponse(101,"支付密码错误"), HttpStatus.NOT_ACCEPTABLE);
        }


        return ResponseEntity.ok(new SimpleResponse(100,"支付密码正确"));
    }

    @PostMapping("/do-pay")
    public ResponseEntity<SimpleResponse> doPay(@RequestBody PaymentDTO paymentDTO,HttpSession session) {

        if((Integer) session.getAttribute("id") == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        // 调用支付接口
        payService.doPay(paymentDTO);

        return ResponseEntity.ok(new SimpleResponse(100,"支付完成"));
    }
}
