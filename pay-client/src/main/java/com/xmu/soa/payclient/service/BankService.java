package com.xmu.soa.payclient.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by status200 on 2017/12/30.
 */
@FeignClient(name = "bank-transfer-consumer")
public interface BankService {

    @GetMapping("auth/bankcard")
    Boolean authBankcard(@RequestParam("cardId") String cardId);
}
