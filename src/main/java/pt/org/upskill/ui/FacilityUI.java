/*package pt.org.upskill.ui;

import pt.org.upskill.controller.RegisterFacilityController;
import pt.org.upskill.controller.VaccineTypeController;
import pt.org.upskill.domain.Facility;
import pt.org.upskill.domain.VaccineType;

import java.util.List;
import static pt.org.upskill.ui.utils.Utils.readIntegerFromConsole;
import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class FacilityUI extends UI {/*
    private final VaccineTypeController V = new VaccineTypeController();
    private final RegisterFacilityController registerFacilityController = new RegisterFacilityController();
    private final List<VaccineType>VaccineTypeList=V.getVaccineTypeList();
    public void run() {
        System.out.println("");
        System.out.println("CREATE FACILITY CENTER");
        System.out.println("-".repeat(25));
    }


    public void createFacility() {
        try {
            VaccineType vaccineType = null;
            for (VaccineType vaccineType1 : VaccineTypeList) {
                System.out.println(vaccineType1.code() + " - " + vaccineType1.shortDescription());
            }
            String code = readLineFromConsole("Select Vaccine type code: ");
            for (VaccineType v : VaccineTypeList) {
                if (v.code().equals(code)) {
                    vaccineType = v;
                }
            }
            Facility.FacilityType facilityType;
            int option = readIntegerFromConsole("Select facility type (1 - VACCINATION_CENTER, 2 - HEALTHCARE_CENTER): ");
            facilityType = switch (option) {
                case 1 -> Facility.FacilityType.VACCINATION_CENTER;
                case 2 -> Facility.FacilityType.HEALTHCARE_CENTER;
                default -> Facility.FacilityType.VACCINATION_CENTER;
            };


            String name = readLineFromConsole("Name: ");
            String address = readLineFromConsole("Address: ");
            int phoneNumber = readIntegerFromConsole("Phone Number: ");
            String email = readLineFromConsole("Email: ");
            int faxNumber = readIntegerFromConsole("Fax Number: ");
            String website = readLineFromConsole("Website: ");
            String openingHours = readLineFromConsole("Opening Hours: ");
            String closingHours = readLineFromConsole("Closing Hours: ");
            int maxVaccineCapacityPerHour = readIntegerFromConsole("Max Vaccine Capacity per hour: ");

            RegisterFacilityController.createFacility(vaccineType, facilityType, name, address, phoneNumber, email, faxNumber, website, openingHours, closingHours, maxVaccineCapacityPerHour);

            if (registerFacilityController.confirm()) {
                System.out.println("Facility created successfully!");
            } else {
                System.out.println("An error occurred while creating the facility.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public boolean confirmRegistration() {
        String input = readLineFromConsole("Do you want to confirm the registration? (yes/no): ").toLowerCase();
        return input.equals("yes");
    }
}
*/