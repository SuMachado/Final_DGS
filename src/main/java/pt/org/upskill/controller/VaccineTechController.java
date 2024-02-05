//package pt.org.upskill.controller;
///**
// * @author Nuno Castro anc@isep.ipp.pt
// */
//
//import pt.org.upskill.domain.Employee;
//import pt.org.upskill.domain.VaccineTech;
//import pt.org.upskill.dto.*;
//import pt.org.upskill.repository.Repositories;
//import pt.org.upskill.repository.VaccineTechRepository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class VaccineTechController implements UIable {
//    VaccineTechRepository vaccineTechRepository = Repositories.getInstance().vaccineTechRepository();
//
//    private VaccineTech vaccineTech;
//
//    public void createVaccineTech(int id, String name, String description) {
//        vaccineTech = vaccineTechRepository.createVaccineTech(id, name, description);
//    }
//
//    @Override
//    public void register(DTO dto) throws Exception {
//        VaccineTechDTO vaccineTechDTO = (VaccineTechDTO) dto;
//        try {
//            vaccineTech = new VaccineTech(
//                    vaccineTechDTO.getId(),
//                    vaccineTechDTO.getName(),
//                    vaccineTechDTO.getDescription()
//            );
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public boolean save() {
//        if (vaccineTech != null) {
//            return vaccineTechRepository.save(vaccineTech);
//        }
//        return false;
//    }
//
//
//    public List<KeyValueDTO> keyValueDTOList() {
//       List<VaccineTech> vaccineTechList = vaccineTechRepository.vaccineTechList();
//        List<KeyValueDTO> dtoList = new ArrayList<>();
//       for (VaccineTech item : vaccineTechList) {
//           VaccineTechDTO dto = item.toDTO();
//           dtoList.add(new KeyValueDTO(dto.getId(), dto.getName()));
//       }
//       return dtoList;
//    }
//
//    public boolean confirm() {
//        vaccineTechRepository.save(vaccineTech);
//        return true;
//    }
//    public List<VaccineTech> vaccineTechList() {
//        return vaccineTechRepository.vaccineTechList();
//    }
//}