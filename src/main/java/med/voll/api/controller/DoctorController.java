/*
 * DoctorController is a class that is used to control the doctor's data
 */
package med.voll.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dto.doctor.DataDoctorRegister;
import med.voll.api.dto.doctor.DataDoctorUpdate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import med.voll.api.doctor.jpa.Doctor;
import med.voll.api.doctor.jpa.DoctorRepository;

import med.voll.api.dto.doctor.DataDoctorList;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    // This a mechanism of dependency injection, it is used to inject the repository
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    /*
     * @Valid is used to validate the data
     * https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation
     * -spec-3.0.html#builtinconstraints
     */
    @Transactional
    public void registerDoctor(@RequestBody @Valid DataDoctorRegister data) {
        // This is a constructor is used to convert DataDoctorRegister to Doctor
        repository.save(new Doctor(data));
    }

    // This a method is used to list all doctors paginated
    @GetMapping
    public Page<DataDoctorList> listDoctors(@PageableDefault(size = 10, sort = { "name" }) Pageable pageable) {
        return repository.findAllByActiveTrue(pageable).map(DataDoctorList::new);
    }

    @PutMapping
    @Transactional
    public void updateDoctor(@RequestBody @Valid DataDoctorUpdate data) {
        // This a method is used to update the doctor
        repository.findById(data.id()).ifPresent(doctor -> {
            doctor.updateDoctor(data);
        });
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteDoctor(@PathVariable Long id) {
        // This a method is used to delete the doctor
        repository.findById(id).ifPresent(doctor -> {
            doctor.setActive(false);
        });
    }
}
