//package pt.org.upskill.domain;
//
//import pt.org.upskill.dto.VaccineTypeDTO;
//
//public class VaccineType {
//    private int code;
//    private String shortDescription;
//    private VaccineTech vaccineTech;
//
//    public VaccineType(int code, String shortDescription, VaccineTech vaccineTech) {
//        this.code = code;
//        this.shortDescription = shortDescription;
//        this.vaccineTech = vaccineTech;
//    }
//
//    public int code() {
//        return code;
//    }
//
//    public String shortDescription() {
//        return shortDescription;
//    }
//    public VaccineTech vaccineTech() {
//        return vaccineTech;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public String getShortDescription() {
//        return shortDescription;
//    }
//
//    public VaccineTech getVaccineTech() {
//        return vaccineTech;
//    }
//
//    public void setShortDescription(String shortDescription) {
//        this.shortDescription = shortDescription;
//    }
//
//
//
//    public static class Builder {
//        private int code;
//        private String shortDescription;
//        private VaccineTech vaccineTech;
//
//        public Builder withCode(int code) {
//            this.code = code;
//            return this;
//        }
//
//        public Builder withShortDescription(String shortDescription) {
//            this.shortDescription = shortDescription;
//            return this;
//        }
//
//        public Builder withVaccineTech(VaccineTech vaccineTech) {
//            this.vaccineTech = vaccineTech;
//            return this;
//        }
//
//        public String build() {
//            return new VaccineType(this);
//        }
//    }
//    private VaccineType(Builder builder) {
//        this.code = builder.code;
//        this.shortDescription = builder.shortDescription;
//        this.vaccineTech = builder.vaccineTech;
//    }
//
//    public VaccineTypeDTO toDTO() {
//        return new VaccineTypeDTO.Builder()
//                .withCode(code)
//                .withShortDescription(shortDescription)
//                .withVaccineTechDTO(vaccineTech.toDTO())
//                .build();
//    }
//}