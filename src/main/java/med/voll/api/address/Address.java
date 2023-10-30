// This class 

package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.common.DataAddress;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String public_place;
    private String neighborhood;
    private String cep;
    private String city;
    private String uf;
    private String number;
    private String complement;

    // This constructor is used to convert DataAddress to Address
    public Address (DataAddress address) {
        this.public_place = address.public_place();
        this.neighborhood = address.neighborhood();
        this.cep = address.cep();
        this.city = address.city();
        this.uf = address.uf();
        this.number = address.number();
        this.complement = address.complement();
    }

    public void updateAddress(DataAddress address) {
        if (address.public_place() != null) {
            this.public_place = address.public_place();
        }
        if (address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }
        if (address.cep() != null) {
            this.cep = address.cep();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.uf() != null) {
            this.uf = address.uf();
        }
        if (address.number() != null) {
            this.number = address.number();
        }
        if (address.complement() != null) {
            this.complement = address.complement();
        }
    }

}
