package tech.reliab.course.ChuvilkoIR.bank.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankOfficeRequest {
    private String name;
    private String address;
    private boolean canPlaceAtm;
    private boolean canIssueLoan;
    private boolean cashWithdrawal;
    private boolean cashDeposit;
    private double rentCost;
    private int bankId;
}
