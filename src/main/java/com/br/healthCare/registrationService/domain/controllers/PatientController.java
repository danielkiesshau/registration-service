package com.br.healthCare.registrationService.domain.controllers;

import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.domain.commands.PatientCommand;
import com.br.healthCare.registrationService.domain.controllers.contracts.GetPatientRequest;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public @ResponseBody ResponseEntity<Patient> getPatient(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String cpf
    ) {
        GetPatientRequest request = new GetPatientRequest(
                id,
                name,
                email,
                cpf
        );

        Patient patient = patientCommand.getPatient(request);

        if (patient == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(200).body(patient);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients =  patientCommand.getAllPatients();

        return ResponseEntity.status(200).body(patients);
    }

    @DeleteMapping(path="")
    public @ResponseBody ResponseEntity deletePatient(@RequestParam Integer id) {
        try {
            patientCommand.removePatient(id);
        } catch (EmptyResultDataAccessException error) {
            return ResponseEntity.status(400).body("patient not found");
        } catch (Exception error) {
            return ResponseEntity.status(500).body("patient deletion failed");
        }
        return ResponseEntity.status(200).body("patient deleted");
    }
}
