package pt.org.upskill.controller;

import pt.org.upskill.domain.Vaccine;
import pt.org.upskill.dto.*;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.VaccineRepository;

import java.util.ArrayList;
import java.util.List;

public class VaccineController implements UIable{
    private VaccineRepository vaccineRepository = Repositories.getInstance().vaccineRepository();

    private Vaccine vaccine;


    @Override
    public void register(DTO dto) throws Exception {
        VaccineDTO vaccineDTO = (VaccineDTO) dto;
        try {
            vaccine = new Vaccine(
                    vaccineDTO.getVaccineID(),
                    vaccineDTO.getName(),
                    vaccineDTO.getVaccineType(),
                    vaccineDTO.getBrand()

            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



//    public void createVaccine(int vaccineTypeCode, String brandName, String vaccineName) {
//        VaccineType vaccineType = vaccineTypeRepository.getByCode(vaccineTypeCode);
//        Brand brand = brandRepository.getByName(brandName);
//        vaccine = vaccineRepository.createVaccine(vaccineName, vaccineType, brand);
//    }


    public boolean save() {
        if (vaccine != null) {
            vaccineRepository.save(vaccine);
            return true;
        }
        return false;
    }



    @Override
    public List<KeyValueDTO> keyValueDTOList() {
        List<Vaccine> vaccineList = vaccineRepository.vaccineList();
        List<KeyValueDTO> vaccineDTOList = new ArrayList<>();
        for (Vaccine vaccine : vaccineList) {
            vaccineDTOList.add(new KeyValueDTO(vaccine.getId(), vaccine.getName()));
        }
        return vaccineDTOList;
    }

    //public boolean confirm() {
    //        vaccineRepository.save(vaccine);
    //        return true;
    //    }

}
