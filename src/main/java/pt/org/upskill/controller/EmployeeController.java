package pt.org.upskill.controller;

import pt.org.upskill.domain.Employee;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.repository.EmployeeRepository;
import pt.org.upskill.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController implements UIable {
    private EmployeeRepository employeeRepository = Repositories.getInstance().employeeRepository();

    private Employee employee;

    @Override
    public void register(DTO dto) throws Exception {
        EmployeeDTO employeeDTO = (EmployeeDTO) dto;
        try {
            employee = new Employee(
                    employeeDTO.getEmployeeID(),
                    employeeDTO.getName(),
                    employeeDTO.getPhoneDTO(),
                    employeeDTO.getAddressDTO(),
                    employeeDTO.getBirthdateDTO(),
                    employeeDTO.getEmergencyContactDTO(),
                    employeeDTO.getEmailDTO(),
                    employeeDTO.getRoleDTO(),
                    employeeDTO.getCitizenCardNumberDTO()

            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public boolean save() {
        if (employee != null) {
            return employeeRepository.save(employee);
        }
        return false;
    }

    @Override
    public List<KeyValueDTO> keyValueDTOList() {
        List<Employee> employees = employeeRepository.employeeList();
        List<KeyValueDTO> dtoList = new ArrayList<>();
        for (Employee emp : employees) {
            dtoList.add(new KeyValueDTO(emp.getEmployeeID(), emp.getName()));
        }
        return dtoList;
    }
/*
    public List<KeyValueDTO> getEmployeesWithRole(String role) {
        //List<Employee> employees = employeeRepository.employeeList();
        List<Employee> employees = employeeRepository.getAll();
        List<KeyValueDTO> employeesWithRole = new ArrayList<>();

        for (Employee emp : employees) {
            if (emp.getPosition() != null && emp.getPosition().equalsIgnoreCase(role)) {
                employeesWithRole.add(new KeyValueDTO(emp.getEmail().address(), emp.getName()));
            }
        }

        return employeesWithRole;
    }*/


    /*private static EmployeeRepository employeeRepository = Repositories.getInstance().registerEmployeeRepository();
    private static Employee employee;

    public void createEmployee(String name, int phone, String adress, String birthdate, String emergencyContact, Email email, Employee.Role role, String citizenCardNumber) {
        employee = employeeRepository.createEmployee(name, phone, adress, birthdate, emergencyContact, email, role, citizenCardNumber);;
    }

    public List<EmployeeDTO> employeeList(List <Employee> employeeList) {
        List <EmployeeDTO> employeeDTOList = new ArrayList<>();
        EmployeeDTO employeeDto = new EmployeeDTO();
        for (Employee employee : employeeList) {
            employeeDto.name=employee.name();
            employeeDto.email=employee.email();
            employeeDto.role=employee.role();
            employeeDTOList.add((employeeDto));
        }
        return employeeDTOList;
    }
    public boolean confirm(){
        return employeeRepository.save(employee);
    }
    public List <EmployeeDTO> listEmployeesByRole(Employee.Role role) {
        return employeeRepository.listEmployeesByRole(role);

    }*/
}
