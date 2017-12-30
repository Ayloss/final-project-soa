package com.xmu.soa.payclient.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by status200 on 2017/12/30.
 */
@Data
@NoArgsConstructor
public class User {

    private Integer id;

    private String telephone;

    private String paypwd;

    private String bankcard;

    private String password;

}
