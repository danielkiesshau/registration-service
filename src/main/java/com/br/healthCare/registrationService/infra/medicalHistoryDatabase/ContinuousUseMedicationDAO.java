package com.br.healthCare.registrationService.infra.medicalHistoryDatabase;

import com.br.healthCare.registrationService.data.medicalHistoryData.ContinuousUseMedications;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.Repositories.ContinuousUseMedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContinuousUseMedicationDAO implements RegistrationDAO {
    private ContinuousUseMedications continuousUseMedications;
    @Autowired
    private ContinuousUseMedicationRepository continuousUseMedicationRepository;

    @Override
    public void insertData(){
        continuousUseMedicationRepository.save(continuousUseMedications);
    }

    @Override
    public void updateData(){
        continuousUseMedicationRepository.save(continuousUseMedications);
    }

    @Override
    public List<ContinuousUseMedications> getData(){
        Iterable<ContinuousUseMedications> iterable = continuousUseMedicationRepository.findAll();
        return new IterableHelper().toList(iterable);    }

    @Override
    public void deleteData(){
        continuousUseMedicationRepository.save(continuousUseMedications);
    }

    public List<ContinuousUseMedications> findByMedicalHistoryId() {
        List<ContinuousUseMedications> result = continuousUseMedicationRepository.findByMedicalHistoryId(continuousUseMedications.getMedicalHistoryId());
        return result;
    }
}
