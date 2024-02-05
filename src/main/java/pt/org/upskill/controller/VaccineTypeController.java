//package pt.org.upskill.controller;
//
//
//import pt.org.upskill.domain.VaccineTech;
//import pt.org.upskill.domain.VaccineType;
//
//import pt.org.upskill.dto.DTO;
//import pt.org.upskill.dto.KeyValueDTO;
//import pt.org.upskill.dto.VaccineTypeDTO;
//import pt.org.upskill.repository.Repositories;
//import pt.org.upskill.repository.VaccineTechRepository;
//import pt.org.upskill.repository.VaccineTypeRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class VaccineTypeController {
//    VaccineTypeRepository vaccineTypeRepository = Repositories.getInstance().vaccineTypeRepository();
//    private VaccineType vaccineType;
//
//
//
//    public List<VaccineType> getVaccineTypeList() {
//        return vaccineTypeRepository.vacTypeList();
//    }
//
//    public void createVaccineType(int code, String shortDescription, int vaccineTechId) {
//        VaccineTechRepository vaccineTechRepository = Repositories.getInstance().vaccineTechRepository();
//        VaccineTech vaccineTech = vaccineTechRepository.getById(vaccineTechId);
//
//        this.vaccineType = vaccineTypeRepository.createVaccineType(code, shortDescription, vaccineTech);
//    }
//
//    public void register(VaccineTypeDTO dto) {
//            vaccineType = vaccineTypeRepository.createVaccineType(dto);
//    }
//
//
//    public boolean save() {
//        if (vaccineType != null) {
//            return vaccineTypeRepository.save(vaccineType);
//        }
//        return false;
//    }
//    public List<VaccineType> vaccineTypeList() {
//        return vaccineTypeRepository.vacTypeList();
//    }
//
//
//    public List<KeyValueDTO> keyValueDTOList() { return vaccineTypeRepository.keyValueDTOList(); }
//    public boolean confirm() {
//        vaccineTypeRepository.save(vaccineType);
//        return true;
//    }
//}