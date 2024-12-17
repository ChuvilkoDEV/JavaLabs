package tech.reliab.course.ChuvilkoIR.bank.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ToString.Include(name = "name")
    private String fullName;
    @ToString.Include(name = "birth")
    private LocalDate birthDate;
    private String position;
    private boolean remoteWork;
    private boolean canIssueLoans;
    private double salary;

    @ManyToOne
    private Bank bank;

    @ManyToOne
    private BankOffice bankOffice;

    @OneToMany(mappedBy = "employee")
    @ToString.Exclude
    private List<BankAtm> bankAtm;

    public Employee(String fullName, LocalDate birthDate, String position, Bank bank, boolean remoteWork, BankOffice bankOffice, boolean canIssueLoans, double salary) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.position = position;
        this.bank = bank;
        this.remoteWork = remoteWork;
        this.bankOffice = bankOffice;
        this.canIssueLoans = canIssueLoans;
        this.salary = salary;
    }
}
