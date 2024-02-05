package pt.org.upskill.ui;/*package pt.org.upskill.ui;

import pt.org.upskill.controller.EmployeeControler;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.dto.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class ListEmployeesWithRoleUI extends UI {
private final EmployeeControler employeeControler = new EmployeeControler();

    public void run() {
        System.out.println("");
        System.out.println("LIST EMPLOYEES WITH ROLE");
        System.out.println("-".repeat(30));
        List <EmployeeDTO> listEmployeebyRole = new ArrayList<>();
        int option = Integer.parseInt(readLineFromConsole("Please choose the role: 1 - Receptionist, 2 - Nurse, 3 - Administrator"));
        switch (option) {
            case 1:
                listEmployeebyRole = employeeControler.listEmployeesByRole(Employee.Role.RECEPTIONIST);
                break;
            case 2:
                listEmployeebyRole = employeeControler.listEmployeesByRole(Employee.Role.NURSE);
                break;
            case 3:
                listEmployeebyRole = employeeControler.listEmployeesByRole(Employee.Role.ADMINISTRATOR);
                break;
            default:
                System.out.println("Invalid option");
        }
    }


}
*/