package com.br.healthCare.registrationService.domain.commands;

import com.br.healthCare.registrationService.data.MedicalHistory;
import com.br.healthCare.registrationService.data.Patient;
import com.br.healthCare.registrationService.data.medicalHistoryData.ContinuousUseMedications;
import com.br.healthCare.registrationService.data.medicalHistoryData.RelativesDiseases;
import com.br.healthCare.registrationService.data.medicalHistoryData.SurgicalProcedures;
import com.br.healthCare.registrationService.infra.Patient.PatientDao;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.ContinuousUseMedicationDAO;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.MedicalHistoryDao;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.RelativesDiseasesDAO;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.SurgicalProceduresDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public MedicalHistory getMedicalHistory(Integer patientId) {
        return medicalHistoryDao.findByPatientId(patientId);
    }


    public void createMedicalHistory(MedicalHistory medicalHistory) throws Exception {
        List<SurgicalProcedures> surgicalProcedures = medicalHistory.getSurgicalProcedures();
        List<ContinuousUseMedications> continuousUseMedications = medicalHistory.getContinuousUseMedications();
        List<RelativesDiseases> relativesDiseases = medicalHistory.getRelativesDiseases();

        this.validatePatientId(medicalHistory.getPatient().getId());

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
        Optional<Patient> patient = patientDao.findById(patientId);
        if(!patient.isEmpty()){
            return;
        }
        throw new Exception("Patient not found");
    }

    public void updateMedicalHistory(MedicalHistory medicalHistory) throws Exception {
        this.createMedicalHistory(medicalHistory);
    }

    private void deleteMedicalHistory(MedicalHistory medicalHistory) {
        medicalHistoryDao.setMedicalHistory(medicalHistory);
        medicalHistoryDao.deleteData();
    }
    public void removeMedicalHistory(Integer id)  {
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setId(id);

       this.deleteMedicalHistory(medicalHistory);
    }
}
