package tech.reliab.course.ChuvilkoIR.bank.service;

import java.util.List;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.BankAtmDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankAtm;
import tech.reliab.course.ChuvilkoIR.bank.model.request.BankAtmRequest;

public interface BankAtmService {
    BankAtmDTO createBankAtm(BankAtmRequest bankAtmRequest);
    BankAtm getBankAtmById(long id);
    BankAtmDTO getBankAtmDTOById(long id);
    List<BankAtmDTO> getAllBankAtms();
    List<BankAtmDTO> getAllBankAtmsByBankId(long bankId);
    BankAtmDTO updateBankAtm(long id, String name);
    void deleteBankAtm(long id);
}