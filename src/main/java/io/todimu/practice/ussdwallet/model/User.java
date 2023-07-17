package io.todimu.practice.ussdwallet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.todimu.practice.ussdwallet.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.UUID;

@Data
@Entity
@Table(name = "ussd_user")
public class User extends BaseEntity {

    @Column(name = "user_id", updatable = false)
    private UUID userId;

    @JsonIgnore
    @Column(name = "password_hash")
    private String password;

    @Column(name = "phone_number")
    @Pattern(regexp = "^\\d{13}$")
    private String phoneNumber;

    @Column(name = "activated")
    private Boolean activated = true;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;
}
