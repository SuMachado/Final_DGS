package pt.org.upskill.db;

import pt.org.upskill.domain.SnsUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SnsUserDB implements PersistableObject<SnsUser> {


    @Override
    public boolean save(Connection connection, SnsUser object) {
        String sqlCmd;
        sqlCmd = "select * from SnsUser where snsUserID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
            ps.setInt(1, object.getSnsUserID());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sqlCmd = "update SnsUser set name = ?";
                }
                else {
                    sqlCmd = "insert into SnsUser(snsUserID, name, gender, postalAddress, email, citizenCardNumber, snsUserNumber) values (?, ?, ?, ?, ?, ?, ?)";
                }
                //
                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
                    ps2.setInt(1, object.getSnsUserID());
                    ps2.setString(2, object.getName());
                    ps2.setString(3, object.getGender());
                    ps2.setString(4, object.getPostalAddress());
                    ps2.setString(5, object.getEmail());
                    ps2.setString(6, object.getCitizenCardNumber());
                    ps2.setString(7, object.getSnsUserNumber());

                    ps2.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SnsUserDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean delete(Connection connection, SnsUser object) {
        try {
            String sqlCmd;
            sqlCmd = "delete from SNS User where ID = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, object.getSnsUserID());
                ps.setString(2, object.getName());
                ps.setString(3, object.getGender());
                ps.setString(4, object.getPostalAddress());
                ps.setString(5, object.getEmail());
                ps.setString(6, object.getCitizenCardNumber());
                ps.setString(7, object.getSnsUserNumber());
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SnsUserDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public SnsUser getById(Connection connection, int id) {
        try {
            String sqlCmd;
            sqlCmd = "select * from SNS User where ID = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    SnsUser snsUser = null;
                    try {
                        snsUser = new SnsUser.Builder()
                                .withSnsUserID(rs.getInt("SNS User ID"))
                                .withName(rs.getString("Name"))
                                .withGender(rs.getString("Gender"))
                                .withPostalAddress(rs.getString("Postal Address"))
                                .withEmail(rs.getString("Email"))
                                .withCitizenCardNumber(rs.getString("Citizen Card Number"))
                                .withSnsUserNumber(rs.getString("SNS User Number"))
                                .build();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return snsUser;
                }
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SnsUserDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
