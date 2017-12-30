package com.xmu.soa.payclient.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 包装返回的结果
 *
 * Created by status200 on 2017/12/28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleResponse {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;
}
