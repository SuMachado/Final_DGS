package pt.org.upskill.dto;

public class VaccineTypeDTO implements DTO {
    private int code;
    private String shortDescription;
    private VaccineTechDTO vaccineTechDTO;

    public int getCode() {
        return getCode();
    }

    public VaccineTechDTO getVaccineTech() {
        return vaccineTechDTO;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getShortDescription() {
        return getShortDescription();
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

       public void setVaccineTechDTO(VaccineTechDTO vaccineTechDTO) {
        this.vaccineTechDTO = vaccineTechDTO;
    }

    public VaccineTypeDTO(final Builder builder) {
        this.code = builder.code;
        this.shortDescription = builder.shortDescription;
        this.vaccineTechDTO = builder.vaccineTechDTO;
    }

    public VaccineTechDTO getVaccineTechDTO() {
        return vaccineTechDTO;
    }

    public static class Builder {
        private int code;
        private String shortDescription;
        private VaccineTechDTO vaccineTechDTO;

        public Builder withCode(final int code) {
            this.code = code;
            return this;
        }

        public Builder withShortDescription(final String shortDescription) {
            this.shortDescription = shortDescription;
            return this;
        }

        public Builder withVaccineTechDTO(final VaccineTechDTO vaccineTechDTO) {
            this.vaccineTechDTO = vaccineTechDTO;
            return this;
        }

        public VaccineTypeDTO build() {
            return new VaccineTypeDTO(this);
        }
    }
}
