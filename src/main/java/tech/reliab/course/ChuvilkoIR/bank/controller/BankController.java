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
import tech.reliab.course.ChuvilkoIR.bank.model.dto.BankDTO;
import tech.reliab.course.ChuvilkoIR.bank.service.BankService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/banks")
public class BankController {
    private final BankService bankService;

    @PostMapping
    public ResponseEntity<BankDTO> createBank(String name) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bankService.createBank(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankDTO> getBankDTOById(@PathVariable Long id) {
        return ResponseEntity.ok(bankService.getBankDTOById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankById(@PathVariable Long id) {
        bankService.deleteBank(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BankDTO>> getAllBanks() {
        return ResponseEntity.ok(bankService.getAllBanks());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BankDTO> updateBank(@PathVariable Long id, String name) {
        return ResponseEntity.ok(bankService.updateBank(id, name));
    }
}
