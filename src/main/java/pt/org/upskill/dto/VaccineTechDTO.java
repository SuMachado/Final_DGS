package pt.org.upskill.dto;

public class VaccineTechDTO implements DTO{
    public int id;
    public String name;
    public String description;

    public int id() {
        return this.id;
    }
    public String name() {
        return this.name;
    }
    public  String description() {
        return this.description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private VaccineTechDTO(final VaccineTechDTO.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;;
        this.description = builder.description;;
    }

    public static class Builder {
        private int id;
        private String name;
        private String description;

        public Builder withId(final int id) {
            this.id = id;
            return this;
        }
        public Builder withName(final String name) {
            this.name = name;
            return this;
        }
        public Builder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public VaccineTechDTO build() {
            return new VaccineTechDTO(this);
        }
    }

}
