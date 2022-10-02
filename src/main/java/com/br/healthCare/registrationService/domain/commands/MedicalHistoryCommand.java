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
import com.br.healthCare.registrationService.requests.MedicalHistoryRequest;
import com.br.healthCare.registrationService.requests.requestComplements.ContinuousUseMedications;
import com.br.healthCare.registrationService.requests.requestComplements.RelativesDiseases;
import com.br.healthCare.registrationService.requests.requestComplements.SurgicalProcedures;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MedicalHistoryCommand {

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




    public MedicalHistoryRequest getMedicalHistory(Integer patientId) {
        return convertMedicalHistoryFromData(medicalHistoryDao.findByPatientId(patientId), continuousUseMedicationDAO.findByPatientId(patientId),
                surgicalProceduresDAO.findByPatientId(patientId), relativesDiseasesDAO.findByPatientId(patientId));
    }


    public void createMedicalHistory(MedicalHistoryRequest request) throws Exception {
        List<SurgicalProceduresData> surgicalProcedureData = convertSurgicalProceduresFromRequest(request);
        List<ContinuousUseMedicationsData> continuousUseMedicationData = converContinuousMedicationFromRequest(request);
        List<RelativesDiseasesData> relativesDiseaseData = convertRelativesDiseasesFromRequest(request);
        MedicalHistoryData medicalHistoryData = convertMedicalHistoryFromRequest(request);
        this.validatePatientId(request.getPatientId());

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

    public void updateMedicalHistory(MedicalHistoryRequest request) throws Exception {
        this.createMedicalHistory(request);
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

    private MedicalHistoryData convertMedicalHistoryFromRequest(MedicalHistoryRequest request) {
        return MedicalHistoryData.builder()
                .withAllergies(request.getAllergies())
                .withBloodType(request.getBloodType())
                .withExistingDiseases(request.getExistingDiseases())
                .withLimitations(request.getLimitations())
                .withPatientId(request.getPatientId())
                .isPregnant(request.isPregnant())
                .isSmoker(request.isSmoker())
                .build();
    }

    private List<ContinuousUseMedicationsData> converContinuousMedicationFromRequest(MedicalHistoryRequest request) {
        List<ContinuousUseMedicationsData> responseData = new ArrayList<>();
        for (ContinuousUseMedications medication : request.getContinuousUseMedications()) {
            responseData.add(ContinuousUseMedicationsData.builder()
                    .withPatientId(request.getPatientId())
                    .withMedicationName(medication.getMedicationName())
                    .withMedicationDoseMg(medication.getMedicationDoseMg())
                    .withUSageFrequency(medication.getUsageFrequency())
                    .withUseTime(medication.getUseTime())
                    .build());
        }
        return responseData;
    }

    private List<RelativesDiseasesData> convertRelativesDiseasesFromRequest(MedicalHistoryRequest request) {
        List<RelativesDiseasesData> responseData = new ArrayList<>();
        for (RelativesDiseases disease : request.getRelativesDiseases()) {
            responseData.add(RelativesDiseasesData.builder()
                    .withPatientId(request.getPatientId())
                    .withDiseaseName(disease.getDiseaseName())
                    .withKinshipDegree(disease.getKinshipDegree())
                    .build());
        }
        return responseData;
    }

    private List<SurgicalProceduresData> convertSurgicalProceduresFromRequest(MedicalHistoryRequest request) {
        List<SurgicalProceduresData> responseData = new ArrayList<>();
        for (SurgicalProcedures procedure : request.getSurgicalProcedures()) {
            responseData.add(SurgicalProceduresData.builder()
                    .withPatientId(request.getPatientId())
                    .withProcedureName(procedure.getProcedureName())
                    .withComplications(procedure.getComplications())
                    .withDate(procedure.getDate())
                    .build());
        }
        return responseData;
    }

    private MedicalHistoryRequest convertMedicalHistoryFromData(MedicalHistoryData data, List<ContinuousUseMedicationsData> medications,
                                                                List<SurgicalProceduresData> procedures, List<RelativesDiseasesData> relativesDiseases) {
        return MedicalHistoryRequest.builder()
                .withAllergies(data.getAllergies())
                .withBloodType(data.getBloodType())
                .withExistingDiseases(data.getExistingDiseases())
                .withLimitations(data.getLimitations())
                .withPatientId(data.getPatient().getId())
                .isPregnant(data.isPregnant())
                .withContinuousUseMedications(converContinuousMedicationFromData(medications))
                .withRelativesDiseases(convertRelativesDiseasesFromData(relativesDiseases))
                .withSurgicalProcedures(convertSurgicalProceduresFromData(procedures))
                .isSmoker(data.isSmoker())
                .build();
    }

    private List<ContinuousUseMedications> converContinuousMedicationFromData(List<ContinuousUseMedicationsData> data) {
        List<ContinuousUseMedications> responseData = new ArrayList<>();
        for (ContinuousUseMedicationsData medication : data) {
            responseData.add(ContinuousUseMedications.builder()
                    .withMedicationName(medication.getMedicationName())
                    .withMedicationDoseMg(medication.getMedicationDoseMg())
                    .withUSageFrequency(medication.getUsageFrequency())
                    .withUseTime(medication.getUseTime())
                    .build());
        }
        return responseData;
    }

    private List<RelativesDiseases> convertRelativesDiseasesFromData(List<RelativesDiseasesData> data) {
        List<RelativesDiseases> responseData = new ArrayList<>();
        for (RelativesDiseasesData disease : data) {
            responseData.add(RelativesDiseases.builder()
                    .withDiseaseName(disease.getDiseaseName())
                    .withKinshipDegree(disease.getKinshipDegree())
                    .build());
        }
        return responseData;
    }

    private List<SurgicalProcedures> convertSurgicalProceduresFromData(List<SurgicalProceduresData> data) {
        List<SurgicalProcedures> responseData = new ArrayList<>();
        for (SurgicalProceduresData procedure : data) {
            responseData.add(SurgicalProcedures.builder()
                    .withProcedureName(procedure.getProcedureName())
                    .withComplications(procedure.getComplications())
                    .withDate(procedure.getDate())
                    .build());
        }
        return responseData;
    }

}
