/*
 * "address": {
    "public_place": "rua 1",
    "neighborhood": "bairro",
    "cep": "12345678",
    "city": "Brasilia",
    "uf": "DF",
    "number": "1",
    "complement": "complemento"
    }
 */

// DTO = Data Transfer Object 
// Record is a new feature in Java 14, it is a class that is used to store data, it is immutable.

package med.voll.api.dto.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// @NotBlank is used to validate if the field is not blank
public record DataAddress(

      @NotBlank String public_place,
      @NotBlank String neighborhood,
      @NotBlank @Pattern(regexp = "\\d{8}") String cep,
      @NotBlank String city,
      @NotBlank String uf,
      String number,
      String complement) {

}
