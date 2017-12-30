package com.xmu.soa.payclient.service;

import com.xmu.soa.payclient.dto.LoginInfoDTO;
import com.xmu.soa.payclient.dto.PayPwdDTO;
import com.xmu.soa.payclient.dto.RegInfoDTO;
import com.xmu.soa.payclient.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by status200 on 2017/12/29.
 */
@FeignClient(name = "pay-authority-consumer")
public interface PayAuthService {

    @PostMapping("/auth/paypwd")
    Boolean authPaypwd(@RequestBody PayPwdDTO dto);

    @PostMapping("/auth/login")
    User authUserLogin(@RequestBody LoginInfoDTO dto);

    @GetMapping("/auth/telephone")
    Boolean authTelephone(@RequestParam("telephone") String telephone);

    @PostMapping("/user")
    User createUser(@RequestBody RegInfoDTO dto);
}
