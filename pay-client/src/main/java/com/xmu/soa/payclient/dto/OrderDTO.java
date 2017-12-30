package com.xmu.soa.payclient.dto;

import lombok.Data;

/**
 * Created by status200 on 2017/12/28.
 */
@Data
public class OrderDTO {

    /**
     * 支付方id
     */
    private Integer payerId;

    /**
     * 目标方id
     */
    private Integer targetId;

    /**
     * 交易类型
     */
    private String type;
}
