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
import tech.reliab.course.ChuvilkoIR.bank.model.dto.BankOfficeDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.request.BankOfficeRequest;
import tech.reliab.course.ChuvilkoIR.bank.service.BankOfficeService;

@RestController
@RequestMapping("/api/offices")
@RequiredArgsConstructor
public class BankOfficeController {
    private final BankOfficeService bankOfficeService;

    @GetMapping
    public ResponseEntity<List<BankOfficeDTO>> getAllBankOffices() {
        return ResponseEntity.ok(bankOfficeService.getAllBankOffices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankOfficeDTO> getBankOfficeById(@PathVariable Long id) {
        return ResponseEntity.ok(bankOfficeService.getBankOfficeDTOById(id));
    }

    @PostMapping
    public ResponseEntity<BankOfficeDTO> createBankOffice(BankOfficeRequest bankOfficeRequest) {
        return ResponseEntity.ok(bankOfficeService.createBankOffice(bankOfficeRequest));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BankOfficeDTO> updateBankOffice(@PathVariable Long id, String name) {
        return ResponseEntity.ok(bankOfficeService.updateBankOffice(id, name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBankOffice(@PathVariable Long id) {
        bankOfficeService.deleteBankAtm(id);
        return ResponseEntity.ok().build();
    }
}
