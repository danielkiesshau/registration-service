package com.br.healthCare.registrationService.infra.medicalHistoryDatabase;

import com.br.healthCare.registrationService.infra.data.MedicalHistoryData;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.medicalHistoryRepositories.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryDao implements RegistrationDAO<MedicalHistoryData> {
    public void setMedicalHistory(MedicalHistoryData medicalHistoryData) {
        this.medicalHistoryData = medicalHistoryData;
    }

    private MedicalHistoryData medicalHistoryData;
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public void insertData(){
        medicalHistoryRepository.save(medicalHistoryData);
    }

    @Override
    public void updateData(){
        medicalHistoryRepository.save(medicalHistoryData);
    }

    @Override
    public List<MedicalHistoryData> getData(){
        Iterable<MedicalHistoryData> iterable = medicalHistoryRepository.findAll();
        return new IterableHelper().toList(iterable);    }

    @Override
    public void deleteData(){
        medicalHistoryRepository.delete(medicalHistoryData);
    }

    public MedicalHistoryData findByPatientId(Integer patientId) {
        MedicalHistoryData result = medicalHistoryRepository.findByPatientId(patientId);
        return result;
    }



}
