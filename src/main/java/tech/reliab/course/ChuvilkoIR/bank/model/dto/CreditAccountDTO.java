package tech.reliab.course.ChuvilkoIR.bank.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.CreditAccount;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditAccountDTO {
    private LocalDate startDate;
    private LocalDate endDate;
    private int loanTermMonths;
    private double loanAmount;
    private double monthlyPayment;
    private double interestRate;
    private String userName;
    private String bankName;
    private String employeeFullName;
    private double paymentAccountBalance;

    public CreditAccountDTO(CreditAccount creditAccount) {
        this.startDate = creditAccount.getStartDate();
        this.endDate = creditAccount.getEndDate();
        this.loanTermMonths = creditAccount.getLoanTermMonths();
        this.loanAmount = creditAccount.getLoanAmount();
        this.monthlyPayment = creditAccount.getMonthlyPayment();
        this.interestRate = creditAccount.getInterestRate();
        this.userName = creditAccount.getUser().getFullName();
        this.bankName = creditAccount.getBank().getName();
        this.employeeFullName = creditAccount.getEmployee().getFullName();
        this.paymentAccountBalance = creditAccount.getPaymentAccount().getBalance();
    }
}
