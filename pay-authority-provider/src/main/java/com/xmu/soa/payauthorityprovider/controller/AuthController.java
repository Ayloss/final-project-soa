package com.xmu.soa.payauthorityprovider.controller;

import com.xmu.soa.payauthorityprovider.dto.LoginInfoDTO;
import com.xmu.soa.payauthorityprovider.dto.PaypwdDTO;
import com.xmu.soa.payauthorityprovider.entity.User;
import com.xmu.soa.payauthorityprovider.service.AuthService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by status200 on 2017/12/29.
 */
@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/auth/telephone")
    public Boolean authTelephone(@RequestParam("telephone") String telephone) {
        return authService.isTelephoneDuplicate(telephone);
    }

    @PostMapping("/auth/login")
    public User authUserLogin(@RequestBody LoginInfoDTO dto) {
        return authService.authUserByUsername(dto);
    }

    @PostMapping("/auth/paypwd")
    public Boolean authPaypwd(@RequestBody PaypwdDTO dto) {
        return authService.authUserPayPassword(dto);
    }
}
