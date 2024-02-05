package pt.org.upskill.db;

import pt.org.upskill.domain.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBAppointment implements PersistableObject<Appointment> {

    @Override
    public boolean save(Connection connection, Appointment object) {
        String sqlCmd;
        sqlCmd = "select * from Appointment where appointmentID = ?";
        try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
            ps.setInt(1, object.appointmentID());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    sqlCmd = "update Appointment set status = ? where appointmentID = ?";
                } else {
                    sqlCmd = "insert into Appointment(appointmentID, snsUserID, status, dateAppointment, vaccineTypeCode, facilityID) values (?, ?, ?, ?, ?, ?)";
                }
                //
                try (PreparedStatement ps2 = connection.prepareStatement(sqlCmd)) {
                    ps2.setInt(1, object.appointmentID());
                    ps2.setString(2, object.snsUserNumber());
                    ps2.setString(3, object.appointmentStatus());
                    ps2.setString(4, object.date());
                    ps2.setString(5, object.vaccineTypeCode());
                    ps2.setString(6, object.facilityID());
                    ps2.executeUpdate();
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAppointment.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

    @Override
    public boolean delete(Connection connection, Appointment object) {
        try {
            String sqlCmd;
            sqlCmd = "delete from Appointment where appointmentID = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, object.appointmentID());
                ps.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAppointment.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Appointment getById(Connection connection, int id) {
        try {
            String sqlCmd;
            sqlCmd = "select * from Appointment where id = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Appointment appointment = null;
                    try {
                        appointment = new Appointment.Builder()
                                .withID(rs.getInt("appointmentID"))
                                .withStatus(rs.getString("status"))
                                .withDate(rs.getString("dateAppointment"))
                                .withVaccineType((rs.getString("vaccineTypeCode")))
                                .withSNSUser((rs.getString("snsUserID")))
                                .withFacilityID((rs.getString("facilityID")))
                                .build();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return appointment;
                }
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAppointment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public Appointment getBySnsUserNumber(Connection connection, int snsUserNumber) {
        try {
            String sqlCmd;
            sqlCmd = "select * from Appointment where SNSUserNumber = ?";
            try (PreparedStatement ps = connection.prepareStatement(sqlCmd)) {
                ps.setInt(1, snsUserNumber);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    Appointment appointment = null;
                    try {
                        appointment = new Appointment.Builder()
                                .withID(rs.getInt("AppointmentID"))
                                .withStatus(rs.getString("status"))
                                .withDate(rs.getString("dateAppointment"))
                                .withVaccineType((rs.getString("vaccineTypeCode")))
                                .withSNSUser((rs.getString("snsUserID")))
                                .withFacilityID((rs.getString("facilityID")))
                                .build();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return appointment;
                }
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBAppointment.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
