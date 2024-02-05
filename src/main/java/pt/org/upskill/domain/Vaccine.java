package pt.org.upskill.domain;

import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.VaccineDTO;

public class Vaccine implements DTOable<VaccineDTO> {
    public int id;
    private String name;
    private String vaccineType;
    private String brand;

    public Vaccine(int id, String name, String vaccineType, String brand) {
        this.id = id;
        this.name = name;
        this.vaccineType = vaccineType;
        this.brand = brand;
    }

    private Vaccine(Vaccine.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.vaccineType = builder.vaccineType;
        this.brand = builder.brand;
    }

    public Vaccine(String name, String vaccineType, String brand) {
        this.name = name;
        this.vaccineType = vaccineType;
        this.brand = brand;
    }

    public int getId() {
        return id;
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


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVaccineType(String vaccineType) {
        this.vaccineType = vaccineType;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }



    public static class Builder {
        private int id;
        private String name;
        private String vaccineType;
        private String brand;
        private String vaccineTech;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withVaccineType(String vaccineType) {
            this.vaccineType = vaccineType;
            return this;
        }

        public Builder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder withVaccineTech(String vaccineTech) {
            this.vaccineTech = vaccineTech;
            return this;
        }

        public Vaccine build() {
            return new Vaccine(this);
        }
    }

        public VaccineDTO toDTO() {
            VaccineDTO.Builder builder = new VaccineDTO.Builder();
            if (getId() != 0) {
                builder.withVaccineIDDTO(getId());
            }
            if (getName() != null) {
                builder.withNameDTO(getName());
            }
            if (getVaccineType() != null) {
                builder.withVaccineTypeDTO(getVaccineType());
            }
            if (getBrand() != null) {
                builder.withBrandDTO(getBrand());
            }
            return builder.build();
        }

    }

