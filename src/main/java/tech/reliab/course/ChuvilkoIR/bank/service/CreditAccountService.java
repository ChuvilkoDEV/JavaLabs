package tech.reliab.course.ChuvilkoIR.bank.service;

import java.util.List;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.CreditAccountDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.CreditAccount;
import tech.reliab.course.ChuvilkoIR.bank.model.request.CreditAccountRequest;

public interface CreditAccountService {
    CreditAccountDTO createCreditAccount(CreditAccountRequest creditAccountRequest);
    CreditAccount getCreditAccountById(long id);
    CreditAccountDTO getCreditAccountDTOById(long id);
    List<CreditAccountDTO> getAllCreditAccounts();
    CreditAccountDTO updateCreditAccount(long id, long bankId);
    void deleteCreditAccount(long id);
}