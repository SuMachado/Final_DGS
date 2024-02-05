package pt.org.upskill.repository;


import pt.org.upskill.db.ConnectionVaccine;
import pt.org.upskill.db.VaccineDB;
import pt.org.upskill.db.DatabaseConnection;
import pt.org.upskill.domain.Vaccine;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.dto.VaccineDTO;
import pt.org.upskill.session.Context;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VaccineRepository implements Persistable {


    private List<Vaccine> vaccineList = new ArrayList<Vaccine>();

    public VaccineRepository() {}

    public int nextId() {
        int maxId = 0;
        for (Vaccine vaccine : vaccineList) {
            if (vaccine.getId() > maxId) {
                maxId = vaccine.getId();
            };
        }
        return maxId+1;
    }

    public Vaccine getById(int vaccineID) {
        for (Vaccine vaccine : vaccineList) {
            if (vaccine.getId() == vaccineID) {
                return vaccine;
            };
        }
        return null;
    }

    private Boolean validateSave(Object object) {
        return true;
    }

    private Boolean validateDelete(Object object) {
        return true;
    }

    /*
    public Vaccine createVaccine(DTO dto) throws Exception {
        VaccineDTO vaccineDTO = (VaccineDTO) dto;
        return new Vaccine.Builder()
                .withId(vaccineDTO.getVaccineID())
                .withName(vaccineDTO.getNameDTO())
                .withVaccineType(vaccineDTO.getVaccineTypeDTO())
                .withBrand(vaccineDTO.getBrand())
                .build();
    }*/

    @Override
    public boolean save(Object object) {
        ConnectionVaccine cv = Context.getConnectionVaccine();
        DatabaseConnection dbc = cv.getDatabaseConnection();
        Connection conn = dbc.getConnection();

        try{
            conn.setAutoCommit(false);
            VaccineDB vaccineDB = new VaccineDB();
            vaccineDB.save(conn, (Vaccine) object);

            conn.commit();
            return true;
        }catch(SQLException e){
            try{
                conn.rollback();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public boolean delete(Object object) {
        ConnectionVaccine cv = Context.getConnectionVaccine();
        DatabaseConnection dbc = cv.getDatabaseConnection();
        Connection conn = dbc.getConnection();

        try{
            conn.setAutoCommit(false);
            VaccineDB vaccineDB = new VaccineDB();
            vaccineDB.delete(conn, (Vaccine) object);
            conn.commit();
            return true;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

    public List <Vaccine> vaccineList(){
        return vaccineList;
    }

    public List<KeyValueDTO> keyValueDTOList(){
        List<KeyValueDTO> dtoList = new ArrayList<>();
        for (Vaccine item : vaccineList) {
            VaccineDTO dto = item.toDTO();
            dtoList.add(new KeyValueDTO(dto.getVaccineID(), dto.getName()));
        }
        return dtoList;
    }

//    public Vaccine createVaccine(int vaccineTypeCode, String brandName, String vaccineName) {
//
//        int vaccineID = nextId();
//        return new Vaccine.Builder()
//                .withId(vaccineID)
//                .withName(vaccineName)
//                .withVaccineType(new VaccineType.Builder().withCode(vaccineTypeCode).build())
//                .withBrand(new Brand.Builder().withName(brandName).build())
//                .build();
//    }
//    public Vaccine createVaccine(String name, String vaccineType, String brand) {
//        return new Vaccine(name, vaccineType, brand);
//    }
}




