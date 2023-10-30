package med.voll.api.dto.doctor;

import med.voll.api.doctor.Specialty;
import med.voll.api.doctor.jpa.Doctor;

public record DataDoctorList(Long id, String name, String email, String crm, Specialty specialty) {

    public DataDoctorList(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
