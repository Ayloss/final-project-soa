package com.xmu.soa.payprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by status200 on 2017/12/29.
 */
@Entity
@Table(name = "exchange_order", schema = "soa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "payer_id")
    private Integer payerId;

    @Column(name = "target_id")
    private Integer targetId;

    @Column(name = "type")
    private String type;

    @Column(name = "payment_key")
    private String paymentKey;

    @Column(name = "begin_time")
    private Date beginTime;

    @Column(name = "end_time")
    private Date endTime;

    /**
     * 订单状态,0表示未完成,1表示完成
     */
    @Column(name = "status")
    private Integer status;
}
