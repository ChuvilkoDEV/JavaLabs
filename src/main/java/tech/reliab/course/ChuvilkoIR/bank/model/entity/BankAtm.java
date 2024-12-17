package tech.reliab.course.ChuvilkoIR.bank.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tech.reliab.course.ChuvilkoIR.bank.model.enums.BankAtmStatusEnum;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
@NoArgsConstructor
@Entity
@Table(name = "bank_atms")
public class BankAtm {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String address;
    @Enumerated(EnumType.STRING)
    private BankAtmStatusEnum status;
    private boolean cashWithdrawal;
    private boolean cashDeposit;
    private double atmMoney;
    private double maintenanceCost;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private BankOffice location;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Bank bank;

    public BankAtm(String name, String address, Bank bank, BankOffice location, Employee employee, boolean cashWithdrawal, boolean cashDeposit, double maintenanceCost) {
        this.name = name;
        this.address = address;
        this.bank = bank;
        this.location = location;
        this.employee = employee;
        this.cashWithdrawal = cashWithdrawal;
        this.cashDeposit = cashDeposit;
        this.maintenanceCost = maintenanceCost;
    }
}
