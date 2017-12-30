package com.xmu.soa.payprovider.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by status200 on 2017/12/29.
 */
@FeignClient(name = "bank-transfer-consumer")
public interface TransferService {

    @PostMapping("/do-transfer")
    void transferAToB(@RequestParam("payerCard") String payerCard,
                             @RequestParam("toCard") String toCard);
}
