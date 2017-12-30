package com.xmu.soa.banktransferprovider.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by status200 on 2017/12/29.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bankcard {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "card_id", nullable = true, length = 30)
    private String cardId;

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    private String name;

    @Basic
    @Column(name = "id_number", nullable = true, length = 30)
    private String idNumber;

}
