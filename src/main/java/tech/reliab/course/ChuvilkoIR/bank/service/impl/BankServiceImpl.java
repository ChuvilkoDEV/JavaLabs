package tech.reliab.course.ChuvilkoIR.bank.service.impl;

import java.util.NoSuchElementException;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.BankDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Bank;
import tech.reliab.course.ChuvilkoIR.bank.repository.BankRepository;
import tech.reliab.course.ChuvilkoIR.bank.service.BankService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {
    private static final int RATING_BOUND = 101;
    private static final int TOTAL_MONEY_BOUND = 1000001;
    private static final int MAX_RATE = 20;
    private static final double DIVIDER = 10.0;

    private final BankRepository bankRepository;

    public BankDTO createBank(String bankName) {
        Bank bank = new Bank(bankName);
        bank.setRating(generateRating());
        bank.setTotalMoney(generateTotalMoney());
        bank.setInterestRate(calculateInterestRate(bank.getRating()));
        return new BankDTO(bankRepository.save(bank));
    }

    /**
     * Генерация случайного рейтинга банка.
     *
     * @return Случайный рейтинг банка.
     */
    private int generateRating() {
        return new Random().nextInt(RATING_BOUND);
    }

    /**
     * Генерация случайного количества денег в банке.
     *
     * @return Случайное количество денег в банке.
     */
    private double generateTotalMoney() {
        return new Random().nextInt(TOTAL_MONEY_BOUND);
    }

    /**
     * Вычисление процентной ставки по кредитам.
     *
     * @param rating Рейтинг банка.
     * @return Процентная ставка.
     */
    private double calculateInterestRate(int rating) {
        return MAX_RATE - (rating / DIVIDER);
    }

    public Bank getBankById(long id) {
        return bankRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Bank {" + id + "} was not found"));
    }

    public BankDTO getBankDTOById(long id) {
        return new BankDTO(getBankById(id));
    }

    public List<BankDTO> getAllBanks() {
        return bankRepository.findAll().stream().map(BankDTO::new).toList();
    }

    public BankDTO updateBank(long id, String name) {
        Bank bank = getBankById(id);
        bank.setName(name);
        return new BankDTO(bankRepository.save(bank));
    }

    public void deleteBank(long id) {
        bankRepository.deleteById(id);
    }


    public BankDTO getBankIfExists(long id) {
        return new BankDTO(getBankById(id));
    }
}