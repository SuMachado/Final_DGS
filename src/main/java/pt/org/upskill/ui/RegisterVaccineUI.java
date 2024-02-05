package pt.org.upskill.ui;

import pt.org.upskill.controller.VaccineController;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.VaccineDTO;

import java.util.List;

import static pt.org.upskill.ui.utils.Utils.readIntegerFromConsole;
import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class RegisterVaccineUI extends UI {

    private final VaccineController vaccineController = new VaccineController();
    //private final VaccineTypeController vaccineTypeController = new VaccineTypeController();
    //private final BrandController brandController = new BrandController();

    public void run() {
        System.out.println("");
        System.out.println("CREATE VACCINE");
        System.out.println("-----------");

        try {
            //List<VaccineType> vaccineTypeList = vaccineTypeController.vaccineTypeList();
            //            System.out.println("Vaccine Types");
            //            for (VaccineType vaccineType : vaccineTypeList) {
            //                System.out.println(vaccineType.code() + " - " + vaccineType.shortDescription());
            //            }
            //int vaccineTypeCode = readIntegerFromConsole("Select a vaccine type: ");

//            List<Brand> brandList = brandController.brandList();
//            System.out.println("Brands");
//            for (Brand brand : brandList) {
//                System.out.println(brand.name());
//            }

            int vaccineID = readIntegerFromConsole("ID: ");
            String vaccineName = readLineFromConsole("Vaccine Name: ");
            String vaccineType = readLineFromConsole("VaccineType: ");
            String brandName = readLineFromConsole("Brand: ");

            DTO dto = new VaccineDTO.Builder()
                    .withVaccineIDDTO(vaccineID)
                    .withNameDTO(vaccineName)
                    .withBrandDTO(brandName)
                    .withVaccineTypeDTO(vaccineType)
                    .build();


            //Set data
            vaccineController.register(dto);

            if (vaccineController.save()) {
                System.out.println("vaccine registered successfully.");
            } else {
                System.out.println("Failed to register the vaccine.");
            }


            //Confirm
            //vaccineController.confirm();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());        }
    }
}
