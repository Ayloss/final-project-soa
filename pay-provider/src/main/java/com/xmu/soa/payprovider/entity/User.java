package com.xmu.soa.payprovider.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by status200 on 2017/12/29.
 */
@Entity
@Table(name = "user", schema = "soa")
@Data
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "telephone",nullable = false)
    private String telephone;

    @Column(name = "paypwd",nullable = false)
    private String paypwd;

    @Column(name = "bankcard",nullable = false)
    private String bankcard;

    @Column(name = "password",nullable = false)
    private String password;

}
