package com.xmu.soa.payclient.controller;

import com.xmu.soa.payclient.dto.LoginInfoDTO;
import com.xmu.soa.payclient.dto.RegInfoDTO;
import com.xmu.soa.payclient.entity.User;
import com.xmu.soa.payclient.service.BankService;
import com.xmu.soa.payclient.service.PayAuthService;
import com.xmu.soa.payclient.vo.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by status200 on 2017/12/28.
 */
@RestController
public class AuthController {

    private final PayAuthService payAuthService;

    private final BankService bankService;

    public AuthController(PayAuthService payAuthService, BankService bankService) {
        this.payAuthService = payAuthService;
        this.bankService = bankService;
    }

    @PostMapping("/register")
    public ResponseEntity<SimpleResponse> register(@RequestBody RegInfoDTO dto) {

        // 调用服务验证手机号
        // 若重复，返回code 101,手机号已经被注册
        if(payAuthService.authTelephone(dto.getTelephone())) {
            return new ResponseEntity<>(new SimpleResponse(101, "手机号已经被重复"), HttpStatus.NOT_ACCEPTABLE);
        }

        // 调用服务验证银行卡
        // 若绑定银行卡错误，返回code 102,银行卡不存在
        if(!bankService.authBankcard(dto.getBankcard())) {
            return new ResponseEntity<>(new SimpleResponse(102, "银行卡不存在"), HttpStatus.NOT_ACCEPTABLE);
        }
        // 调用服务执行注册
        payAuthService.createUser(dto);

        // 返回
        return ResponseEntity.ok(new SimpleResponse(100, "注册完成"));
    }

    @PostMapping("/do-login")
    public ResponseEntity<SimpleResponse> doLogin(@RequestBody LoginInfoDTO dto,HttpSession session) {

        // 调用服务验证用户名密码
        // 验证成功,返回用户信息,并设置session
        // 若用户名密码错误，则返回101
        User user = payAuthService.authUserLogin(dto);
        if(user == null) {
            return new ResponseEntity<>(new SimpleResponse(101, "账号或密码错误"), HttpStatus.NOT_ACCEPTABLE);
        }
        // 创建session
        session.setAttribute("id", user.getId());
        session.setAttribute("telephone",user.getTelephone());
        session.setAttribute("password", user.getPassword());

        // 返回
        return ResponseEntity.ok(new SimpleResponse(100, "登录成功"));
    }

}
