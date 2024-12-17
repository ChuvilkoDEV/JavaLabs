package tech.reliab.course.ChuvilkoIR.bank.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ToString.Include(name = "name")
    private String fullName;
    @ToString.Include(name = "birth")
    private LocalDate birthDate;
    private String job;
    private double monthlyIncome;
    private int creditRating;
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "user_banks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "bank_id")
    )
    private List<Bank> banks;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<CreditAccount> creditAccounts;

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private List<PaymentAccount> paymentAccounts;

    public User(String fullName, LocalDate birthDate, String job) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.job = job;
    }
}
