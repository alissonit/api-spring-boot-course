/*
 * This a class is used to store data in the database
 * An Entity JPA is a class that is used to store data in the database
 */
package med.voll.api.doctor.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;
import med.voll.api.doctor.Specialty;
import med.voll.api.dto.doctor.DataDoctorRegister;
import med.voll.api.dto.doctor.DataDoctorUpdate;

// Entity JPA
@Table(name = "doctors")
@Entity(name = "doctor")
// Getters is used to generate getters methods
@Getter
// NoArgsConstructor is used to generate a constructor without arguments
@NoArgsConstructor
// AllArgsConstructor is used to generate a constructor with all arguments
@AllArgsConstructor
// EqualsAndHashCode is used to generate equals and hashCode methods
@EqualsAndHashCode(of = "id")
public class Doctor {
    /*
     * This class is used to store data in the database
     * 
     * @GeneratedValue is used to generate the primary key
     * 
     * @Id is used to define the primary key
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String crm;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    // Embedded JPA is used to store data in the same table
    @Embedded
    private Address address;

    private boolean active = true;

    // This a constructor is used to convert DataDoctorRegister to Doctor
    public Doctor(DataDoctorRegister data) {
        this.active = true;
        this.name = data.name();
        this.crm = data.crm();
        this.email = data.email();
        this.phone = data.phone();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void updateDoctor(DataDoctorUpdate data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.phone() != null) {
            this.phone = data.phone();
        }
        if (data.address() != null) {
            this.address.updateAddress(data.address());
        }

    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
