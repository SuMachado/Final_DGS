package pt.org.upskill.repository;

import com.sun.jdi.connect.spi.Connection;
import pt.org.upskill.db.*;
import pt.org.upskill.domain.Employee;
import pt.org.upskill.domain.SnsUser;
import pt.org.upskill.dto.DTO;
import pt.org.upskill.dto.EmployeeDTO;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.dto.SnsUserDTO;
import pt.org.upskill.session.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SnsUserRepository implements Persistable {
    private Connection conn;

    public List<SnsUser> snsUserList = new ArrayList<SnsUser>();

    public SnsUserRepository() {
    }


    public SnsUser createSnsUser(DTO dto) throws Exception {
        SnsUserDTO snsUserDTO = (SnsUserDTO) dto;
        return new SnsUser.Builder()
                .withSnsUserID(snsUserDTO.getSnsUserID())
                .withName(snsUserDTO.getName())
                .withGender(snsUserDTO.getGenderDTO())
                .withPostalAddress(snsUserDTO.getPostalAddressDTO())
                .withEmail(snsUserDTO.getEmailDTO())
                .withCitizenCardNumber(snsUserDTO.getCitizenCardNumberDTO())
                .withSnsUserNumber(snsUserDTO.getSnsUserNumberDTO())
                .build();
    }

   /*
    @Override
    public boolean save(Object object) {
        if (validateSave(object)) {
            snsUserList.add((SnsUser) object);
            return true;
        }
        return false;
    }
*/

    public SnsUser getByID(int snsUserID) {
        for (SnsUser snsUser : snsUserList) {
            if (snsUser.getSnsUserID() == snsUserID) {
                return snsUser;
            }
        }
        return null;
    }


    @Override
    public boolean save(Object object) {
        ConnectionSnsUser csu = Context.getConnectionSnsUser();
        DatabaseConnection dbc = csu.getDatabaseConnection();
        java.sql.Connection conn = dbc.getConnection();
        //
        try {
            conn.setAutoCommit(false);
            //
            SnsUserDB snsUserDB = new SnsUserDB();
            snsUserDB.save(conn, (SnsUser) object);
            //
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


    @Override
    public boolean delete(Object object) {
        ConnectionSnsUser csu = Context.getConnectionSnsUser();
        DatabaseConnection dbc = csu.getDatabaseConnection();
        java.sql.Connection conn = dbc.getConnection();
        //
        try {
            conn.setAutoCommit(false);
            //
            SnsUserDB snsUserDB = new SnsUserDB();
            snsUserDB.delete(conn, (SnsUser) object);
            //
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


        public List<SnsUser> snsUserList () {
            return snsUserList;
        }

        public List<KeyValueDTO> keyValueDTOList () {
            List<KeyValueDTO> dtoList = new ArrayList<>();
            for (SnsUser item : snsUserList()) {
                SnsUserDTO dto = item.toDTO();
                dtoList.add(new KeyValueDTO(dto.getSnsUserID(), dto.getName()));
            }
            return dtoList;
        }

    }

