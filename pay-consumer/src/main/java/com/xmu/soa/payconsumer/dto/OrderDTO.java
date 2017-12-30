package com.xmu.soa.payconsumer.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by status200 on 2017/12/29.
 */
@Data
@NoArgsConstructor
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
