//package pt.org.upskill.domain;
//
//import pt.org.upskill.dto.DTOable;
//import pt.org.upskill.dto.VaccineTechDTO;
//import pt.org.upskill.repository.Repositories;
//import pt.org.upskill.repository.VaccineTechRepository;
//
//public class VaccineTech implements DTOable<VaccineTechDTO> {
//    public int id;
//    public String name;
//    public String description;
//
//    public int id() {
//        return id;
//    }
//    public String name() {
//        return name;
//    }
//    public String description() {
//        return description;
//    }
//
//    public VaccineTech(int id, String name, String description) {
//        VaccineTechRepository vaccineTechRepository = Repositories.getInstance().vaccineTechRepository();
//        this.id = id;
//        this.name=name;
//        this.description = description;
//    }
//
//    private VaccineTech(Builder builder) {
//        this.id = builder.id;
//        this.name = builder.name;
//        this.description = builder.description;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public static class Builder {
//        private int id;
//        private String name;
//        private String description;
//
//        public Builder() {
//            VaccineTechRepository vaccineTechRepository = Repositories.getInstance().vaccineTechRepository();
//            this.id = vaccineTechRepository.nextId();
//        }
//
//        public Builder withName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Builder withId(int id) {
//            this.id = id;
//            return this;
//        }
//
//        public Builder withDescription(String description) {
//            this.description = description;
//            return this;
//        }
//
//        public VaccineTech build() {
//            return new VaccineTech(this);
//        }
//    }
//
//    @Override
//    public VaccineTechDTO toDTO() {
//        VaccineTechDTO.Builder builder = new VaccineTechDTO.Builder();
//        if (this.id != 0) {
//            builder.withId(this.id);
//        }
//        if (this.name != null) {
//            builder.withName(this.name);
//        }
//        if (this.description != null) {
//            builder.withDescription(this.description);
//        }
//        return builder.build();
//    }
//
//
//
//
//}