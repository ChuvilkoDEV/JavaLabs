package tech.reliab.course.ChuvilkoIR.bank.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.reliab.course.ChuvilkoIR.bank.model.request.EmployeeRequest;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.EmployeeDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Employee;
import tech.reliab.course.ChuvilkoIR.bank.repository.EmployeeRepository;
import tech.reliab.course.ChuvilkoIR.bank.service.BankOfficeService;
import tech.reliab.course.ChuvilkoIR.bank.service.BankService;
import tech.reliab.course.ChuvilkoIR.bank.service.EmployeeService;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BankService bankService;
    private final BankOfficeService bankOfficeService;

    /**
     * Создание нового сотрудника банка.
     *
     * @param employeeRequest информация о сотруднике
     * @return Созданный сотрудник банка.
     */
    public EmployeeDTO createEmployee(EmployeeRequest employeeRequest) {
        Employee employee = new Employee(employeeRequest.getFullName(), employeeRequest.getBirthDate(),
                employeeRequest.getPosition(), bankService.getBankById(employeeRequest.getBankId()),
                employeeRequest.isRemoteWork(), bankOfficeService.getBankOfficeById(employeeRequest.getBankOfficeId()),
                employeeRequest.isCanIssueLoans(), employeeRequest.getSalary());
        return new EmployeeDTO(employeeRepository.save(employee));
    }

    /**
     * Чтение сотрудника по его идентификатору.
     *
     * @param id Идентификатор сотрудника.
     * @return Сотрудник, если он найден
     * @throws NoSuchElementException Если сотрудник не найден.
     */
    public EmployeeDTO getEmployeeDTOById(long id) {
        return new EmployeeDTO(getEmployeeById(id));
    }

    /**
     * Чтение сотрудника по его идентификатору.
     *
     * @param id Идентификатор сотрудника.
     * @return Сотрудник, если он найден
     * @throws NoSuchElementException Если сотрудник не найден.
     */
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee was not found"));
    }

    /**
     * Чтение всех сотрудников.
     *
     * @return Список всех сотрудников.
     */
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeDTO::new).toList();
    }

    /**
     * Обновление информации о сотруднике по его идентификатору.
     *
     * @param id   Идентификатор сотрудника.
     * @param name Новое имя сотрудника.
     */
    public EmployeeDTO updateEmployee(long id, String name) {
        Employee employee = getEmployeeById(id);
        employee.setFullName(name);
        return new EmployeeDTO(employeeRepository.save(employee));
    }

    /**
     * Удаление сотрудника по его идентификатору.
     *
     * @param id Идентификатор сотрудника.
     */
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}