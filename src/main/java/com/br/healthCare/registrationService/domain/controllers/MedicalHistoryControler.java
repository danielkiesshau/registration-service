package com.br.healthCare.registrationService.domain.controllers;

import com.br.healthCare.registrationService.domain.commands.MedicalHistoryCommand;
import com.br.healthCare.registrationService.requests.MedicalHistoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/medical-history")
public class MedicalHistoryControler {

    @Autowired
    private MedicalHistoryCommand medicalHistoryCommand;

    @PostMapping(path="")
    public ResponseEntity createMedicalHistory (@RequestBody MedicalHistoryRequest request) {
        try {
            medicalHistoryCommand.createMedicalHistory(request);
        } catch (Exception error) {
            return ResponseEntity.status(400).body(error.getMessage());
        }

        return ResponseEntity.status(201).body("medical history created successfully");
    }


    @PutMapping
    public ResponseEntity updateMedicalHistory(@RequestBody MedicalHistoryRequest request) {
        try {
            medicalHistoryCommand.updateMedicalHistory(request);
        } catch (Exception error) {
            return ResponseEntity.status(400).body(error.getMessage());
        }


        return ResponseEntity.status(201).body("medical history updated successfully");
    }

    @GetMapping(path="")
    public @ResponseBody ResponseEntity<MedicalHistoryRequest> getMedicalHistory(
            @RequestParam(required = false) Integer patientId) {
        MedicalHistoryRequest MedicalHistoryRequest = medicalHistoryCommand.getMedicalHistory(patientId);

        if (MedicalHistoryRequest == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(200).body(MedicalHistoryRequest);
    }

    @DeleteMapping(path="")
    public @ResponseBody ResponseEntity removeMedicalHistory(@RequestParam Integer patient_id) {
        try {
            medicalHistoryCommand.removeMedicalHistory(patient_id);
        } catch (EmptyResultDataAccessException error) {
            return ResponseEntity.status(400).body("medical history not found");
        } catch (Exception error) {
            return ResponseEntity.status(500).body("medical history deletion failed");
        }
        return ResponseEntity.status(200).body("medical history deleted");
    }
}
