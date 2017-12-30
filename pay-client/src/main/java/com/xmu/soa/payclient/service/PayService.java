package com.xmu.soa.payclient.service;

import com.xmu.soa.payclient.dto.OrderDTO;
import com.xmu.soa.payclient.dto.PaymentDTO;
import com.xmu.soa.payclient.vo.OrderVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by status200 on 2017/12/29.
 */
@FeignClient(name = "pay-consumer")
public interface PayService {

    @PostMapping("/order")
    OrderVO createOrder(@RequestBody OrderDTO dto);

    @PostMapping("/do-pay")
    void doPay(@RequestBody PaymentDTO dto);
}
