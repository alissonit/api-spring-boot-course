package med.voll.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.dto.patients.DataPatientsRegister;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pacientes")
public class PatientsContoller {

    @PostMapping
    public void postMethodName(@RequestBody DataPatientsRegister data) {

        System.out.println(data);
    }

}
