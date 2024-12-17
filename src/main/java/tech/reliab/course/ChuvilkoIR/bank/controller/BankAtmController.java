package tech.reliab.course.ChuvilkoIR.bank.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.BankAtmDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.request.BankAtmRequest;
import tech.reliab.course.ChuvilkoIR.bank.service.BankAtmService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/atms")
public class BankAtmController {
    private final BankAtmService bankAtmService;

    @GetMapping
    public ResponseEntity<List<BankAtmDTO>> getAllBankAtms() {
        return ResponseEntity.ok(bankAtmService.getAllBankAtms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAtmDTO> getBankAtmById(@PathVariable Long id) {
        return ResponseEntity.ok(bankAtmService.getBankAtmDTOById(id));
    }

    @PostMapping
    public ResponseEntity<BankAtmDTO> createBankAtm(BankAtmRequest bankAtmRequest) {
        return ResponseEntity.ok(bankAtmService.createBankAtm(bankAtmRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BankAtmDTO> updateBankAtm(@PathVariable Long id, String name) {
        return ResponseEntity.ok(bankAtmService.updateBankAtm(id, name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankAtm(@PathVariable Long id) {
        bankAtmService.deleteBankAtm(id);
        return ResponseEntity.ok().build();
    }
}
