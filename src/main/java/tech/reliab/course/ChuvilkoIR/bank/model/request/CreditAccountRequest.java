package tech.reliab.course.ChuvilkoIR.bank.model.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreditAccountRequest {
    private int userId;
    private int bankId;
    private LocalDate startDate;
    private int loanTermMonths;
    private double loanAmount;
    private double interestRate;
    private int employeeId;
    private int paymentAccountId;
}
