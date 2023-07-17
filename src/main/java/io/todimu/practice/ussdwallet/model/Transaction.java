package io.todimu.practice.ussdwallet.model;

import io.todimu.practice.ussdwallet.enums.TransactionStatus;
import io.todimu.practice.ussdwallet.enums.TransactionType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@Entity
@Builder
@ToString(exclude = {"currency"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction extends BaseEntity {

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private String reference;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private boolean paid;

    @Override
    public int hashCode() {
        return Objects.hash(
                amount,
                type,
                reference,
                status,
                paid
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction transaction = (Transaction) o;
        return Objects.equals(amount, transaction.amount) &&
                Objects.equals(type, transaction.type) &&
                Objects.equals(reference, transaction.reference) &&
                Objects.equals(status, transaction.status) &&
                Objects.equals(paid, transaction.paid);
    }
}
