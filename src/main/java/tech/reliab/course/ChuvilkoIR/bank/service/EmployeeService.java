package tech.reliab.course.ChuvilkoIR.bank.service;

import java.util.List;
import tech.reliab.course.ChuvilkoIR.bank.model.dto.EmployeeDTO;
import tech.reliab.course.ChuvilkoIR.bank.model.entity.Employee;
import tech.reliab.course.ChuvilkoIR.bank.model.request.EmployeeRequest;

public interface EmployeeService {
    EmployeeDTO createEmployee(EmployeeRequest employeeRequest);
    EmployeeDTO getEmployeeDTOById(long id);
    Employee getEmployeeById(long id);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO updateEmployee(long id, String name);
    void deleteEmployee(long id);
}