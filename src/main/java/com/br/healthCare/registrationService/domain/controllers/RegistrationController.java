package com.br.healthCare.registrationService.domain.controllers;

import com.br.healthCare.registrationService.data.MedicalHistory;
import com.br.healthCare.registrationService.domain.commands.RegistrationCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/medical-history")
public class RegistrationController {

    @Autowired
    private RegistrationCommand registrationCommand;

    @PostMapping(path="")
    public ResponseEntity createMedicalHistory (@RequestBody MedicalHistory medicalHistory) {
        try {
            registrationCommand.createMedicalHistory(medicalHistory);
        } catch (Exception error) {
            return ResponseEntity.status(400).body(error.getMessage());
        }

        return ResponseEntity.status(201).body("medical history created successfully");
    }


    @PutMapping
    public ResponseEntity updateMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
        try {
            registrationCommand.updateMedicalHistory(medicalHistory);
        } catch (Exception error) {
            return ResponseEntity.status(400).body(error.getMessage());
        }


        return ResponseEntity.status(201).body("medical history updated successfully");
    }

    @GetMapping(path="")
    public @ResponseBody ResponseEntity<MedicalHistory> getMedicalHistory(
            @RequestParam(required = false) Integer patientId
    ) {
        MedicalHistory medicalHistory = registrationCommand.getMedicalHistory(patientId);

        if (medicalHistory == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(200).body(medicalHistory);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<MedicalHistory>> getAllMedicalHistories() {
        List<MedicalHistory> medicalHistories =  registrationCommand.getAllMedicalHistories();

        return ResponseEntity.status(200).body(medicalHistories);
    }

    @DeleteMapping(path="")
    public @ResponseBody ResponseEntity removeMedicalHistory(@RequestParam Integer id) {
        try {
            registrationCommand.removeMedicalHistory(id);
        } catch (EmptyResultDataAccessException error) {
            return ResponseEntity.status(400).body("medical history not found");
        } catch (Exception error) {
            return ResponseEntity.status(500).body("medical history deletion failed");
        }
        return ResponseEntity.status(200).body("medical history deleted");
    }
}
