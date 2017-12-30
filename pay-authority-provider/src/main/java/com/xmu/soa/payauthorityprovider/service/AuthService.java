package com.xmu.soa.payauthorityprovider.service;

import com.xmu.soa.payauthorityprovider.dto.LoginInfoDTO;
import com.xmu.soa.payauthorityprovider.dto.PaypwdDTO;
import com.xmu.soa.payauthorityprovider.entity.User;
import com.xmu.soa.payauthorityprovider.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by status200 on 2017/12/29.
 */
@Service
public class AuthService {


    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean isTelephoneDuplicate(String telephone) {
        return userRepository.countByTelephone(telephone) > 0;
    }

    /**
     * 根据用户名认证用户
     *
     * @param dto
     * @return 如果账户密码都对则返回true
     */
    public User authUserByUsername(LoginInfoDTO dto) {

        User user = userRepository.findByTelephone(dto.getTelephone());

        if(user != null && user.getPassword().equals(dto.getPassword())) {
            return user;
        }

        return user;

    }

    /**
     * 根据id判断支付密码是否正确
     *
     * @param dto
     * @return
     */
    public Boolean authUserPayPassword(PaypwdDTO dto) {
        User user = userRepository.findOne(dto.getId());

        return user != null && user.getPaypwd().equals(dto.getPaypwd());
    }
}
