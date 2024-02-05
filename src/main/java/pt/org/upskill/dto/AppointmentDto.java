package pt.org.upskill.dto;

public class AppointmentDto implements DTO {
    public int appointmentDTO_ID;
    public String facilityDTO;
    public String dateDTO;
    public String vaccineTypeCodeDTO;
    public String snsUserNumberDTO;
    //public String observations;
    //public String batch;
    public String statusDTO;

    public int appointmentDTO_ID(){
        return appointmentDTO_ID;
    }
    public String facilityDTO(){
        return facilityDTO;
    };
    public String dateDTO(){
        return dateDTO;
    }
    public String vaccineTypeDTO(){
        return vaccineTypeCodeDTO;
    }
    public String snsUser(){
        return snsUserNumberDTO;
    }

    public String statusDTO() {
        return statusDTO;
    }

    private AppointmentDto(final Builder builder){
        this.appointmentDTO_ID= builder.appointmentDTO_ID;
        this.statusDTO=builder.statusDTO;
        this.facilityDTO= builder.facilityDTO;
        this.vaccineTypeCodeDTO =builder.vaccineTypeCodeDTO;
        this.dateDTO=builder.dateDTO;
        this.snsUserNumberDTO =builder.snsUserNumberDTO;
    }


    public static class Builder{
        private int appointmentDTO_ID;
        private String statusDTO;

        private String facilityDTO;
        private String dateDTO;
        private String vaccineTypeCodeDTO;
        private String snsUserNumberDTO;

        public Builder withID(final int id){
            this.appointmentDTO_ID =id;
            return this;
        }
        public Builder withStatus(final String status1){
            this.statusDTO = (status1);
            return this;
        }

        public Builder withFacilityID(final String facilityID){
            this.facilityDTO = (facilityID);
            return this;
        }
        public Builder withDate(final String date){
            this.dateDTO =date;
            return this;
        }

        public Builder withVaccineType(final String vaccineType){
            this.vaccineTypeCodeDTO =vaccineType;
            return this;
        }

        public Builder withSNSUser(final String snsUser){
            this.snsUserNumberDTO =snsUser;
            return this;
        }
        public AppointmentDto build() {
            return new AppointmentDto(this);
        }

    }

}
