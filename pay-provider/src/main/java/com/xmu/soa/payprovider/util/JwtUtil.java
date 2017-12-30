package com.xmu.soa.payprovider.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;

/**
 * Created by status200 on 2017/12/29.
 */
public class JwtUtil {


    /**
     *  jwt加密秘钥
     *  该秘钥不能太短，否则会报错
     */
    public static String pwdkey = "soap final";

    /**
     * jwt加密算法
     */
    public static SignatureAlgorithm mySignatureAlgorithm = SignatureAlgorithm.HS256;

    /**
     * 产生jwt
     *
     * @param claims
     * @return
     */
    public static String generateToken(Map<String,Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(mySignatureAlgorithm,pwdkey)
                .compact();
    }


    /**
     * 解析token并得到数据
     *
     * @param token
     * @return 类似key value的Map
     */
    public static Claims getClaimsFromToken(String token) {

        Claims claims;
        try {
            claims = Jwts
                    .parser()
                    .setSigningKey(pwdkey)
                    .parseClaimsJws(token)
                    .getBody();

        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
