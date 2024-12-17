package tech.reliab.course.ChuvilkoIR.bank.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.CreditAccountDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.request.CreditAccountRequest;
import tech.reliab.course.ChuvilkoIR.bank.service.CreditAccountService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/credit-accounts")
public class CreditAccountController {
    private final CreditAccountService creditAccountService;

    @PostMapping
    public ResponseEntity<CreditAccountDTO> createCreditAccount(CreditAccountRequest creditAccountRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(creditAccountService.createCreditAccount(creditAccountRequest));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCreditAccount(long id) {
        creditAccountService.deleteCreditAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CreditAccountDTO> updateCreditAccount(@PathVariable long id, long bankId) {
        return ResponseEntity.ok(creditAccountService.updateCreditAccount(id, bankId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditAccountDTO> getBankByCreditAccount(@PathVariable long id) {
        return ResponseEntity.ok(creditAccountService.getCreditAccountDTOById(id));
    }

    @GetMapping
    public ResponseEntity<List<CreditAccountDTO>> getAllCreditAccounts() {
        return ResponseEntity.ok(creditAccountService.getAllCreditAccounts());
    }
}
