package pt.org.upskill.ui;/*package pt.org.upskill.ui;

import pt.org.upskill.controller.RegisterFacilityController;
import pt.org.upskill.dto.FacilityDTO;

import java.util.List;
import java.util.Objects;

import static pt.org.upskill.ui.utils.Utils.readLineFromConsole;

public class DeactivateFacilityUI extends UI {
    public void run() {
        System.out.println("");
        System.out.println("DEACTIVATE/ACTIVATE FACILITY");
        System.out.println("-".repeat(25));
    }
    private final RegisterFacilityController registerFacilityController = new RegisterFacilityController();
    private final List<FacilityDTO> facilityDTOList = registerFacilityController.getFacilityList();

    public void deactivateFacility() {


        for (FacilityDTO facilityDTO : facilityDTOList) {
            System.out.println(facilityDTO.name);
        }
        String name = readLineFromConsole("Select facility name: ");
        boolean active = Objects.equals(readLineFromConsole("Facility active (y/n): "), "y");
        registerFacilityController.setActive(name, active);

    }
}
*/