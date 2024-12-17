package tech.reliab.course.ChuvilkoIR.bank.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.BankAtm;
import tech.reliab.course.ChuvilkoIR.bank.model.enums.BankAtmStatusEnum;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAtmDTO {
    private long id;
    private String name;
    private String address;
    private boolean cashWithdrawal;
    private boolean cashDeposit;
    private double atmMoney;
    private double maintenanceCost;
    private BankAtmStatusEnum status;
    private String locationAddress;
    private String employeeFullName;
    private String bankName;

    public BankAtmDTO(BankAtm bankAtm) {
        this.id = bankAtm.getId();
        this.name = bankAtm.getName();
        this.address = bankAtm.getAddress();
        this.cashWithdrawal = bankAtm.isCashWithdrawal();
        this.cashDeposit = bankAtm.isCashDeposit();
        this.atmMoney = bankAtm.getAtmMoney();
        this.maintenanceCost = bankAtm.getAtmMoney();
        this.status = bankAtm.getStatus();
        this.locationAddress = bankAtm.getLocation().getAddress();
        this.employeeFullName = bankAtm.getEmployee().getFullName();
        this.bankName = bankAtm.getBank().getName();
    }
}
