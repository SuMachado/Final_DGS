package pt.org.upskill.db;

import pt.org.upskill.domain.Vaccine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VaccineDB implements PersistableObject<Vaccine> {

    @Override
    public  boolean save(Connection connection, Vaccine object) {
        String sqlCmd;
        sqlCmd = "select * from Vaccine where vaccineid = ?";
        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
            ps.setInt(1, object.getId());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sqlCmd = "update vaccine set name = ? where vaccineid = ?";
                }
                else {
                    sqlCmd = "insert into vaccine(vaccineid, name, brandID, vaccinetypecode) values (?, ?, ?, ?)";
                }
                //
                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
                    ps2.setInt(1, object.getId());
                    ps2.setString(2, object.getName());
                    ps2.setString(3, object.getBrand());
                    ps2.setString(4, object.getVaccineType());

                    ps2.executeUpdate();

                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VaccineDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }


    @Override
    public boolean delete(Connection connection, Vaccine object) {
        try {
            String sqlCmd;
            sqlCmd = "delete from Vaccine where id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setString(1, object.getName());
                ps.setInt(2, object.getId());
                ps.setString(3, object.getVaccineType());
                ps.setString(4, object.getBrand());
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VaccineDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Vaccine getById(Connection connection, int id) {
        try {
            String sqlCmd;
            sqlCmd = "select * from Vaccine where id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Vaccine vaccine = null;
                    try {
                        vaccine = new Vaccine.Builder()
                                .withId(rs.getInt("id: "))
                                .withName(rs.getString("Name: "))
                                .withVaccineType(rs.getString("VaccineType: "))
                                .withBrand(rs.getString("Brand: "))
                                .build();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return vaccine;
                }
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VaccineDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    }

