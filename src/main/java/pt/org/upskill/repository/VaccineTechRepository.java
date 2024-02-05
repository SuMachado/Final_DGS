//package pt.org.upskill.repository;
//
//import pt.org.upskill.db.ConnectionVaccine;
//import pt.org.upskill.db.DatabaseConnection;
//import pt.org.upskill.db.VaccineTechDB;
//import pt.org.upskill.domain.VaccineTech;
//import pt.org.upskill.dto.DTO;
//import pt.org.upskill.dto.VaccineTechDTO;
//import pt.org.upskill.dto.KeyValueDTO;
//import pt.org.upskill.session.Context;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class VaccineTechRepository implements Persistable {
//
//    private List<VaccineTech> vaccineTechList = new ArrayList<>();
//
//    public VaccineTechRepository() {}
//
//    public int nextId() {
//        int maxId = 0;
//        for (VaccineTech vaccineTech : vaccineTechList) {
//            if (vaccineTech.getId() > maxId) {
//                maxId = vaccineTech.getId();
//            }
//        }
//        return maxId + 1;
//    }
//
//    public VaccineTech getById(int id) {
//        for (VaccineTech vaccineTech : vaccineTechList) {
//            if (vaccineTech.getId() == id) {
//                return vaccineTech;
//            }
//        }
//        return null;
//    }
//
//    public VaccineTech createVaccineTech(int id, String name, String description) {
//        return new VaccineTech(id, name, description);
//    }
//
//    public VaccineTech createVaccineTech(DTO dto) {
//        VaccineTechDTO vaccineTechDTO = (VaccineTechDTO) dto;
//        return new VaccineTech.Builder()
//                .withId(vaccineTechDTO.getId())
//                .withName(vaccineTechDTO.getName())
//                .withDescription(vaccineTechDTO.getDescription())
//                .build();
//    }
//
//    @Override
//    public boolean save(Object object) {
//        ConnectionVaccine cv = Context.getConnectionVaccine();
//        DatabaseConnection dbc = cv.getDatabaseConnection();
//        Connection conn = dbc.getConnection();
//        try {
//            conn.setAutoCommit(false);
//            VaccineTechDB vaccineTechDB = new VaccineTechDB();
//            vaccineTechDB.save(conn, (VaccineTech) object);
//            conn.commit();
//            return true;
//        } catch (SQLException e) {
//            try {
//                conn.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            return false;
//        }
//    }
//
//    @Override
//    public boolean delete(Object object) {
//        ConnectionVaccine cv = Context.getConnectionVaccine();
//        DatabaseConnection dbc = cv.getDatabaseConnection();
//        Connection conn = dbc.getConnection();
//        try {
//            conn.setAutoCommit(false);
//            VaccineTechDB vaccineTechDB = new VaccineTechDB();
//            vaccineTechDB.delete(conn, (VaccineTech) object);
//            conn.commit();
//            return true;
//        } catch (SQLException e) {
//            try {
//                conn.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            return false;
//        }
//    }
//
//    public List<VaccineTech> vaccineTechList() {
//        return vaccineTechList;
//    }
//
//    public List<KeyValueDTO> keyValueDTOList() {
//        List<KeyValueDTO> dtoList = new ArrayList<>();
//        for (VaccineTech item : vaccineTechList()) {
//            VaccineTechDTO dto = item.toDTO();
//            dtoList.add(new KeyValueDTO(dto.getId(), dto.getName()));
//        }
//        return dtoList;
//    }
//}