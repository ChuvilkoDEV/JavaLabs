package tech.reliab.course.ChuvilkoIR.bank.service;

import java.util.List;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.BankDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Bank;

public interface BankService {
    BankDTO createBank(String bankName);
    Bank getBankById(long id);
    BankDTO getBankDTOById(long id);
    List<BankDTO> getAllBanks();
    BankDTO updateBank(long id, String name);
    void deleteBank(long id);
}
