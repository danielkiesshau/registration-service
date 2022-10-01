package com.br.healthCare.registrationService.domain.commands;

import com.br.healthCare.registrationService.infra.data.MedicalHistoryData;
import com.br.healthCare.registrationService.infra.data.PatientData;
import com.br.healthCare.registrationService.infra.data.medicalHistoryData.ContinuousUseMedicationsData;
import com.br.healthCare.registrationService.infra.data.medicalHistoryData.RelativesDiseasesData;
import com.br.healthCare.registrationService.infra.data.medicalHistoryData.SurgicalProceduresData;
import com.br.healthCare.registrationService.infra.PatientDatabase.PatientDao;
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



    public List<MedicalHistoryData> getAllMedicalHistories() {
        return medicalHistoryDao.getData();
    }

    public MedicalHistoryData getMedicalHistory(Integer patientId) {
        return medicalHistoryDao.findByPatientId(patientId);
    }


    public void createMedicalHistory(MedicalHistoryData medicalHistoryData) throws Exception {
        List<SurgicalProceduresData> surgicalProcedureData = medicalHistoryData.getSurgicalProcedures();
        List<ContinuousUseMedicationsData> continuousUseMedicationData = medicalHistoryData.getContinuousUseMedications();
        List<RelativesDiseasesData> relativesDiseaseData = medicalHistoryData.getRelativesDiseases();

        this.validatePatientId(medicalHistoryData.getPatient().getId());

        if (!surgicalProcedureData.isEmpty()) {
            this.saveSurgicalProcedures(surgicalProcedureData);
        }
        if (!continuousUseMedicationData.isEmpty()) {
            this.saveContinuousUseMedications(continuousUseMedicationData);
        }
        if (!relativesDiseaseData.isEmpty()) {
            this.saveRelativesDiseases(relativesDiseaseData);
        }

        this.saveMedicalHistory(medicalHistoryData);
    }


    public void saveMedicalHistory(MedicalHistoryData medicalHistoryData) {
        medicalHistoryDao.setMedicalHistory(medicalHistoryData);
        medicalHistoryDao.insertData();

    }

    public void saveSurgicalProcedures(List<SurgicalProceduresData> surgicalProcedureData) {
        for (SurgicalProceduresData procedure : surgicalProcedureData) {
            surgicalProceduresDAO.setSurgicalProcedures(procedure);
            surgicalProceduresDAO.insertData();
        }
    }

    public void saveContinuousUseMedications(List<ContinuousUseMedicationsData> continuousUseMedicationData) {
        for (ContinuousUseMedicationsData medication : continuousUseMedicationData) {
            continuousUseMedicationDAO.setContinuousUseMedications(medication);
            continuousUseMedicationDAO.insertData();
        }
    }

    public void saveRelativesDiseases(List<RelativesDiseasesData> relativesDiseaseData) {
        for (RelativesDiseasesData disease : relativesDiseaseData) {
            relativesDiseasesDAO.setRelativesDiseases(disease);
            relativesDiseasesDAO.insertData();
        }
    }


    private void validatePatientId (Integer patientId) throws Exception {
        Optional<PatientData> patient = patientDao.findById(patientId);
        if(!patient.isEmpty()){
            return;
        }
        throw new Exception("Patient not found");
    }

    public void updateMedicalHistory(MedicalHistoryData medicalHistoryData) throws Exception {
        this.createMedicalHistory(medicalHistoryData);
    }

    private void deleteMedicalHistory(MedicalHistoryData medicalHistoryData) {
        medicalHistoryDao.setMedicalHistory(medicalHistoryData);
        medicalHistoryDao.deleteData();
    }
    public void removeMedicalHistory(Integer id)  {
        MedicalHistoryData medicalHistoryData = new MedicalHistoryData();
        medicalHistoryData.setId(id);

       this.deleteMedicalHistory(medicalHistoryData);
    }
}
