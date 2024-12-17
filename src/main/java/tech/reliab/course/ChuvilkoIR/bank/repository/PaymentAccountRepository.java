package tech.reliab.course.ChuvilkoIR.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.PaymentAccount;

public interface PaymentAccountRepository extends JpaRepository<PaymentAccount, Long> {
}
