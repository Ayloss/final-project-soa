package com.xmu.soa.banktransferprovider.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by status200 on 2017/12/29.
 */
@RestController
public class TransferController {

    @PostMapping("/do-transfer")
    public ResponseEntity doTransfer(@RequestParam("payerCard") String payerCard,
                                     @RequestParam("toCard") String toCard){

        return new ResponseEntity(HttpStatus.OK);
    }
}
