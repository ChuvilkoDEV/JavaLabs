package tech.reliab.course.ChuvilkoIR.bank.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.course.ChuvilkoIR.bank.model.enums.BankOfficeStatusEnum;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
@NoArgsConstructor
@Entity
@Table(name = "bank_offices")
public class BankOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String address;
    @Enumerated(EnumType.STRING)
    private BankOfficeStatusEnum status;
    private boolean canPlaceAtm;
    private int atmCount = 0;
    private boolean canIssueLoan;
    private boolean cashWithdrawal;
    private boolean cashDeposit;
    private double officeMoney;
    private double rentCost;

    @OneToMany(mappedBy = "location")
    @ToString.Exclude
    private List<BankAtm> atms;

    @ManyToOne
    private Bank bank;

    @OneToMany(mappedBy = "bankOffice")
    @ToString.Exclude
    private List<Employee> employees;

    public BankOffice(String name, String address, boolean canPlaceAtm, boolean canIssueLoan, boolean cashWithdrawal, boolean cashDeposit, double rentCost, Bank bank) {
        this.name = name;
        this.address = address;
        this.canPlaceAtm = canPlaceAtm;
        this.canIssueLoan = canIssueLoan;
        this.cashWithdrawal = cashWithdrawal;
        this.cashDeposit = cashDeposit;
        this.rentCost = rentCost;
        this.bank = bank;
    }
}