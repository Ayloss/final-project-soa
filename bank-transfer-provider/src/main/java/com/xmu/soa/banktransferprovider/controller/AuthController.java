package com.xmu.soa.banktransferprovider.controller;

import com.xmu.soa.banktransferprovider.service.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by status200 on 2017/12/29.
 */
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("auth/bankcard")
    public Boolean authBankcard(@RequestParam("cardId") String cardId) {
        return authService.isBankcardExists(cardId);
    }
}
