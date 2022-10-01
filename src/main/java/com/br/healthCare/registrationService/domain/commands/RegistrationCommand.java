package com.br.healthCare.registrationService.domain.commands;

import com.br.healthCare.registrationService.data.MedicalHistory;
import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.data.medicalHistoryData.ContinuousUseMedications;
import com.br.healthCare.registrationService.data.medicalHistoryData.RelativesDiseases;
import com.br.healthCare.registrationService.data.medicalHistoryData.SurgicalProcedures;
import com.br.healthCare.registrationService.data.pacientData.PatientAddress;
import com.br.healthCare.registrationService.domain.controllers.contracts.GetMedicalHistoryRequest;
import com.br.healthCare.registrationService.domain.controllers.contracts.GetPatientRequest;
import com.br.healthCare.registrationService.infra.Patient.PatientDao;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.ContinuousUseMedicationDAO;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.MedicalHistoryDao;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.RelativesDiseasesDAO;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.SurgicalProceduresDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationCommand {

    @Autowired
    private MedicalHistoryDao medicalHistoryDao;
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private ContinuousUseMedicationDAO continuousUseMedicationDAO;
    @Autowired
    private RelativesDiseasesDAO relativesDiseasesDAO;
    @Autowired
    private SurgicalProceduresDAO surgicalProceduresDAO;



    public List<MedicalHistory> getAllMedicalHistories() {
        return medicalHistoryDao.getData();
    }

    public MedicalHistory medicalHistory(GetMedicalHistoryRequest request) {
        if (request.getId() != null) {
            return medicalHistoryDao.findByPatientId(request.getId());
        }
        return null;
    }


    public void createMedicalHistory(MedicalHistory medicalHistory) throws Exception {
        List<SurgicalProcedures> surgicalProcedures = medicalHistory.getSurgicalProcedures();
        List<ContinuousUseMedications> continuousUseMedications = medicalHistory.getContinuousUseMedications();
        List<RelativesDiseases> relativesDiseases = medicalHistory.getRelativesDiseases();

        this.validatePatientId(medicalHistory.getPatientId());

        if (!surgicalProcedures.isEmpty()) {
            this.saveSurgicalProcedures(surgicalProcedures);
        }
        if (!continuousUseMedications.isEmpty()) {
            this.saveContinuousUseMedications(continuousUseMedications);
        }
        if (!relativesDiseases.isEmpty()) {
            this.saveRelativesDiseases(relativesDiseases);
        }

        this.saveMedicalHistory(medicalHistory);
    }


    public void saveMedicalHistory(MedicalHistory medicalHistory) {
        medicalHistoryDao.setMedicalHistory(medicalHistory);
        medicalHistoryDao.insertData();

    }

    public void saveSurgicalProcedures(List<SurgicalProcedures> surgicalProcedures) {
        for (SurgicalProcedures procedure : surgicalProcedures) {
            surgicalProceduresDAO.setSurgicalProcedures(procedure);
            surgicalProceduresDAO.insertData();
        }
    }

    public void saveContinuousUseMedications(List<ContinuousUseMedications> continuousUseMedications) {
        for (ContinuousUseMedications medication : continuousUseMedications) {
            continuousUseMedicationDAO.setContinuousUseMedications(medication);
            continuousUseMedicationDAO.insertData();
        }
    }

    public void saveRelativesDiseases(List<RelativesDiseases> relativesDiseases) {
        for (RelativesDiseases disease : relativesDiseases) {
            relativesDiseasesDAO.setRelativesDiseases(disease);
            relativesDiseasesDAO.insertData();
        }
    }


    private void validatePatientId (Integer patientId) throws Exception {
        Patient patient = patientDao.findById().get();
        if(patient != null){
            return;
        }
        throw new Exception("Patient not found");
    }

    public void updateMedicalHistory(MedicalHistory medicalHistory) throws Exception {
        this.createMedicalHistory(medicalHistory);
    }
}
