package com.br.healthCare.registrationService.domain.controllers;

import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.domain.commands.PatientCommand;
import org.apache.coyote.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/patient")
public class PatientController {

    @Autowired
    private PatientCommand patientCommand;

    @PostMapping(path="")
    public ResponseEntity createPatient (@RequestBody Patient patient) {
        try {
            patientCommand.createPatient(patient, false);
        } catch (ConstraintViolationException constraintViolationException) {
            return ResponseEntity.status(400).body("CPF already registered");
        }
        catch (Exception error) {
            return ResponseEntity.status(400).body(error.getMessage());
        }


        return ResponseEntity.status(201).body("patient created successfully");
    }

    @PutMapping
    public ResponseEntity updatePatient (@RequestBody Patient patient) {
        try {
            patientCommand.updatePatient(patient);
        } catch (Exception error) {
            return ResponseEntity.status(400).body(error.getMessage());
        }


        return ResponseEntity.status(201).body("patient updated successfully");
    }

    @GetMapping(path="")
    public @ResponseBody Patient getPatient(@RequestParam String name, @RequestParam String email) {
        return null;
//        Patient n = new Patient();
//        n.setName(name);
//        n.setEmail(email);
//
//        // TODO: Validar parâmetros
//
//        // TODO: passar chamada do repositório para um COMMAND (PatientCommand)
//        patientDao.setPatient(n);
//        return patientDao.findByEmail();
    }
}
