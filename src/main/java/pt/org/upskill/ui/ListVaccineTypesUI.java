//package pt.org.upskill.ui;
///**
// * @author Nuno Castro anc@isep.ipp.pt
// */
//
//import pt.org.upskill.controller.VaccineTechController;
//import pt.org.upskill.controller.VaccineTypeController;
//import pt.org.upskill.domain.VaccineType;
//
//import java.util.List;
//
//public class ListVaccineTypesUI extends UI {
//
//    private final VaccineTypeController vaccineTypeController = new VaccineTypeController();
//    private final VaccineTechController vaccineTechController = new VaccineTechController();
//
//    public void run() {
//        System.out.println("");
//        System.out.println("LIST VACCINE TYPES");
//        System.out.println("-----------");
//
//        try {
//            List<VaccineType> vaccineTypeList = vaccineTypeController.vaccineTypeList();
//            for (VaccineType vaccineType : vaccineTypeList) {
//                System.out.println(vaccineType.code() + " - " + vaccineType.shortDescription() + " - " + vaccineType.vaccineTech().description());
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//
//
//}