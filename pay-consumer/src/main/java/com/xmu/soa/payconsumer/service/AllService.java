package com.xmu.soa.payconsumer.service;

import com.xmu.soa.payconsumer.dto.OrderDTO;
import com.xmu.soa.payconsumer.dto.PaymentDTO;
import com.xmu.soa.payconsumer.vo.OrderVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by status200 on 2017/12/29.
 */
@FeignClient(name = "pay-provider")
public interface AllService {

    @PostMapping("/order")
    public OrderVO createOrder(@RequestBody OrderDTO dto);

    @PostMapping("/do-pay")
    public void doPay(@RequestBody PaymentDTO dto);
}
