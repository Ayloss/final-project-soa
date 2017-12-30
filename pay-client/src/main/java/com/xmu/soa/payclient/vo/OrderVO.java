package com.xmu.soa.payclient.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by status200 on 2017/12/28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVO {

    /**
     * 订单id
     */
    private Integer id;

    /**
     * 支付秘钥,从中可以解析出订单的信息
     * jwt加密
     */
    private String paymentKey;
}
