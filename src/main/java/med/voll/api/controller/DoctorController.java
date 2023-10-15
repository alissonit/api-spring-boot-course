/*
 * DoctorController is a class that is used to control the doctor's data
 */
package med.voll.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.doctor.DataDoctorRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import med.voll.api.doctor.jpa.Doctor;
import med.voll.api.doctor.jpa.DoctorRepository;

@RestController
@RequestMapping("/medicos")
public class DoctorController {

    // This a mechanism of dependency injection, it is used to inject the repository
    @Autowired
    private DoctorRepository repository;

    @PostMapping
    // @Valid is used to validate the data
    public void register(@RequestBody @Valid DataDoctorRegister data) {
        // This is a constructor is used to convert DataDoctorRegister to Doctor
        repository.save(new Doctor(data));
    }

}
