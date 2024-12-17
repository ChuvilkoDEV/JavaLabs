package tech.reliab.course.ChuvilkoIR.bank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.PaymentAccount;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentAccountDTO {
    private long userId;
    private long bankId;
    private double balance;

    public PaymentAccountDTO(PaymentAccount paymentAccount) {
        this.userId = paymentAccount.getUser().getId();
        this.bankId = paymentAccount.getBank().getId();
        this.balance = paymentAccount.getBalance();
    }
}
