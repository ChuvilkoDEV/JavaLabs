package tech.reliab.course.ChuvilkoIR.bank.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Optional<Bank> findById(long id);
    void deleteById(long id);
}
