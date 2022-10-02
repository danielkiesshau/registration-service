package com.br.healthCare.registrationService.infra.medicalHistoryDatabase;

import com.br.healthCare.registrationService.infra.data.medicalHistoryData.ContinuousUseMedicationsData;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.medicalHistoryRepositories.ContinuousUseMedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContinuousUseMedicationDAO implements RegistrationDAO {
    private ContinuousUseMedicationsData continuousUseMedicationsData;
    @Autowired
    private ContinuousUseMedicationRepository continuousUseMedicationRepository;

    @Override
    public void insertData(){
        continuousUseMedicationRepository.save(continuousUseMedicationsData);
    }

    @Override
    public void updateData(){
        continuousUseMedicationRepository.save(continuousUseMedicationsData);
    }

    @Override
    public List<ContinuousUseMedicationsData> getData(){
        Iterable<ContinuousUseMedicationsData> iterable = continuousUseMedicationRepository.findAll();
        return new IterableHelper().toList(iterable);    }

    @Override
    public void deleteData(){
        continuousUseMedicationRepository.save(continuousUseMedicationsData);
    }

    public List<ContinuousUseMedicationsData> findByPatientId(Integer patientId) {
        List<ContinuousUseMedicationsData> result = continuousUseMedicationRepository.findByPatientId(patientId);
        return result;
    }

    public void setContinuousUseMedications(ContinuousUseMedicationsData continuousUseMedicationsData) {
        this.continuousUseMedicationsData = continuousUseMedicationsData;
    }
}
