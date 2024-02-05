package pt.org.upskill.ui;

import pt.org.upskill.auth.Email;
import pt.org.upskill.controller.EmployeeController;
import pt.org.upskill.domain.Employee.Role;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.EmployeeDTO;

import java.util.Scanner;

import static pt.org.upskill.ui.utils.Utils.readIntegerFromConsole;
import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class CreateEmployeeUI extends UI {

    private final EmployeeController employeeController = new EmployeeController();

    public void run() {
        System.out.println("");
        System.out.println("Create Employee");
        System.out.println("-".repeat(30));
        createEmployee();
    }
    public void createEmployee() {
        try {
            Scanner sc = new Scanner(System.in);
            int employeeID = readIntegerFromConsole("ID: ");
            String name = readLineFromConsole("Name: ");
            int phone = readIntegerFromConsole("Phone: ");
            String address = readLineFromConsole("Adress: ");
            String birthdate = readLineFromConsole("Birthdate: ");
            String emergencyContact = readLineFromConsole("Emergency Contact: ");
            int roleOption = Integer.parseInt(readLineFromConsole("Role: 1 - Administrator, 2 - Nurse, 3 - Receptionist"));
            Role role;
            switch (roleOption) {
                case 1:
                    role = Role.ADMINISTRATOR;
                    break;
                case 2:
                    role = Role.NURSE;
                    break;
                default:
                    role = Role.RECEPTIONIST;
            }
            String emailString = readLineFromConsole("Email: ");
            Email email = new Email(emailString);
            String citizenCardNumber = readLineFromConsole("Citizen Card Number: ");
            //Role role = Role.valueOf(readLineFromConsole("Role: "));

            // Create an EmployeeDTO
            DTO dto = new EmployeeDTO.Builder()
                    .withEmployeeID(employeeID)
                    .withName(name)
                    .withPhoneDTO(phone)
                    .withAddressDTO(address)
                    .withBirthdateDTO(birthdate)
                    .withEmergencyContactDTO(emergencyContact)
                    .withEmailDTO(email)
                    .withRoleDTO(role)
                    .withCitizenCardNumberDTO(citizenCardNumber)
                    .build();
            //(employeeID, name, phone, address, birthdate, emergencyContact, email, option, citizenCardNumber);
            // Register the employee using the controller
            employeeController.register(dto);

            // Save the employee
            if (employeeController.save()) {
                System.out.println("Employee registered successfully.");
            } else {
                System.out.println("Failed to register the employee.");
            }

        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
