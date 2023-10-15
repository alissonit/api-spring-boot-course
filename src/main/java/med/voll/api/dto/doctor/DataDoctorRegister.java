package med.voll.api.dto.doctor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.doctor.Specialty;
import med.voll.api.dto.common.DataAddress;

/*
 * Record is a new feature in Java 14, it is a class that is used to store data, it is immutable.
 * This record has validation annotations, it is used to validate the data.
 */
public record DataDoctorRegister(

        @NotBlank String name,

        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,

        @NotBlank @Email String email,

        @NotBlank
        String phone,

        @NotNull Specialty specialty,

        @NotNull @Valid DataAddress address

) {

}
