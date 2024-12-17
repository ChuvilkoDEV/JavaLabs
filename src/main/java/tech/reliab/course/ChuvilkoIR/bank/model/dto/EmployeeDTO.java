package tech.reliab.course.ChuvilkoIR.bank.model.dto;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankAtm;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Employee;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private String fullName;
    private LocalDate birthDate;
    private String position;
    private String bankName;
    private boolean remoteWork;
    private String bankOfficeName;
    private boolean canIssueLoans;
    private double salary;
    private List<String> bankAtmNames;

    public EmployeeDTO(Employee employee) {
        this.fullName = employee.getFullName();
        this.birthDate = employee.getBirthDate();
        this.position = employee.getPosition();
        this.bankName = employee.getBank().getName();
        this.remoteWork = employee.isRemoteWork();
        this.bankOfficeName = employee.getBankOffice().getName();
        this.canIssueLoans = employee.isCanIssueLoans();
        this.salary = employee.getSalary();
        this.bankAtmNames = employee.getBankAtm().stream().map(BankAtm::getName).toList();
    }
}
