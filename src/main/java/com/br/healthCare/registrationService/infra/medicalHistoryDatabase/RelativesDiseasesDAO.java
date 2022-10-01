package com.br.healthCare.registrationService.infra.medicalHistoryDatabase;

import com.br.healthCare.registrationService.data.medicalHistoryData.RelativesDiseases;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.Repositories.RelativesDiseasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RelativesDiseasesDAO implements RegistrationDAO {
    private RelativesDiseases relativesDiseases;
    @Autowired
    private RelativesDiseasesRepository relativesDiseasesRepository;

    @Override
    public void insertData() {
        relativesDiseasesRepository.save(relativesDiseases);
    }

    @Override
    public List getData() {
        Iterable<RelativesDiseases> iterable = relativesDiseasesRepository.findAll();
        return new IterableHelper().toList(iterable);
    }

    @Override
    public void updateData() {
            relativesDiseasesRepository.save(relativesDiseases);
    }

    @Override
    public void deleteData() {
            relativesDiseasesRepository.delete(relativesDiseases);
    }

    public List<RelativesDiseases> findByMedicalHistoryId(Integer medicalHistoryId) {
        List<RelativesDiseases> result = relativesDiseasesRepository.findByMedicalHistoryId(medicalHistoryId);
        return result;
    }

    public void setRelativesDiseases(RelativesDiseases relativesDiseases) {
        this.relativesDiseases = relativesDiseases;
    }
}
