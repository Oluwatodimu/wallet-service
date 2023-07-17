package io.todimu.practice.ussdwallet.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@Builder
@ToString(exclude = {"currency", "user"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "wallet_asset")
public class WalletAsset extends BaseEntity {

    @Column(name = "available_balance")
    private BigDecimal availableBalance;

    @Column(name = "reserved_balance")
    private BigDecimal reservedBalance;

    private boolean locked;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Override
    public int hashCode() {
        return Objects.hash(
                availableBalance,
                reservedBalance,
                locked
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletAsset walletAsset = (WalletAsset) o;
        return Objects.equals(availableBalance, walletAsset.availableBalance) &&
                Objects.equals(reservedBalance, walletAsset.reservedBalance) &&
                Objects.equals(locked, walletAsset.locked);
    }
}
