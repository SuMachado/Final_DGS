package pt.org.upskill.controller;

import pt.org.upskill.domain.SnsUser;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.dto.SnsUserDTO;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.SnsUserRepository;

import java.util.ArrayList;
import java.util.List;

public class SnsUserRegistrationController implements UIable{
    private SnsUserRepository snsUserRepository = Repositories.getInstance().registerSnsUserRepository();

    private SnsUser snsUser;

    public void register(DTO dto) throws Exception {
        SnsUserDTO snsUserDTO = (SnsUserDTO) dto;
        try {
            snsUser = new SnsUser(
                    snsUserDTO.getSnsUserID(),
                    snsUserDTO.getName(),
                    snsUserDTO.getGenderDTO(),
                    snsUserDTO.getPostalAddressDTO(),
                    snsUserDTO.getEmailDTO(),
                    snsUserDTO.getCitizenCardNumberDTO(),
                    snsUserDTO.getSnsUserNumberDTO()

            );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public boolean save() {
        if (snsUser != null) {
            return snsUserRepository.save(snsUser);
        }
        return false;
    }


    @Override
    public List<KeyValueDTO> keyValueDTOList() {
        List<SnsUser> snsUsers = snsUserRepository.snsUserList();
        List<KeyValueDTO> dtoList = new ArrayList<>();
        for (SnsUser snsUser : snsUsers) {
            dtoList.add(new KeyValueDTO(snsUser.getSnsUserID(), snsUser.getName()));
        }
        return dtoList;
    }

    /*
    public boolean confirm(){
        return snsUserRepository.save(snsUser);
    }

    public String getSnsUserbyNumber(String snsUserNumber){
        return snsUserRepository.getBySnsUserNumber(snsUserNumber).name();
    }
*/

}
