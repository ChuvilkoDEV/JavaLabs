package tech.reliab.course.ChuvilkoIR.bank;

import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.reliab.course.ChuvilkoIR.bank.entity.Bank;
import tech.reliab.course.ChuvilkoIR.bank.entity.BankAtm;
import tech.reliab.course.ChuvilkoIR.bank.entity.BankOffice;
import tech.reliab.course.ChuvilkoIR.bank.entity.CreditAccount;
import tech.reliab.course.ChuvilkoIR.bank.entity.Employee;
import tech.reliab.course.ChuvilkoIR.bank.entity.PaymentAccount;
import tech.reliab.course.ChuvilkoIR.bank.entity.User;
import tech.reliab.course.ChuvilkoIR.bank.service.BankAtmService;
import tech.reliab.course.ChuvilkoIR.bank.service.BankOfficeService;
import tech.reliab.course.ChuvilkoIR.bank.service.BankService;
import tech.reliab.course.ChuvilkoIR.bank.service.CreditAccountService;
import tech.reliab.course.ChuvilkoIR.bank.service.EmployeeService;
import tech.reliab.course.ChuvilkoIR.bank.service.PaymentAccountService;
import tech.reliab.course.ChuvilkoIR.bank.service.UserService;
import tech.reliab.course.ChuvilkoIR.bank.service.impl.BankAtmServiceImpl;
import tech.reliab.course.ChuvilkoIR.bank.service.impl.BankOfficeServiceImpl;
import tech.reliab.course.ChuvilkoIR.bank.service.impl.BankServiceImpl;
import tech.reliab.course.ChuvilkoIR.bank.service.impl.CreditAccountServiceImpl;
import tech.reliab.course.ChuvilkoIR.bank.service.impl.EmployeeServiceImpl;
import tech.reliab.course.ChuvilkoIR.bank.service.impl.PaymentAccountServiceImpl;
import tech.reliab.course.ChuvilkoIR.bank.service.impl.UserServiceImpl;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

        UserService userService = new UserServiceImpl();
        User user = userService.createUser("Зайцева Ольга Николаевна", LocalDate.now(), "Системный администратор");

        BankService bankService = new BankServiceImpl(userService);
        Bank bank = bankService.createBank("AlphaBank");

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl(bankService);
        BankOffice bankOffice = bankOfficeService.createBankOffice("Главный офис", "Ленина, 10", true, true,
                true, true, 1000, bank);

        EmployeeService employeeService = new EmployeeServiceImpl(bankService);
        Employee employee = employeeService.createEmployee("Сидоров Артём Викторович", LocalDate.now(),
                "Финансовый консультант", bank, false, bankOffice, true, 45000);

        BankAtmService bankAtmService = new BankAtmServiceImpl(bankService);
        BankAtm bankAtm = bankAtmService.createBankAtm("ATM 24/7", "Ленина, 10", bank, bankOffice, employee,
                true, true, 1000);

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl(userService, bankService);
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(user, bank);

        CreditAccountService creditAccountService = new CreditAccountServiceImpl(userService, bankService);
        CreditAccount creditAccount = creditAccountService.createCreditAccount(user, bank, LocalDate.now(), 12,
                750000, 10, employee, paymentAccount);

        System.out.println(bank);
        System.out.println(user);
        System.out.println(bankOffice);
        System.out.println(employee);
        System.out.println(bankAtm);
        System.out.println(paymentAccount);
        System.out.println(creditAccount);
    }
}
