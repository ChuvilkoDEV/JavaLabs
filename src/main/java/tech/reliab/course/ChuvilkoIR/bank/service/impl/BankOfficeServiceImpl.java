package tech.reliab.course.ChuvilkoIR.bank.service.impl;

import java.util.NoSuchElementException;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.ChuvilkoIR.bank.model.request.BankOfficeRequest;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.BankOfficeDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Bank;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankOffice;
import tech.reliab.course.ChuvilkoIR.bank.model.enums.BankOfficeStatusEnum;
import tech.reliab.course.ChuvilkoIR.bank.repository.BankOfficeRepository;
import tech.reliab.course.ChuvilkoIR.bank.service.BankOfficeService;

import java.util.List;
import tech.reliab.course.ChuvilkoIR.bank.service.BankService;

@Service
@RequiredArgsConstructor
public class BankOfficeServiceImpl implements BankOfficeService {
    private final BankOfficeRepository bankOfficeRepository;
    private final BankService bankService;

    /**
     * Создание нового офиса банка.
     *
     * @param bankOfficeRequest содержит данные про офис
     * @return Созданный офис банка.
     */
    public BankOfficeDTO createBankOffice(BankOfficeRequest bankOfficeRequest) {
        Bank bank = bankService.getBankById(bankOfficeRequest.getBankId());
        BankOffice bankOffice = new BankOffice(bankOfficeRequest.getName(), bankOfficeRequest.getAddress(),
                bankOfficeRequest.isCanPlaceAtm(), bankOfficeRequest.isCanIssueLoan(),
                bankOfficeRequest.isCashWithdrawal(), bankOfficeRequest.isCashDeposit(),
                bankOfficeRequest.getRentCost(), bank);
        bankOffice.setStatus(BankOfficeStatusEnum.randomStatus());
        bankOffice.setOfficeMoney(generateOfficeMoney(bank));
        return new BankOfficeDTO(bankOfficeRepository.save(bankOffice));
    }

    /**
     * Генерация случайного количества денег в офисе банка.
     *
     * @param bank Банк, которому принадлежит офис.
     * @return Случайное количество денег в офисе банка.
     */
    private double generateOfficeMoney(Bank bank) {
        return new Random().nextDouble(bank.getTotalMoney());
    }

    /**
     * Поиск офиса банка по его идентификатору.
     *
     * @param id Идентификатор офиса банка.
     * @return Офис банка, если он найден
     * @throws NoSuchElementException Если офис не найден.
     */
    public BankOffice getBankOfficeById(long id) {
        return bankOfficeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("BankOffice was not found"));
    }

    public BankOfficeDTO getBankOfficeDTOById(long id) {
        return new BankOfficeDTO(getBankOfficeById(id));
    }

    /**
     * Чтение всех офисов банка.
     *
     * @return Список всех офисов банка.
     */
    public List<BankOfficeDTO> getAllBankOffices() {
        return bankOfficeRepository.findAll().stream().map(BankOfficeDTO::new).toList();
    }

    /**
     * Обновление информации об офисе банка по его идентификатору.
     *
     * @param id   Идентификатор офиса банка.
     * @param name Новое название офиса банка.
     */
    public BankOfficeDTO updateBankOffice(long id, String name) {
        BankOffice bankOffice = getBankOfficeById(id);
        bankOffice.setName(name);
        return new BankOfficeDTO(bankOfficeRepository.save(bankOffice));
    }

    /**
     * Удаление офиса банка по его идентификатору
     *
     * @param id Идентификатор офиса банка.
     */
    public void deleteBankAtm(long id) {
        bankOfficeRepository.deleteById(id);
    }
}
