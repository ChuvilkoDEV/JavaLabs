package tech.reliab.course.ChuvilkoIR.bank.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "banks")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private int officeCount = 0;
    private int atmCount = 0;
    private int employeeCount = 0;
    private int clientCount = 0;
    private int rating;
    private double totalMoney;
    private double interestRate;

    @OneToMany(mappedBy = "bank")
    @ToString.Exclude
    private List<BankOffice> offices;

    @OneToMany(mappedBy = "bank")
    @ToString.Exclude
    private List<BankAtm> atms;

    @OneToMany(mappedBy = "bank")
    @ToString.Exclude
    private List<Employee> employees;

    @OneToMany(mappedBy = "bank")
    @ToString.Exclude
    private List<CreditAccount> creditAccounts;

    @OneToMany(mappedBy = "bank")
    @ToString.Exclude
    private List<PaymentAccount> paymentAccounts;

    public Bank(String name) {
        this.name = name;
    }
}