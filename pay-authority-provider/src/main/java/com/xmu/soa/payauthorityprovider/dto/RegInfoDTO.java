package com.xmu.soa.payauthorityprovider.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by status200 on 2017/12/28.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegInfoDTO {

    private String telephone;
    private String password;
    private String paypwd;
    private String bankcard;
}
