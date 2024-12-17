package tech.reliab.course.ChuvilkoIR.bank.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
@NoArgsConstructor
@Entity
@Table(name = "payment_accounts")
public class PaymentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private double balance = 0;

    @ManyToOne
    private User user;

    @ManyToOne
    private Bank bank;

    public PaymentAccount(User user, Bank bank) {
        this.user = user;
        this.bank = bank;
    }
}