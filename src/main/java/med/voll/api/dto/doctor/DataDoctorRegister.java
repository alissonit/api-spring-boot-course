package med.voll.api.dto.doctor;

import med.voll.api.doctor.Specialty;
import med.voll.api.dto.common.DataAddress;

/*
 * Record is a new feature in Java 14, it is a class that is used to store data, it is immutable.
 */
public record DataDoctorRegister(String name, String crm, String email, Specialty specialty, DataAddress address) {

}
