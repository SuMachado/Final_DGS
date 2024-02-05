package pt.org.upskill.controller;

import pt.org.upskill.domain.Appointment;
import pt.org.upskill.dto.AppointmentDto;
import pt.org.upskill.repository.AppointmentRepository;
import pt.org.upskill.repository.Repositories;

import java.util.List;

public class ScheduleVaccinationController {
    private static AppointmentRepository appointmentRepository = Repositories.getInstance().appointmentRepository();

    Appointment appointment;
    public Appointment registerAppointment(AppointmentDto dto){
        appointment=appointmentRepository.createAppointment(dto);
        return appointment;
    }

    public Object getByID(int ID){
        return appointmentRepository.getById(ID);
    }

    public List<Appointment> getAppointmentList(){
        return appointmentRepository.appointmentList();
    }

//    public Appointment getBySnsUserNumber(int snsUserNumber){
//        return appointmentRepository.getBySnsUserNumber(snsUserNumber);
//    }


    public boolean cancelAppointment(Appointment appointment) {
        return appointmentRepository.delete(appointment);
    }
    public Appointment confirmAppointment(AppointmentDto appointmentDTO) {
        Appointment appointment= Appointment.fromDTO(appointmentDTO);
        appointmentRepository.save(appointment);
        return appointment;
    }



    }

