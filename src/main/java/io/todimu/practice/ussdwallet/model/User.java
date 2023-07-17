package io.todimu.practice.ussdwallet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.todimu.practice.ussdwallet.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.time.Instant;

@Data
@Entity
@Table(name = "ussd_user")
public class User extends BaseEntity {

    @JsonIgnore
    @Column(name = "password_hash")
    private String password;

    @JsonIgnore
    @Column(name = "ussd_pin_hash")
    private String ussdPin;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", updatable = false)
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$")
    private String email;

    @Column(name = "phone_number")
    @Pattern(regexp = "^\\d{13}$")
    private String phoneNumber;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "activated")
    private boolean activated = false;

    @Column(name = "password_reset_date")
    private Instant passwordResetDate = Instant.now();

    @Enumerated(EnumType.STRING)
    @Column(name = "user_status")
    private UserStatus userStatus;
}
