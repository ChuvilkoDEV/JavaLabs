package tech.reliab.course.ChuvilkoIR.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
