package com.xmu.soa.banktransferconsumer.controller;

import com.xmu.soa.banktransferconsumer.service.AllService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("auth/bankcard")
    public Boolean authBankcard(@RequestParam("cardId") String cardId) {
        return allService.authBankcard(cardId);
    }

    @PostMapping("/do-transfer")
    public ResponseEntity doTransfer(@RequestParam("payerCard") String payerCard,
                                     @RequestParam("toCard") String toCard) {

        allService.doTransfer(payerCard, toCard);

        return new ResponseEntity(HttpStatus.OK);
    }
}
