package pt.org.upskill.repository;

import pt.org.upskill.db.ConnectionAppointment;
import pt.org.upskill.db.DBAppointment;
import pt.org.upskill.db.DatabaseConnection;
import pt.org.upskill.domain.Appointment;
import pt.org.upskill.dto.AppointmentDto;
import pt.org.upskill.dto.KeyValueDTO;
import pt.org.upskill.session.Context;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository implements Persistable {

    public AppointmentRepository() {}
    private List<Appointment> appointmentList = new ArrayList<>();

//    public int nextId() {
//        int maxId = 0;
//        for (Appointment appointment : appointmentList) {
//            if (appointment.appointmentID() > maxId) {
//                maxId = appointment.appointmentID();
//            };
//        }
//        return maxId+1;
//    }
    public Appointment fromAppointmentDto(AppointmentDto dto){
        return Appointment.fromDTO(dto);
    }

    public Appointment createAppointment(AppointmentDto dto){
        AppointmentDto appointmentDto = dto;
        return new Appointment.Builder()
                .withID(appointmentDto.appointmentDTO_ID)
                .withDate(appointmentDto.dateDTO)
                .withSNSUser(appointmentDto.snsUserNumberDTO)
                .withFacilityID(appointmentDto.facilityDTO)
                .withVaccineType(appointmentDto.vaccineTypeCodeDTO)
                .withStatus(appointmentDto.statusDTO)
                .build();
    }



    private Boolean validateSave(Object object) {
        return true;
    }

    private Boolean validateDelete(Object object) {
        return true;
    }

//    public Appointment createAppointment(Facility facility, Date date, VaccineType vaccineType, SnsUser user) {
//        return new Appointment(facility, date, vaccineType, user);
//    }


    @Override
    public boolean save(Object object) {
        ConnectionAppointment ca = Context.getConnectionAppointment();

        DatabaseConnection dbc = ca.getDatabaseConnection();
        Connection conn = dbc.getConnection();
        //
        try {
            conn.setAutoCommit(false);
            //
            DBAppointment appointmentDB = new DBAppointment();
            appointmentDB.save(conn, (Appointment) object);
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

        ConnectionAppointment ca = Context.getConnectionAppointment();
        DatabaseConnection dbc = ca.getDatabaseConnection();
        Connection conn = dbc.getConnection();
        //
        try {
            conn.setAutoCommit(false);
            //
            DBAppointment appointmentDB = new DBAppointment();
            appointmentDB.delete(conn, (Appointment) object);
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



    public Object getById(Object o) {
        for (Appointment appointment : appointmentList) {
            if (appointment.appointmentID()==(int) o) {
                return appointment;
            };
        }
        return null;
    }

    public List<Appointment> appointmentList() {
        return appointmentList;
    }
    public List<KeyValueDTO> keyValueDTOList() {
        List<KeyValueDTO> dtoList = new ArrayList<>();
        for (Appointment item : appointmentList) {
            AppointmentDto dto = item.toDTO();
            dtoList.add(new KeyValueDTO(dto.appointmentDTO_ID, dto.snsUserNumberDTO));
        }
        return dtoList;
    }

//
//    public Appointment getBySnsUserNumber(int SnsUserNumber) {
//        for (Appointment appointment : appointmentList) {
//            if (appointment.snsUser().getSnsUserNumber()==(SnsUserNumber)) {
//                return appointment;
//            }
//        }
//        return null;
//    }


}

