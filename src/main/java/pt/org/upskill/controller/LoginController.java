package pt.org.upskill.controller;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.auth.User;
import pt.org.upskill.repository.Repositories;
import pt.org.upskill.repository.UserRepository;
import pt.org.upskill.session.Context;
import pt.org.upskill.session.Session;

public class LoginController {
    private final UserRepository userRepository;

    public LoginController() {
        this.userRepository = Repositories.getInstance().userRepository();
    }

    public boolean logIn(String email, String  password) throws Exception {//ALTERAR PARA INTEGRAR FACILITY
        User user =  userRepository.userByEmail(email);
        if  ((user != null) && (user.hasPassword(password))) {
            Session session = new Session(user);
            Context.getInstance().setSession(session);
            return true;
        }
        return false;
    }

    public boolean logOut(User user) {
        if  (user != null) {
            Context.getInstance().setSession(null);
            return true;
        }
        return false;
    }
}
