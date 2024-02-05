package pt.org.upskill.ui;
import pt.org.upskill.controller.EmployeeController;

import static pt.org.upskill.ui.utils.UITools.showKeyValueList;

public class ListEmployees extends UI {

    public void run() {
        System.out.println("");
        System.out.println("LIST EMPLOYEES");
        System.out.println("-----------");

        showKeyValueList("", new EmployeeController().keyValueDTOList());
    }

    /*
    private final EmployeeControler employeeControler = new EmployeeControler();

    public void run() {
        System.out.println("");
        System.out.println("LIST EMPLOYEES");
        System.out.println("-".repeat(30));
        List<EmployeeDTO> listEmployee = new ArrayList<>();

        listEmployee = employeeControler.listEmployee(Employee);
    }*/
}
