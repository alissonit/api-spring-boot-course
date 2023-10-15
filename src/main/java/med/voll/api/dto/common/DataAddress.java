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

public record DataAddress(String public_place, String neighborhood, String cep, String city, String uf, String number,
      String complement) {

}
