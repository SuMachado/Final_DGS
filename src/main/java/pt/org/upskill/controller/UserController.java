package pt.org.upskill.controller;

import pt.org.upskill.auth.Email;
import pt.org.upskill.auth.Password;
import pt.org.upskill.auth.User;
import pt.org.upskill.domain.Facility;
import pt.org.upskill.domain.Role;
import pt.org.upskill.dto.FacilityDTO;
import pt.org.upskill.repository.Repositories;

import java.util.ArrayList;
import java.util.List;

public class UserController {
/*
    private static UserController UserRepository = Repositories.getInstance().registerUserRepository();

    private static User user;

    public static void CreateUser(String code, Role role, Email email, Password password){
        user=UserRepository.CreateUser(code, role, email, password);

    }

    public List<UserDTO> UserDTOList(List<User> userList ){
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        for (User user: userList){
            userDTO.code = user.code();
            userDTO.role = user.role();
        }
        return userDTOList;
    }


    public boolean confirm() {
        return UserRepository.save(user);
    }
*/
}
