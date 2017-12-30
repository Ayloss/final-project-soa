package com.xmu.soa.payauthorityprovider.service;

import com.xmu.soa.payauthorityprovider.dto.RegInfoDTO;
import com.xmu.soa.payauthorityprovider.entity.User;
import com.xmu.soa.payauthorityprovider.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by status200 on 2017/12/29.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Integer id) {
        return userRepository.findOne(id);
    }

    public User createUserByDTO(RegInfoDTO dto) {

        User user = new User();
        user.setBankcard(dto.getBankcard());
        user.setPaypwd(dto.getPaypwd());
        user.setPassword(dto.getPassword());
        user.setTelephone(dto.getTelephone());

        return userRepository.save(user);
    }
}
