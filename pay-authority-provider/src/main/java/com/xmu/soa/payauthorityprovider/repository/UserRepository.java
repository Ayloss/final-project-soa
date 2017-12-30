package com.xmu.soa.payauthorityprovider.repository;

import com.xmu.soa.payauthorityprovider.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by status200 on 2017/12/29.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {

    int countByTelephone(String telephone);

    User findByTelephone(String telephone);
}
