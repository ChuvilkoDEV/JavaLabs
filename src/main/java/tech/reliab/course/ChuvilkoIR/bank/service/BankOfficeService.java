package tech.reliab.course.ChuvilkoIR.bank.service;

import java.util.List;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.BankOfficeDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankOffice;
import tech.reliab.course.ChuvilkoIR.bank.model.request.BankOfficeRequest;

public interface BankOfficeService {
    BankOfficeDTO createBankOffice(BankOfficeRequest bankOfficeRequest);
    BankOffice getBankOfficeById(long id);
    BankOfficeDTO getBankOfficeDTOById(long id);
    List<BankOfficeDTO> getAllBankOffices();
    BankOfficeDTO updateBankOffice(long id, String name);
    void deleteBankAtm(long id);
}
