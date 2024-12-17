package tech.reliab.course.ChuvilkoIR.bank.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankAtm;

public interface BankAtmRepository extends JpaRepository<BankAtm, Long> {
    List<BankAtm> findAllByBankId(long id);

}
