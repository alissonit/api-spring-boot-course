package med.voll.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.Address;

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

}
