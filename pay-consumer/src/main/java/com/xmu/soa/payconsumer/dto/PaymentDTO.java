package com.xmu.soa.payconsumer.dto;

import lombok.Data;

/**
 * Created by status200 on 2017/12/28.
 */
@Data
public class PaymentDTO {

    /**
     * 支付秘钥,从中可以解析出订单的信息
     * jwt加密
     */
    private String paymentKey;
}
