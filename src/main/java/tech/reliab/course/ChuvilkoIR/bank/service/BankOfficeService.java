package tech.reliab.course.ChuvilkoIR.bank.service;

import java.util.Optional;
import tech.reliab.course.ChuvilkoIR.bank.entity.Bank;
import tech.reliab.course.ChuvilkoIR.bank.entity.BankOffice;

import java.util.List;

public interface BankOfficeService {

    /**
     * Создание нового офиса банка.
     *
     * @param name           Название офиса.
     * @param address        Адрес офиса.
     * @param canPlaceAtm   Возможность размещения банкомата в офисе.
     * @param canIssueLoan Возможность выдачи кредитов в офисе.
     * @param cashWithdrawal Возможность снятия наличных в офисе.
     * @param cashDeposit    Возможность пополнения счета в офисе.
     * @param rentCost       Стоимость аренды офиса.
     * @param bank           Банк, которому принадлежит офис.
     * @return Созданный офис банка.
     */
    BankOffice createBankOffice(String name, String address, boolean canPlaceAtm,
                                boolean canIssueLoan, boolean cashWithdrawal, boolean cashDeposit,
                                double rentCost, Bank bank);

    /**
     * Поиск офиса банка по его идентификатору.
     *
     * @param id Идентификатор офиса банка.
     * @return Офис банка, если он найден, иначе - пустой Optional.
     */
    Optional<BankOffice> getBankOfficeById(int id);

    /**
     * Чтение всех офисов банка.
     *
     * @return Список всех офисов банка.
     */
    List<BankOffice> getAllBankOffices();

    /**
     * Обновление информации об офисе банка по его идентификатору.
     *
     * @param id   Идентификатор офиса банка.
     * @param name Новое название офиса банка.
     */
    void updateBankOffice(int id, String name);

    /**
     * Удаление офиса банка по его идентификатору и идентификатору банка.
     *
     * @param officeId Идентификатор офиса банка.
     * @param bankId   Идентификатор банка, которому принадлежит офис.
     */
    void deleteBankAtm(int officeId, int bankId);
}
