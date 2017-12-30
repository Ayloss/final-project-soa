package com.xmu.soa.payauthorityconsumer.controller;

import com.xmu.soa.payauthorityconsumer.dto.LoginInfoDTO;
import com.xmu.soa.payauthorityconsumer.dto.PaypwdDTO;
import com.xmu.soa.payauthorityconsumer.dto.RegInfoDTO;
import com.xmu.soa.payauthorityconsumer.entity.User;
import com.xmu.soa.payauthorityconsumer.service.AllService;
import org.springframework.web.bind.annotation.*;

/**
 * Created by status200 on 2017/12/29.
 */
@RestController
public class AllController {

    private final AllService allService;

    public AllController(AllService allService) {
        this.allService = allService;
    }

    @GetMapping("/auth/telephone")
    public Boolean authTelephone(@RequestParam("telephone") String telephone) {
        return allService.authTelephone(telephone);
    }

    @PostMapping("/auth/login")
    public User authUserLogin(@RequestBody LoginInfoDTO dto) {
        return allService.authUserLogin(dto);
    }

    @PostMapping("/auth/paypwd")
    public Boolean authPaypwd(@RequestBody PaypwdDTO dto) {
        return allService.authPaypwd(dto);
    }

    @GetMapping("/user")
    public User getUserInfo(@RequestParam("id") Integer id) {
        return allService.getUserInfo(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody RegInfoDTO dto) {
        return allService.createUser(dto);
    }
}
