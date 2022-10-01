package com.br.healthCare.registrationService.infra.medicalHistoryDatabase;

import com.br.healthCare.registrationService.infra.data.medicalHistoryData.SurgicalProceduresData;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.medicalHistoryRepositories.SurgicalProceduresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgicalProceduresDAO implements RegistrationDAO {
    private SurgicalProceduresData surgicalProceduresData;

    @Autowired
    private SurgicalProceduresRepository surgicalProceduresRepository;
    @Override
    public void insertData() {
        surgicalProceduresRepository.save(surgicalProceduresData);
    }

    @Override
    public List getData() {
        Iterable<SurgicalProceduresData> iterable = surgicalProceduresRepository.findAll();
        return new IterableHelper().toList(iterable);
    }

    @Override
    public void updateData() {
        surgicalProceduresRepository.save(surgicalProceduresData);
    }

    @Override
    public void deleteData() {
        surgicalProceduresRepository.delete(surgicalProceduresData);
    }

    public List<SurgicalProceduresData> findByMedicalHistoryId(Integer medicalHistoryId) {
        List<SurgicalProceduresData> result = surgicalProceduresRepository.findByMedicalHistoryId(medicalHistoryId);
        return result;
    }

    public void setSurgicalProcedures(SurgicalProceduresData surgicalProceduresData) {
        this.surgicalProceduresData = surgicalProceduresData;
    }
}
