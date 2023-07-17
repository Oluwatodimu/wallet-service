package io.todimu.practice.ussdwallet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.todimu.practice.ussdwallet.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Pattern;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@ToString(exclude = {"authorities", "walletAssets"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id", referencedColumnName = "id")}
    )
    private Set<Authority> authorities = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<WalletAsset> walletAssets = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(
                password,
                ussdPin,
                firstName,
                lastName,
                email,
                phoneNumber,
                imageUrl,
                activated,
                passwordResetDate,
                userStatus
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        return Objects.equals(password, other.password) &&
                Objects.equals(ussdPin, other.ussdPin) &&
                Objects.equals(firstName, other.firstName) &&
                Objects.equals(lastName, other.lastName) &&
                Objects.equals(email, other.email) &&
                Objects.equals(phoneNumber, other.phoneNumber) &&
                Objects.equals(imageUrl, other.imageUrl) &&
                Objects.equals(activated, other.activated) &&
                Objects.equals(passwordResetDate, other.passwordResetDate) &&
                Objects.equals(userStatus, other.userStatus);
    }
}
