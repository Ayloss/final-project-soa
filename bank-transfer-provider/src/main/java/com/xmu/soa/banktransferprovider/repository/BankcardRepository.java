package com.xmu.soa.banktransferprovider.repository;

import com.xmu.soa.banktransferprovider.entity.Bankcard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by status200 on 2017/12/29.
 */
@Repository
public interface BankcardRepository extends CrudRepository<Bankcard,Integer>{

    int countByCardId(String cardId);
}
