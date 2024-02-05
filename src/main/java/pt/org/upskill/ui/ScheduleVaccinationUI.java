package pt.org.upskill.ui;

import pt.org.upskill.controller.ScheduleVaccinationController;
import pt.org.upskill.dto.AppointmentDto;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class ScheduleVaccinationUI extends UI {
    private final ScheduleVaccinationController schedulleVaccinationController = new ScheduleVaccinationController();
    private static int counter=0;
    public void run() {
        System.out.println();
        System.out.println("Create Appointment for SNS User");
        System.out.println("-".repeat(30));
        createAppointment();
    }

    public void createAppointment() {
        try {
            int appointmentID = ++counter;
            String snsUserNumber = readLineFromConsole("Insert SNS User Number: ");
            String facilityID = readLineFromConsole("Insert facilityID: ");
            String vaccineTypeCode = readLineFromConsole("Insert VaccineCode: ");
            String vaccinationDate = readLineFromConsole("Vaccination Date (yyyy-mm-dd):");

//            String[] dateParts = birthDate.split("-");
//            // Converta cada parte para um número inteiro
//            int year = Integer.parseInt(dateParts[0]);
//            int month = Integer.parseInt(dateParts[1]);
//            int day = Integer.parseInt(dateParts[2]);

            //java.sql.Date date = new java.sql.Date(year, month, day);


            AppointmentDto appointmentDto = new AppointmentDto.Builder()
                    .withID(appointmentID)
                    .withDate(vaccinationDate)
                    .withFacilityID(facilityID)
                    .withSNSUser(snsUserNumber)
                    .withVaccineType(vaccineTypeCode)
                    .withStatus("Scheduled")
                    .build();
            boolean invalidOption=true;
            do {
                String option = readLineFromConsole("Appointment created, do you want to save? (Y/N) ");

                switch (option) {
                    case "Y" -> {
                        schedulleVaccinationController.confirmAppointment(appointmentDto);
                        System.out.println("Appointment Saved!");
                        invalidOption = false;
                    }
                    case "N" -> {
                        System.out.println("Appointment not saved!");
                        invalidOption = false;
                    }
                    default -> System.out.println("Option not available!");
                }
            }while(invalidOption);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}