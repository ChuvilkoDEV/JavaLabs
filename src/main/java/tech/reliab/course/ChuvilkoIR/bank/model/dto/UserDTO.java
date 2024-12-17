package tech.reliab.course.ChuvilkoIR.bank.model.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Bank;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.CreditAccount;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.PaymentAccount;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String fullName;
    private LocalDate birthDate;
    private String job;
    private double monthlyIncome;
    private int creditRating;
    private List<String> bankNames;
    private List<Double> creditLoanAmounts;
    private List<Double> paymentBalances;

    public UserDTO(User user) {
        this.fullName = user.getFullName();
        this.birthDate = user.getBirthDate();
        this.job = user.getJob();
        this.monthlyIncome = user.getMonthlyIncome();
        this.creditRating = user.getCreditRating();
        this.bankNames = user.getBanks().stream().map(Bank::getName).toList();
        this.creditLoanAmounts = user.getCreditAccounts().stream().map(CreditAccount::getLoanAmount).toList();
        this.paymentBalances = user.getPaymentAccounts().stream().map(PaymentAccount::getBalance).toList();
    }
}
