package tech.reliab.course.ChuvilkoIR.bank.service;

import java.util.List;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.PaymentAccountDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.PaymentAccount;
import tech.reliab.course.ChuvilkoIR.bank.model.request.PaymentAccountRequest;

public interface PaymentAccountService {
    PaymentAccountDTO createPaymentAccount(PaymentAccountRequest paymentAccountRequest);
    PaymentAccount getPaymentAccountById(long id);
    PaymentAccountDTO getPaymentAccountDTOById(long id);
    List<PaymentAccountDTO> getAllPaymentAccounts();
    PaymentAccountDTO updatePaymentAccount(long id, long bankId);
    void deletePaymentAccount(long id);
}