package med.voll.api.dto.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.common.DataAddress;

public record DataDoctorUpdate(
        @NotNull Long id,
        String name,
        String phone,
        DataAddress address) {

}
