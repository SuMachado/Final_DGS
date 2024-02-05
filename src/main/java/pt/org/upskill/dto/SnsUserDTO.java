package pt.org.upskill.dto;

public class SnsUserDTO implements DTO{
    // public enum Gender {

    //   MALE, FEMALE, OTHER
    //}

    public int snsUserID;
    private String name;
    private String genderDTO;
    private String postalAddressDTO;
    private String emailDTO;
    private String citizenCardNumberDTO;
    private String snsUserNumberDTO;



    public int getSnsUserID() {return this.snsUserID;}
    public String getName() { return this.name; }
    public String getGenderDTO() { return this.genderDTO; }
    public String getPostalAddressDTO() { return this.postalAddressDTO;}
    public String getEmailDTO() {return this.emailDTO;}
    public String getCitizenCardNumberDTO() {return this.citizenCardNumberDTO;}
    public String getSnsUserNumberDTO() { return this.snsUserNumberDTO;}


    public SnsUserDTO (final Builder builder) {
        this.snsUserID = builder.snsUserID;
        this.name = builder.name;
        this.genderDTO = builder.genderDTO;
        this.postalAddressDTO = builder.postalAddressDTO;
        this.emailDTO = builder.emailDTO;
        this.citizenCardNumberDTO = builder.citizenCardNumberDTO;
        this.snsUserNumberDTO = builder.snsUserNumberDTO;
    }

    public static class Builder {
        public int snsUserID;
        private String name;
        private String genderDTO;
        private String postalAddressDTO;
        private String emailDTO;
        private String citizenCardNumberDTO;
        private String snsUserNumberDTO;

        // Setter methods to set values for each attribute
        public Builder withSnsUserID(final int snsUserID) {
            this.snsUserID = snsUserID;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withGenderDTO(String genderDTO) {
            this.genderDTO = genderDTO;
            return this;
        }

        public Builder withPostalAddressDTO(String postalAddressDTO) {
            this.postalAddressDTO = postalAddressDTO;
            return this;
        }

        public Builder withEmailDTO (String emailDTO) {
            this.emailDTO = emailDTO;
            return this;
        }

        public Builder withCitizenCardNumberDTO (String citizenCardNumberDTO) {
            this.citizenCardNumberDTO = citizenCardNumberDTO;
            return this;
        }

        public Builder withSnsUserNumberDTO (String snsUserNumberDTO) {
            this.snsUserNumberDTO = snsUserNumberDTO;
            return this;
        }

        // Build method to construct an instance of SnsUser using the Builder
        public SnsUserDTO build(){
            return new SnsUserDTO(this);
        }
    }
}
