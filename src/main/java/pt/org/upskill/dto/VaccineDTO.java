package pt.org.upskill.dto;

public class VaccineDTO implements DTO{
    private int vaccineID;
    private String name;
    private String vaccineType;
    private String brand;


    public int getVaccineID() {
        return vaccineID;
    }

    public String getName() {
        return name;
    }

    public String getVaccineType() {
        return vaccineType;
    }

    public String getBrand() {
        return brand;
    }

    public VaccineDTO(final VaccineDTO.Builder builder) {
        this.vaccineID = builder.vaccineID;
        this.name = builder.name;
        this.vaccineType = builder.vaccineType;
        this.brand = builder.brand;
    }

    public static class Builder{
        private int vaccineID;
        private String name;
        private String vaccineType;
        private String brand;


        public VaccineDTO.Builder withVaccineIDDTO(int vaccineID) {
            this.vaccineID = vaccineID;
            return this;
        }

        public VaccineDTO.Builder withNameDTO(String name) {
            this.name = name;
            return this;
        }
        public VaccineDTO.Builder withVaccineTypeDTO(String vaccineType) {
            this.vaccineType = vaccineType;
            return this;
        }
        public VaccineDTO.Builder withBrandDTO(String brand) {
            this.brand = brand;
            return this;
        }

        public VaccineDTO build() {
            return new VaccineDTO(this);
        }
    }
}
