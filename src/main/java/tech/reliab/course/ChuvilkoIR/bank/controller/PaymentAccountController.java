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
import tech.reliab.course.ChuvilkoIR.bank.model.dto.PaymentAccountDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.request.PaymentAccountRequest;
import tech.reliab.course.ChuvilkoIR.bank.service.PaymentAccountService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment-accounts")
public class PaymentAccountController {
    private final PaymentAccountService paymentAccountService;

    @PostMapping
    public ResponseEntity<PaymentAccountDTO> createPaymentAccount(PaymentAccountRequest paymentAccountRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentAccountService.createPaymentAccount(paymentAccountRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentAccount(@PathVariable long id) {
        paymentAccountService.deletePaymentAccount(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PaymentAccountDTO> updatePaymentAccount(@PathVariable long id, long bankId) {
        return ResponseEntity.ok(paymentAccountService.updatePaymentAccount(id, bankId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentAccountDTO> getBankByPaymentAccount(@PathVariable long id) {
        return ResponseEntity.ok(paymentAccountService.getPaymentAccountDTOById(id));
    }

    @GetMapping
    public ResponseEntity<List<PaymentAccountDTO>> getAllPaymentAccounts() {
        return ResponseEntity.ok(paymentAccountService.getAllPaymentAccounts());
    }
}
