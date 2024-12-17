package tech.reliab.course.ChuvilkoIR.bank.model.request;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeRequest {
    private String fullName;
    private LocalDate birthDate;
    private String position;
    private int bankId;
    private boolean remoteWork;
    private int bankOfficeId;
    private boolean canIssueLoans;
    private double salary;
}
