//package pt.org.upskill.ui;
///**
// * @author Nuno Castro anc@isep.ipp.pt
// */
//
//import pt.org.upskill.controller.VaccineTechController;
//import pt.org.upskill.controller.VaccineTypeController;
//import pt.org.upskill.domain.VaccineTech;
//
//import java.util.List;
//
//import static pt.org.upskill.ui.utils.Utils.readIntegerFromConsole;
//import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;
//
//public class RegisterVaccineTypeUI extends UI {
//    private final VaccineTypeController vaccineTypeController = new VaccineTypeController();
//    private final VaccineTechController vaccineTechController = new VaccineTechController();
//
//    public void run() {
//        System.out.println("");
//        System.out.println("CREATE VACCINE TYPE");
//        System.out.println("-".repeat(30));
//
//        try {
//            int code = readIntegerFromConsole("Vaccine Type Code: ");
//            String shortDescription = readLineFromConsole("Vaccine Type Short Description: ");
//
//            System.out.println("Vaccine Technologies");
//            List<VaccineTech> vaccineTechList = vaccineTechController.vaccineTechList();
//            for (VaccineTech vaccineTech : vaccineTechList) {
//                System.out.println(vaccineTech.id() + " - " + vaccineTech.name());
//            }
//            int key = readIntegerFromConsole("Select a vaccine technology: ");
//
//            //data
//            vaccineTypeController.createVaccineType(code, shortDescription, key);
//
//            //confirmation
//            vaccineTypeController.confirm();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//}