package io.todimu.practice.ussdwallet.model;

import io.todimu.practice.ussdwallet.enums.CurrencySymbol;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@ToString(exclude = {"walletAssets", "transactions"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "currency")
public class Currency extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private CurrencySymbol symbol;

    private boolean enabled;

    private boolean supported;

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL)
    private Set<WalletAsset> walletAssets = new HashSet<>();

    @OneToMany(mappedBy = "currency", cascade = CascadeType.ALL)
    private Set<Transaction> transactions = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                symbol,
                enabled,
                supported
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(name, currency.name) &&
                Objects.equals(symbol, currency.symbol) &&
                Objects.equals(enabled, currency.enabled) &&
                Objects.equals(supported, currency.supported);
    }
}
