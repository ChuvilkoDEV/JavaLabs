package tech.reliab.course.ChuvilkoIR.bank.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Bank;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankAtm;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankOffice;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.CreditAccount;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Employee;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.PaymentAccount;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO {
    private String name;
    private int rating;
    private double totalMoney;
    private double interestRate;
    private List<String> officeNames;
    private List<String> atmNames;
    private List<String> employeeNames;
    private List<Double> creditAccountLoanAmounts;
    private List<Double> paymentAccountBalances;

    public BankDTO(Bank bank) {
        this.name = bank.getName();
        this.rating = bank.getRating();
        this.totalMoney = bank.getTotalMoney();
        this.interestRate = bank.getInterestRate();
        this.officeNames = bank.getOffices().stream().map(BankOffice::getName).toList();
        this.atmNames = bank.getAtms().stream().map(BankAtm::getName).toList();
        this.employeeNames = bank.getEmployees().stream().map(Employee::getFullName).toList();
        this.creditAccountLoanAmounts = bank.getCreditAccounts().stream().map(CreditAccount::getLoanAmount).toList();
        this.paymentAccountBalances = bank.getPaymentAccounts().stream().map(PaymentAccount::getBalance).toList();
    }
}
