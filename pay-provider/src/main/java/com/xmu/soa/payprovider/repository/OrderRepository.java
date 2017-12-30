package com.xmu.soa.payprovider.repository;

import com.xmu.soa.payprovider.entity.ExchangeOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by status200 on 2017/12/29.
 */
@Repository
public interface OrderRepository extends CrudRepository<ExchangeOrder,Integer>{

    ExchangeOrder findById(Integer id);

    ExchangeOrder findByPaymentKey(String paymentKey);
}
