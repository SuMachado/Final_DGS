//package pt.org.upskill.repository;
//
//
//import pt.org.upskill.db.ConnectionVaccine;
//import pt.org.upskill.db.DatabaseConnection;
//import pt.org.upskill.db.VaccineTypeDB;
//import pt.org.upskill.domain.Employee;
//import pt.org.upskill.domain.VaccineTech;
//import pt.org.upskill.domain.VaccineType;
//import pt.org.upskill.dto.DTO;
//import pt.org.upskill.dto.KeyValueDTO;
//import pt.org.upskill.dto.VaccineTypeDTO;
//import pt.org.upskill.session.Context;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class VaccineTypeRepository implements Persistable {
//
//    //VaccineTechRepository vaccineTechRepository = Repositories.getInstance().vaccineTechRepository();
//    private List<VaccineType> vaccineTypeList = new ArrayList<VaccineType>();
//    public VaccineType createVaccineType(VaccineTypeDTO dto) {
//        return new VaccineType.Builder()
//                .withCode(dto.getCode())
//                .withShortDescription(dto.getShortDescription())
//                //.withVaccineTech(vaccineTechRepository.createVaccineTech(( dto).getVaccineTechDTO()))
//                .build();
//
//    }
//    public VaccineType createVaccineType(int code, String shortDescription, VaccineTech vaccineTech) {
//        return new VaccineType(code, shortDescription, vaccineTech);
//    }
//
//    public int nextId() {
//        int maxId = 0;
//        for (VaccineType vaccineType : vaccineTypeList) {
//            if (false) {
//                maxId = vaccineType.getCode();
//            }
//        }
//        return maxId + 1;
//    }
//
//    private Boolean validateSave(VaccineType vaccineType) {
//        return true;
//    }
//
//    private Boolean validateDelete(VaccineType vaccineType) {
//        return true;
//    }
//
//
//
//    @Override
//    public boolean save(Object object) {
//        ConnectionVaccine cv = Context.getConnectionVaccine();
//        DatabaseConnection db = cv.getDatabaseConnection();
//        Connection conn = db.getConnection();
//
//
//        try {
//            conn.setAutoCommit(false);
//            VaccineTypeDB vaccineTypeDB = new VaccineTypeDB();
//            vaccineTypeDB.save(conn, (VaccineType) object);
//            conn.commit();
//            return true;
//        } catch (Exception e) {
//            try {
//                conn.rollback();
//            } catch (SQLException ex) {
//                Logger.getLogger(VaccineTypeRepository.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return false;
//        }
//    }
//
//    @Override
//    public boolean delete(Object object) {
//        ConnectionVaccine cv = Context.getConnectionVaccine();
//        DatabaseConnection db = cv.getDatabaseConnection();
//        Connection conn = db.getConnection();
//        try {
//            conn.setAutoCommit(false);
//            VaccineTypeDB vaccineTypeDB = new VaccineTypeDB();
//
//            vaccineTypeDB.delete(conn, (VaccineType) object);
//            conn.commit();
//            return true;
//        } catch (Exception e) {
//            try {
//                conn.rollback();
//            } catch (SQLException ex) {
//                Logger.getLogger(VaccineTypeRepository.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return false;
//        }
//    }
//
//    public List<VaccineType> vacTypeList() {
//        return vaccineTypeList;
//    }
//
//
//    public List<KeyValueDTO> keyValueDTOList() {
//        List<KeyValueDTO> dtoList = new ArrayList<>();
//        for (VaccineType item : vacTypeList()) {
//            VaccineTypeDTO dto = item.toDTO();
//            dtoList.add(new KeyValueDTO(dto.getCode(), dto.getShortDescription()));
//        }
//        return dtoList;
//    }
//    public VaccineType getByCode(int code) {
//        for (VaccineType vaccineType : vaccineTypeList) {
//            if (vaccineType.code()==(code)) {
//                return vaccineType;
//            }
//        }
//        return null;
//    }
//}