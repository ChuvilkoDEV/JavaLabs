package tech.reliab.course.ChuvilkoIR.bank.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.BankAtmDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Bank;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankAtm;
import tech.reliab.course.ChuvilkoIR.bank.model.enums.BankAtmStatusEnum;
import tech.reliab.course.ChuvilkoIR.bank.model.request.BankAtmRequest;
import tech.reliab.course.ChuvilkoIR.bank.repository.BankAtmRepository;
import tech.reliab.course.ChuvilkoIR.bank.service.BankAtmService;
import tech.reliab.course.ChuvilkoIR.bank.service.BankOfficeService;
import tech.reliab.course.ChuvilkoIR.bank.service.BankService;
import tech.reliab.course.ChuvilkoIR.bank.service.EmployeeService;

@Service
@RequiredArgsConstructor
public class BankAtmServiceImpl implements BankAtmService {
    private final BankAtmRepository bankAtmRepository;
    private final BankService bankService;
    private final BankOfficeService bankOfficeService;
    private final EmployeeService employeeService;


    /**
     * Создание нового банкомата.
     *
     * @param bankAtmRequest данные о банкомате
     * @return Созданный банкомат.
     */
    public BankAtmDTO createBankAtm(BankAtmRequest bankAtmRequest) {
        Bank bank = bankService.getBankById(bankAtmRequest.getBankId());
        BankAtm bankAtm = new BankAtm(bankAtmRequest.getName(), bankAtmRequest.getAddress(), bank,
                bankOfficeService.getBankOfficeById(bankAtmRequest.getLocationId()),
                employeeService.getEmployeeById(bankAtmRequest.getEmployeeId()),
                bankAtmRequest.isCashWithdrawal(), bankAtmRequest.isCashDeposit(), bankAtmRequest.getMaintenanceCost());
        bankAtm.setStatus(BankAtmStatusEnum.randomStatus());
        bankAtm.setAtmMoney(generateAtmMoney(bank));
        return new BankAtmDTO(bankAtmRepository.save(bankAtm));
    }

    /**
     * Генерация случайного количества денег в банкомате.
     *
     * @param bank Банк, которому принадлежит банкомат.
     * @return Случайное количество денег в банкомате.
     */
    private double generateAtmMoney(Bank bank) {
        return new Random().nextDouble(bank.getTotalMoney());
    }

    /**
     * Чтение банкомата по его идентификатору.
     *
     * @param id Идентификатор банкомата.
     * @return Банкомат, если он найден
     * @throws NoSuchElementException Если банкомат не найден.
     */
    public BankAtm getBankAtmById(long id) {
        return bankAtmRepository.findById(id).orElseThrow(() -> new NoSuchElementException("BankAtm was not found"));
    }

    public BankAtmDTO getBankAtmDTOById(long id) {
        return new BankAtmDTO(getBankAtmById(id));
    }

    /**
     * Чтение всех банкоматов.
     *
     * @return Список всех банкоматов.
     */
    public List<BankAtmDTO> getAllBankAtms() {
        return bankAtmRepository.findAll().stream().map(BankAtmDTO::new).toList();
    }

    /**
     * Чтение всех банкоматов определенного банка.
     *
     * @param bankId id банка, для которого нужно получить банкоматы.
     * @return Список банкоматов, принадлежащих указанному банку.
     */
    public List<BankAtmDTO> getAllBankAtmsByBankId(long bankId) {
        return bankAtmRepository.findAllByBankId(bankId).stream().map(BankAtmDTO::new).toList();
    }

    /**
     * Обновление информации о банкомате по его идентификатору.
     *
     * @param id   Идентификатор банкомата.
     * @param name Новое название банкомата.
     */
    public BankAtmDTO updateBankAtm(long id, String name) {
        BankAtm bankAtm = getBankAtmById(id);
        bankAtm.setName(name);
        return new BankAtmDTO(bankAtmRepository.save(bankAtm));
    }

    /**
     * Удаление банкомата по его идентификатору.
     *
     * @param id Идентификатор банкомата.
     */
    public void deleteBankAtm(long id) {
        bankAtmRepository.deleteById(id);
    }
}
