//package pt.org.upskill.ui;
///**
// * @author Nuno Castro anc@isep.ipp.pt
// */
//
//import pt.org.upskill.auth.Email;
//import pt.org.upskill.controller.VaccineTechController;
//import pt.org.upskill.domain.Employee;
//import pt.org.upskill.dto.DTO;
//import pt.org.upskill.dto.EmployeeDTO;
//import pt.org.upskill.dto.VaccineTechDTO;
//
//import java.util.Scanner;
//
//import static pt.org.upskill.ui.utils.Utils.readIntegerFromConsole;
//import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;
//
//public class RegisterVaccineTechUI extends UI {
//    private final VaccineTechController vaccineTechController = new VaccineTechController();
//
//    public void run() {
//        System.out.println("");
//        System.out.println("CREATE VACCINE TECHNOLOGY");
//        System.out.println("-----------");
//        createVaccineTech();
//    }
///*
//        try {
//            Scanner sc = new Scanner(System.in);
//            int id = readIntegerFromConsole("Id: ");
//            String name = readLineFromConsole("Vaccine Technology Name: ");
//            String description = readLineFromConsole("Vaccine Technology Description: ");
//
//            //Set data
//            vaccineTechController.createVaccineTech(id, name, description);
//
//            //Confirm
//            vaccineTechController.confirm();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//*/
//        public void createVaccineTech() {
//            try {
//                Scanner sc = new Scanner(System.in);
//                int id = readIntegerFromConsole("Id: ");
//                String name = readLineFromConsole("Vaccine Technology Name: ");
//                String description = readLineFromConsole("Vaccine Technology Description: ");
//
//                // Create an EmployeeDTO
//                DTO dto = new VaccineTechDTO.Builder()
//                        .withId(id)
//                        .withName(name)
//                        .withDescription(description)
//                        .build();
//                //(employeeID, name, phone, address, birthdate, emergencyContact, email, option, citizenCardNumber);
//                // Register the employee using the controller
//                vaccineTechController.register(dto);
//
//                // Save the vaccineTech
//                if (vaccineTechController.save()) {
//                    System.out.println("vaccineTech registered successfully.");
//                } else {
//                    System.out.println("Failed to register the vaccineTech.");
//                }
//
//            }catch (Exception e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//        }
//    }