package tech.reliab.course.ChuvilkoIR.bank.model.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRequest {
    private String fullName;
    private LocalDate birthDate;
    private String job;
}
