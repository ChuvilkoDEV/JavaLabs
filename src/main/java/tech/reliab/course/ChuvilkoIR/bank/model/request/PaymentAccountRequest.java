package tech.reliab.course.ChuvilkoIR.bank.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentAccountRequest {
    private long bankId;
    private long userId;
}
