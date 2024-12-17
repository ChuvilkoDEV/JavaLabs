package tech.reliab.course.ChuvilkoIR.bank.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.ChuvilkoIR.bank.model.request.PaymentAccountRequest;
import tech.reliab.course.ChuvilkoIR.bank.service.UserService;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.PaymentAccountDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.PaymentAccount;
import tech.reliab.course.ChuvilkoIR.bank.repository.PaymentAccountRepository;
import tech.reliab.course.ChuvilkoIR.bank.service.BankService;
import tech.reliab.course.ChuvilkoIR.bank.service.PaymentAccountService;

@Service
@RequiredArgsConstructor
public class PaymentAccountServiceImpl implements PaymentAccountService {
    private final PaymentAccountRepository paymentAccountRepository;
    private final UserService userService;
    private final BankService bankService;

    /**
     * Создание нового платежного аккаунта.
     *
     * @param paymentAccountRequest содержит информацию о userId и bankId
     * @return Созданный платежный аккаунт.
     */
    public PaymentAccountDTO createPaymentAccount(PaymentAccountRequest paymentAccountRequest) {
        PaymentAccount paymentAccount = new PaymentAccount(userService.getUserById(paymentAccountRequest.getUserId()),
                bankService.getBankById(paymentAccountRequest.getBankId()));
        return new PaymentAccountDTO(paymentAccountRepository.save(paymentAccount));
    }

    /**
     * Чтение платежного аккаунта по его идентификатору.
     *
     * @param id Идентификатор платежного аккаунта.
     * @return Платежный аккаунт
     * @throws NoSuchElementException Если платежный аккаунт не найден.
     */
    public PaymentAccount getPaymentAccountById(long id) {
        return paymentAccountRepository.findById(id).orElseThrow(() -> new NoSuchElementException("PaymentAccount was not found"));
    }

    public PaymentAccountDTO getPaymentAccountDTOById(long id) {
        return new PaymentAccountDTO(getPaymentAccountById(id));
    }
    /**
     * Чтение всех платежных аккаунтов.
     *
     * @return Список всех платежных аккаунтов.
     */
    public List<PaymentAccountDTO> getAllPaymentAccounts() {
        return paymentAccountRepository.findAll().stream().map(PaymentAccountDTO::new).toList();
    }

    /**
     * Обновление информации о платежном аккаунте по его идентификатору.
     *
     * @param id   Идентификатор платежного аккаунта.
     * @param bankId id банка, в котором открыт аккаунт.
     */
    public PaymentAccountDTO updatePaymentAccount(long id, long bankId) {
        PaymentAccount paymentAccount = getPaymentAccountById(id);
        paymentAccount.setBank(bankService.getBankById(bankId));
        return new PaymentAccountDTO(paymentAccountRepository.save(paymentAccount));
    }

    /**
     * Удаление платежного аккаунта по его идентификатору.
     *
     * @param id Идентификатор платежного аккаунта.
     */
    public void deletePaymentAccount(long id) {
        paymentAccountRepository.deleteById(id);
    }
}