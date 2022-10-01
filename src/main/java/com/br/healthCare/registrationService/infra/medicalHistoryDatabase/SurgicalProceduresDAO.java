package com.br.healthCare.registrationService.infra.medicalHistoryDatabase;

import com.br.healthCare.registrationService.data.medicalHistoryData.SurgicalProcedures;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.Repositories.SurgicalProceduresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgicalProceduresDAO implements RegistrationDAO {
    private SurgicalProcedures surgicalProcedures;

    @Autowired
    private SurgicalProceduresRepository surgicalProceduresRepository;
    @Override
    public void insertData() {
        surgicalProceduresRepository.save(surgicalProcedures);
    }

    @Override
    public List getData() {
        Iterable<SurgicalProcedures> iterable = surgicalProceduresRepository.findAll();
        return new IterableHelper().toList(iterable);
    }

    @Override
    public void updateData() {
        surgicalProceduresRepository.save(surgicalProcedures);
    }

    @Override
    public void deleteData() {
        surgicalProceduresRepository.delete(surgicalProcedures);
    }

    public List<SurgicalProcedures> findByMedicalHistoryId(Integer medicalHistoryId) {
        List<SurgicalProcedures> result = surgicalProceduresRepository.findByMedicalHistoryId(medicalHistoryId);
        return result;
    }

    public void setSurgicalProcedures(SurgicalProcedures surgicalProcedures) {
        this.surgicalProcedures = surgicalProcedures;
    }
}
