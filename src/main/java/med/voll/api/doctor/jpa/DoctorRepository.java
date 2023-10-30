/*
 * Repository is an interface that extends JpaRepository.
 */
package med.voll.api.doctor.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// This is a Spring Data JPA repository, it is used to access the database.
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // This a method is used to list all doctors paginated
    Page<Doctor> findAllByActiveTrue(Pageable pageable);
}