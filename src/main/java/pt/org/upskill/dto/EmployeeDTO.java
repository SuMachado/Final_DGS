package pt.org.upskill.dto;

import pt.org.upskill.auth.Email;
import pt.org.upskill.domain.Employee;

public class EmployeeDTO implements DTO {

    public int employeeID;
    private String name;
    private int phoneDTO;
    private String addressDTO;
    private String birthdateDTO;
    private String emergencyContactDTO;
    private Email emailDTO;
    private Employee.Role roleDTO;
    private String citizenCardNumberDTO;
/*
    public EmployeeDTO (int employeeID, String name, int phone, String address, String birthdate, String emergencyContact, Email email, Employee.Role role, String citizenCardNumber) {
        this.employeeID = employeeID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthdate = birthdate;
        this.emergencyContact = emergencyContact;
        this.email = email;
        this.role = role;
        this.citizenCardNumber = citizenCardNumber;
    }
*/
    public int getEmployeeID() {
        return this.employeeID;
    }

    public String getName() {
        return this.name;
    }

    public Email getEmailDTO() {
        return this.emailDTO;
    }

    public Employee.Role getRoleDTO() {
        return this.roleDTO;
    }

    public int getPhoneDTO() {
        return this.phoneDTO;
    }

    public String getAddressDTO() {
        return this.addressDTO;
    }

    public String getBirthdateDTO() {
        return this.birthdateDTO;
    }

    public String getEmergencyContactDTO() {
        return this.emergencyContactDTO;
    }

    public String getCitizenCardNumberDTO() {
        return this.    citizenCardNumberDTO;
    }

    public EmployeeDTO (final Builder builder) {
        this.employeeID = builder.employeeID;
        this.name = builder.name;
        this.phoneDTO = builder.phoneDTO;
        this.addressDTO = builder.addressDTO;
        this.birthdateDTO = builder.birthdateDTO;
        this.emergencyContactDTO = builder.emergencyContactDTO;
        this.emailDTO = builder.emailDTO;
        this.roleDTO = builder.roleDTO;
        this.citizenCardNumberDTO = builder.citizenCardNumberDTO;
    }

    public static class Builder {
        public enum Role {
            RECEPTIONIST,
            NURSE,
            ADMINISTRATOR
        }

        public int employeeID;
        private String name;
        private int phoneDTO;
        private String addressDTO;
        private String birthdateDTO;
        private String emergencyContactDTO;
        private Email emailDTO;
        private Employee.Role roleDTO;
        private String citizenCardNumberDTO;

        public Builder withEmployeeID(final int employeeID) {
            this.employeeID = employeeID;
            return this;
        }
        public Builder withName(final String name) {
            this.name = name;
            return this;
        }
        public Builder withPhoneDTO(final int phoneDTO) {
            this.phoneDTO = phoneDTO;
            return this;
        }
        public Builder withAddressDTO(final String addressDTO) {
            this.addressDTO = addressDTO;
            return this;
        }
        public Builder withBirthdateDTO(final String birthdateDTO) {
            this.birthdateDTO = birthdateDTO;
            return this;
        }
        public Builder withEmergencyContactDTO(final String emergencyContactDTO) {
            this.emergencyContactDTO = emergencyContactDTO;
            return this;
        }
        public Builder withEmailDTO(final Email emailDTO) {
            this.emailDTO = emailDTO;
            return this;
        }
        public Builder withRoleDTO(final Employee.Role roleDTO) {
            this.roleDTO = roleDTO;
            return this;
        }
        public Builder withCitizenCardNumberDTO(final String citizenCardNumberDTO) {
            this.citizenCardNumberDTO = citizenCardNumberDTO;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(this);
        }
    }
}
