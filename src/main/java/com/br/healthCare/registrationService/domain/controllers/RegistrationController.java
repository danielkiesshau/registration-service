package com.br.healthCare.registrationService.domain.controllers;

import com.br.healthCare.registrationService.domain.commands.RegistrationCommand;
import com.br.healthCare.registrationService.requests.MedicalHistoryRequest;
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
    public ResponseEntity createMedicalHistory (@RequestBody MedicalHistoryRequest MedicalHistoryRequest) {
        try {
            registrationCommand.createMedicalHistory(MedicalHistoryRequest);
        } catch (Exception error) {
            return ResponseEntity.status(400).body(error.getMessage());
        }

        return ResponseEntity.status(201).body("medical history created successfully");
    }


    @PutMapping
    public ResponseEntity updateMedicalHistory(@RequestBody MedicalHistoryRequest MedicalHistoryRequest) {
        try {
            registrationCommand.updateMedicalHistory(MedicalHistoryRequest);
        } catch (Exception error) {
            return ResponseEntity.status(400).body(error.getMessage());
        }


        return ResponseEntity.status(201).body("medical history updated successfully");
    }

    @GetMapping(path="")
    public @ResponseBody ResponseEntity<MedicalHistoryRequest> getMedicalHistory(
            @RequestParam(required = false) Integer patientId
    ) {
        MedicalHistoryRequest MedicalHistoryRequest = registrationCommand.getMedicalHistory(patientId);

        if (MedicalHistoryRequest == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(200).body(MedicalHistoryRequest);
    }

    @GetMapping(path="/all")
    public ResponseEntity<List<MedicalHistoryRequest>> getAllMedicalHistories() {
        List<MedicalHistoryRequest> medicalHistories =  registrationCommand.getAllMedicalHistories();

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
