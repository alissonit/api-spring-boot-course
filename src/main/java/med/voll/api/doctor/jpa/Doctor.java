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
     This class is used to store data in the database
     * @GeneratedValue is used to generate the primary key
     * @Id is used to define the primary key
     *
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String crm;
    private String email;

    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    
    // Embedded JPA is used to store data in the same table
    @Embedded
    private Address address;

    // This a constructor is used to convert DataDoctorRegister to Doctor
    public Doctor(DataDoctorRegister data) {
        this.name = data.name();
        this.crm = data.crm();
        this.email = data.email();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

}
