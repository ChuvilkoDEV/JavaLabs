package tech.reliab.course.ChuvilkoIR.bank.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Bank;
import tech.reliab.course.ChuvilkoIR.bank.service.impl.BankServiceImpl;
import tech.reliab.course.ChuvilkoIR.bank.annotation.PostgresTestContainer;
import tech.reliab.course.ChuvilkoIR.bank.repository.BankRepository;

import static org.assertj.core.api.Assertions.assertThat;


@PostgresTestContainer
class BankServiceIntegrationTest {

    @Autowired
    private BankServiceImpl bankService;

    @Autowired
    private BankRepository bankRepository;

    @BeforeEach
    void setUp() {
        Bank bank = new Bank();
        bank.setId(0L);
        bank.setName("Test Bank");
        bank.setRating(5);
        bank.setInterestRate(5.0);
        bank.setTotalMoney(1000);

        bankRepository.save(bank);
    }

    @AfterEach
    void clearDatabase() {
        bankRepository.deleteAll();
    }

    @Test
    @DisplayName("Get all banks integration test")
    void getAllBanks() {
        var banks = bankService.getAllBanks();
        Assertions.assertThat(banks).hasSize(1);
        Assertions.assertThat(banks.get(0).getName()).isEqualTo("Test Bank");
    }
}