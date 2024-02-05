package pt.org.upskill.ui;

import pt.org.upskill.controller.SnsUserRegistrationController;
import pt.org.upskill.dto.SnsUserDTO;
import pt.org.upskill.dto.DTO;

import java.util.Scanner;

import static pt.org.upskill.ui.utils.Utils.readIntegerFromConsole;
import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class SnsUserRegistrationUI extends UI {

    private final SnsUserRegistrationController snsController = new SnsUserRegistrationController();

    public void run() {
        System.out.println("");
        System.out.println("Create SNS User");
        System.out.println("-".repeat(30));
        createSnsUser();
    }

    public void createSnsUser(){
        try {
            Scanner sc = new Scanner(System.in);
            int snsUserID = readIntegerFromConsole("ID: ");
            String name = readLineFromConsole("Name:");
            String gender = readLineFromConsole("Gender:");
            String postalAddress = readLineFromConsole("Postal Address:");
            String email = readLineFromConsole("Email:");
            String citizenCardNumber = readLineFromConsole("Citizen Card Number:");
            String snsUserNumber = readLineFromConsole("SNS User Number:");

            DTO dto = new SnsUserDTO.Builder()
                    .withSnsUserID(snsUserID)
                    .withName(name)
                    .withGenderDTO(gender)
                    .withPostalAddressDTO(postalAddress)
                    .withEmailDTO(email)
                    .withCitizenCardNumberDTO(citizenCardNumber)
                    .withSnsUserNumberDTO(snsUserNumber)
                    .build();

            snsController.register(dto);

            if(snsController.save()) {
                System.out.println("SNS User registered successfully.");
            } else {
                System.out.println("Failed to register ");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
