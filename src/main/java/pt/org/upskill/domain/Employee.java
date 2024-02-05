package pt.org.upskill.domain;

import oracle.net.jdbc.TNSAddress.Address;
import pt.org.upskill.auth.Email;
import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.EmployeeDTO;

public class Employee implements DTOable<EmployeeDTO> {
    public enum Role {
        RECEPTIONIST,
        NURSE,
        ADMINISTRATOR
    }

    public int employeeID;
    private String name;
    private int phone;
    private String address;
    private String birthdate;
    private String emergencyContact;
    private Email email;
    private Role role;
    private String citizenCardNumber;

    public Employee(int employeeID, String name, int phone, String address, String birthdate, String emergencyContact, Email email, Role role, String citizenCardNumber) {
        this.employeeID=employeeID;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthdate = birthdate;
        this.emergencyContact = emergencyContact;
        this.email = email;
        this.role = role;
        this.citizenCardNumber = citizenCardNumber;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Email getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public int getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public String getCitizenCardNumber() {
        return citizenCardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return email.equals(employee.email);
    }

    public boolean hasEmail(String email) {
        return this.email.address().equals(email);
    }

    public Employee(final Builder builder) {
        this.employeeID = builder.employeeID;
        this.name = builder.name;
        this.phone = builder.phone;
        this.address = builder.address;
        this.birthdate = builder.birthdate;
        this.emergencyContact = builder.emergencyContact;
        this.email = builder.email;
        this.role=builder.role;
        this.citizenCardNumber = builder.citizenCardNumber;
    }

    public static class Builder {


        public int employeeID;
        private String name;
        private int phone;
        private String address;
        private String birthdate;
        private String emergencyContact;
        private Email email;
        private Role role;
        private String citizenCardNumber;

        public Builder withEmployeeID(final int employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withPhone(final int phone) {
            this.phone = phone;
            return this;
        }

        public Builder withAddress(final String address) {
            this.address = address;
            return this;
        }

        public Builder withBirthdate(final String birthdate) {
            this.birthdate = birthdate;
            return this;
        }

        public Builder withEmergencyContact(final String emergencyContact) {
            this.emergencyContact = emergencyContact;
            return this;
        }

        public Builder withEmail(final Email email) {
            this.email = email;
            return this;
        }

        public Builder withRole(final Role role) {
            this.role = role;
            return this;
        }

        public Builder withCitizenCardNumber(final String citizenCardNumber) {
            this.citizenCardNumber = citizenCardNumber;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }


    @Override
    public EmployeeDTO toDTO() {
        EmployeeDTO.Builder builder = new EmployeeDTO.Builder();
        if (getEmployeeID() != 0) {
            builder.withEmployeeID(getEmployeeID());
        }
        if (name != null) {
            builder.withName(name);
        }
        if (getPhone() != 0) {
            builder.withPhoneDTO(getPhone());
        }
        if (getAddress() != null) {
            builder.withAddressDTO(getAddress());
        }
        if (getBirthdate() != null) {
            builder.withBirthdateDTO(getBirthdate());
        }
        if (getEmergencyContact() != null) {
            builder.withEmergencyContactDTO(getEmergencyContact());
        }
        if (getRole() != null) {
            builder.withRoleDTO(getRole());
        }
        if (getEmail() != null) {
            builder.withEmailDTO((getEmail()));
        }
        if (getCitizenCardNumber() != null) {
            builder.withCitizenCardNumberDTO(getCitizenCardNumber());
        }
        return builder.build();
    }
}