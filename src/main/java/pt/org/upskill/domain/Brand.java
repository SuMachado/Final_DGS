//package pt.org.upskill.domain;
//
//import pt.org.upskill.dto.BrandDTO;
//import pt.org.upskill.dto.DTOable;
//
//public class Brand implements DTOable<BrandDTO> {
//    private String name;
//    private int brandID;
//
//
//    public Brand(String name) {
//
//        this.brandID=brandID();
//        this.name = name;
//    }
//    public int brandID(){
//        return brandID;
//    }
//
//    public String name() {
//        return name;
//    }
//
//
//    private Brand(Builder builder) {
//        this.brandID = builder.brandID;
//        this.name = builder.name;
//    }
//
//    public int getBrandID() {
//        return brandID;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public static class Builder {
//        private String name;
//        private int brandID;
//
//        public Builder withName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public String build() {
//            return new Brand(this);
//        }
//
//        public Builder withBrandID(int brandID) {
//            this.brandID = brandID;
//            return this;
//        }
//    }
//    public BrandDTO toDTO() {
//        BrandDTO dto = new BrandDTO.Builder()
//                .withName(name())
//                .build();
//        return dto;
//    }
//}