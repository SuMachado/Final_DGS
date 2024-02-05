package pt.org.upskill.domain;

import pt.org.upskill.dto.AppointmentDto;
import pt.org.upskill.dto.DTOable;

public class Appointment implements DTOable<AppointmentDto> {


//    public enum AppointmentStatus {
//        SCHEDULED,
//        CANCELED,
//        WAITING,
//        IN_PROGRESS,
//        VACCINATED
//    }


    private int appointmentID;
    private String status;

    private String facilityID;
    private String date;
    private String vaccineTypeCode;
    private String snsUserNumber;
    //private String observations="";
    //private String batch="";
    private static int counter = 0;


    //    public  Appointment(Facility facility, Date date, VaccineType vaccineType, SnsUser user) {
//        this.status = AppointmentStatus.SCHEDULED;
//        this.facility = facility;
//        this.date = date;
//        this.vaccineType = vaccineType;
//        this.snsUser = user;
//
//    }
    public int appointmentID() {
        return appointmentID;
    }

    public String appointmentStatus() {
        return status;
    }

    public String facilityID() {
        return facilityID;
    }

    public String date() {
        return date;
    }

    public String vaccineTypeCode() {
        return vaccineTypeCode;
    }

    public String snsUserNumber() {
        return snsUserNumber;
    }


    //    public String observations() {
//        return observations;
//    }
//    public String Batch() {
//        return batch;
//    }
    //public void setObservations(String observations) {
//        this.observations = observations;
//    }
    //public void setStatus(AppointmentStatus status){this.status=status;}
//    public void setBatch(String batch){this.batch=batch;}

    private Appointment(final Builder builder) {
        this.appointmentID = builder.appointmentID;
        this.status = builder.status;
        this.facilityID = builder.facilityID;
        this.vaccineTypeCode = builder.vaccineTypeCode;
        this.date = builder.date;
        this.snsUserNumber = builder.snsUserNumber;
    }


    public static class Builder {
        private int appointmentID;
        private String status;

        private String facilityID;
        private String date;
        private String vaccineTypeCode;
        private String snsUserNumber;

        public Builder withID(final int id) {
            this.appointmentID = id;
            return this;
        }

        public Builder withStatus(final String status1) {
            this.status = status1;
            return this;
        }

        public Builder withFacilityID(final String facilityID) {
            this.facilityID = facilityID;
            return this;
        }

        public Builder withDate(final String date) {
            this.date = date;
            return this;
        }

        public Builder withVaccineType(final String vaccineTypeCode) {
            this.vaccineTypeCode = vaccineTypeCode;
            return this;
        }


        public Builder withSNSUser(final String snsUserNumber) {
            this.snsUserNumber = snsUserNumber;
            return this;
        }


        public Appointment build() {
            return new Appointment(this);
        }


    }

    public AppointmentDto toDTO() {
        AppointmentDto.Builder builder = new AppointmentDto.Builder();
        if (appointmentID != 0) {
            builder.withID(appointmentID);
        }
        if (status != null) {
            builder.withStatus(appointmentStatus());
        }
        if (facilityID != null) {
            builder.withFacilityID(facilityID);
        }
        if (date() != null) {
            builder.withDate(date());
        }
        if (vaccineTypeCode != null) {
            builder.withVaccineType(vaccineTypeCode());
        }
        if (snsUserNumber != null) {
            builder.withSNSUser(snsUserNumber());
        }

        return builder.build();
    }
    public static Appointment fromDTO(AppointmentDto appointmentDto) {
        Builder builder = new Builder();
        if (appointmentDto.appointmentDTO_ID != 0) {
            builder.withID(appointmentDto.appointmentDTO_ID);
        }
        if (appointmentDto.statusDTO != null) {
            builder.withStatus(appointmentDto.statusDTO);
        }
        if (appointmentDto.facilityDTO != null) {
            builder.withFacilityID(appointmentDto.facilityDTO);
        }
        if (appointmentDto.dateDTO != null) {
            builder.withDate(appointmentDto.dateDTO);
        }
        if (appointmentDto.vaccineTypeCodeDTO != null) {
            builder.withVaccineType(appointmentDto.vaccineTypeCodeDTO);
        }
        if (appointmentDto.snsUserNumberDTO != null) {
            builder.withSNSUser(appointmentDto.snsUserNumberDTO);
        }

        return builder.build();
    }
}


