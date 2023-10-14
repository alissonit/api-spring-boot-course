package med.voll.api.dto.patients;

import med.voll.api.dto.common.DataAddress;

public record DataPatientsRegister(
    String name,
    String cpf,
    String email,
    String phone,
    DataAddress address
) {

}