package com.xmu.soa.banktransferprovider.service;

import com.xmu.soa.banktransferprovider.repository.BankcardRepository;
import org.springframework.stereotype.Service;

/**
 * Created by status200 on 2017/12/29.
 */

@Service
public class AuthService {

    private final BankcardRepository bankcardRepository;

    public AuthService(BankcardRepository bankcardRepository) {
        this.bankcardRepository = bankcardRepository;
    }

    public Boolean isBankcardExists(String cardId) {
        return bankcardRepository.countByCardId(cardId) > 0;
    }
}
