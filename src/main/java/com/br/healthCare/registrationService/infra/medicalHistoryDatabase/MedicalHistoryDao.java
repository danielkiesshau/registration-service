package com.br.healthCare.registrationService.infra.medicalHistoryDatabase;

import com.br.healthCare.registrationService.data.MedicalHistory;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.Repositories.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalHistoryDao implements RegistrationDAO<MedicalHistory> {
    private MedicalHistory medicalHistory;
    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Override
    public void insertData(){
        medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public void updateData(){
        medicalHistoryRepository.save(medicalHistory);
    }

    @Override
    public List<MedicalHistory> getData(){
        Iterable<MedicalHistory> iterable = medicalHistoryRepository.findAll();
        return new IterableHelper().toList(iterable);    }

    @Override
    public void deleteData(){
        medicalHistoryRepository.save(medicalHistory);
    }

    public List<MedicalHistory> findByPatientId() {
        List<MedicalHistory> result = medicalHistoryRepository.findByPatientId(medicalHistory.getPatientId());
        return result;
    }
}
