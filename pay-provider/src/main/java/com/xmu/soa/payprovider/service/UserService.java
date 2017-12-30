package com.xmu.soa.payprovider.service;

import com.xmu.soa.payprovider.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by status200 on 2017/12/29.
 */
@FeignClient(name = "pay-authority-consumer")
public interface UserService {

    @GetMapping("/user")
    User getUserInfo(@RequestParam("id") Integer id);
}
