package pt.org.upskill.domain;

import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.SnsUserDTO;

public class SnsUser implements DTOable<SnsUserDTO> {

    // public enum Gender {


    //   MALE, FEMALE, OTHER

//}

    public int snsUserID;
    private String name;
    private String gender;
    private String postalAddress;
    private String email;
    private String citizenCardNumber;
    private String snsUserNumber;


    public SnsUser(int snsUserID, String name, String gender, String postalAddress, String email, String citizenCardNumber, String snsUserNumber) {
        this.snsUserID = snsUserID;
        this.name = name;
        this.gender = gender;
        this.postalAddress = postalAddress;
        this.email = email;
        this.citizenCardNumber = citizenCardNumber;
        this.snsUserNumber = snsUserNumber;
    }


    public int getSnsUserID() {return snsUserID;}
    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getPostalAddress() { return postalAddress;}
    public String getEmail() {return email;}
    public String getCitizenCardNumber() {return citizenCardNumber;}
    public String getSnsUserNumber() { return snsUserNumber;}


    //Construtor privado
    private SnsUser(final Builder builder) {
        this.snsUserID = builder.snsUserID;
        this.name = builder.name;
        this.gender = builder.gender;
        this.postalAddress = builder.postalAddress;
        this.email = builder.email;
        this.citizenCardNumber = builder.citizenCardNumber;
        this.snsUserNumber = builder.snsUserNumber;
    }

    public static class Builder {
        public int snsUserID;
        private String name;
        private String gender;
        private String postalAddress;
        private String email;
        private String citizenCardNumber;
        private String snsUserNumber;

        // Setter methods to set values for each attribute
        public Builder withSnsUserID(final int snsUserID) {
            this.snsUserID = snsUserID;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }


        public Builder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder withPostalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }

        public Builder withEmail (String email) {
            this.email = email;
            return this;
        }

        public Builder withCitizenCardNumber (String citizenCardNumber) {
            this.citizenCardNumber = citizenCardNumber;
            return this;
        }

        public Builder withSnsUserNumber (String snsUserNumber) {
            this.snsUserNumber = snsUserNumber;
            return this;
        }


        // Build method to construct an instance of SnsUser using the Builder
        public SnsUser build(){
            return new SnsUser(this);
        }
    }

    @Override
    public SnsUserDTO toDTO() {
        SnsUserDTO.Builder builder = new SnsUserDTO.Builder();
        if (getSnsUserID() != 0) {
            builder.withSnsUserID(getSnsUserID());
        }
        if (name != null) {
            builder.withName(name);
        }

        if (getGender() != null) {
            builder.withGenderDTO(getGender());
        }
        if (getPostalAddress() != null) {
            builder.withPostalAddressDTO(getPostalAddress());
        }
        if (getEmail() != null) {
            builder.withEmailDTO(getEmail());
        }
        if (getCitizenCardNumber() != null) {
            builder.withCitizenCardNumberDTO(getCitizenCardNumber());
        }
        if (getSnsUserNumber() != null) {
            builder.withSnsUserNumberDTO(getSnsUserNumber());
        }
        return builder.build();
    }


}
