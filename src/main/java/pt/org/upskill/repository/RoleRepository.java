package pt.org.upskill.repository;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

import pt.org.upskill.domain.Role;

import java.util.ArrayList;
import java.util.List;


public class RoleRepository {

    public enum Role {
        RECEPTIONIST,
        NURSE,
        ADMINISTRATOR,
        SNSUSER
    }

    private static final List<Role> roles = new ArrayList<>();

    public boolean add(Role role) {
        try {
            roles.add(role);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Role roleByName(String name) {
        try {
            return Role.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
