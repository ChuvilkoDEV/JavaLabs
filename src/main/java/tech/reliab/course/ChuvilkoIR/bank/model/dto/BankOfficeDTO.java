package tech.reliab.course.ChuvilkoIR.bank.model.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankAtm;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankOffice;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Employee;
import tech.reliab.course.ChuvilkoIR.bank.model.enums.BankOfficeStatusEnum;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankOfficeDTO {
    private String name;
    private String address;
    private BankOfficeStatusEnum status;
    private boolean canPlaceAtm;
    private boolean canIssueLoan;
    private boolean cashWithdrawal;
    private boolean cashDeposit;
    private double officeMoney;
    private double rentCost;
    private List<String> atmNames;
    private String bankName;
    private List<String> employeeFullNames;

    public BankOfficeDTO(BankOffice bankOffice) {
        this.name = bankOffice.getName();
        this.address = bankOffice.getAddress();
        this.status = bankOffice.getStatus();
        this.canPlaceAtm = bankOffice.isCanPlaceAtm();
        this.canIssueLoan = bankOffice.isCanIssueLoan();
        this.cashWithdrawal = bankOffice.isCashWithdrawal();
        this.cashDeposit = bankOffice.isCashDeposit();
        this.officeMoney = bankOffice.getOfficeMoney();
        this.rentCost = bankOffice.getRentCost();
        this.bankName = bankOffice.getBank().getName();
        this.atmNames = bankOffice.getAtms().stream().map(BankAtm::getName).toList();
        this.employeeFullNames = bankOffice.getEmployees().stream().map(Employee::getFullName).toList();
    }
}
