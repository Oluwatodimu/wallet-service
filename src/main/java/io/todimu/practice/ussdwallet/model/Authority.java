package io.todimu.practice.ussdwallet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "authority")
public class Authority extends BaseEntity {

    @Column(name = "authority_name")
    private String authorityName;
}
