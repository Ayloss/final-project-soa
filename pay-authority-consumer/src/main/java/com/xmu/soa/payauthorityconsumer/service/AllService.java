package com.xmu.soa.payauthorityconsumer.service;

import com.xmu.soa.payauthorityconsumer.dto.LoginInfoDTO;
import com.xmu.soa.payauthorityconsumer.dto.PaypwdDTO;
import com.xmu.soa.payauthorityconsumer.dto.RegInfoDTO;
import com.xmu.soa.payauthorityconsumer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by status200 on 2017/12/29.
 */
@FeignClient(name = "pay-authority-provider")
public interface AllService {

    @GetMapping("/auth/telephone")
    Boolean authTelephone(@RequestParam("telephone") String telephone);

    @PostMapping("/auth/login")
    User authUserLogin(@RequestBody LoginInfoDTO dto);

    @PostMapping("/auth/paypwd")
    Boolean authPaypwd(@RequestBody PaypwdDTO dto);

    @GetMapping("/user")
    User getUserInfo(@RequestParam("id") Integer id);

    @PostMapping("/user")
    User createUser(@RequestBody RegInfoDTO dto);
}
