package com.xmu.soa.payconsumer.controller;

import com.xmu.soa.payconsumer.dto.OrderDTO;
import com.xmu.soa.payconsumer.dto.PaymentDTO;
import com.xmu.soa.payconsumer.service.AllService;
import com.xmu.soa.payconsumer.vo.OrderVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by status200 on 2017/12/29.
 */
@RestController
public class AllController {

    private final AllService allService;

    public AllController(AllService allService) {
        this.allService = allService;
    }

    @PostMapping("/order")
    public OrderVO createOrder(@RequestBody OrderDTO dto) {
        return allService.createOrder(dto);
    }

    @PostMapping("/do-pay")
    public ResponseEntity doPay(@RequestBody PaymentDTO dto) {

        allService.doPay(dto);

        return new ResponseEntity(HttpStatus.OK);
    }
}
