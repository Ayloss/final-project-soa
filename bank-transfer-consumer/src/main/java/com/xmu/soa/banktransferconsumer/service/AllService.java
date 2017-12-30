package com.xmu.soa.banktransferconsumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by status200 on 2017/12/29.
 */
@FeignClient(name = "bank-transfer-provider")
public interface AllService {

    @GetMapping("auth/bankcard")
    Boolean authBankcard(@RequestParam("cardId") String cardId);

    @PostMapping("/do-transfer")
    void doTransfer(@RequestParam("payerCard") String payerCard,
                    @RequestParam("toCard") String toCard);
}
