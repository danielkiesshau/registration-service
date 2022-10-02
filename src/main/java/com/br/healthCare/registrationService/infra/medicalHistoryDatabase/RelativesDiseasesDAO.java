package com.br.healthCare.registrationService.infra.medicalHistoryDatabase;

import com.br.healthCare.registrationService.infra.data.medicalHistoryData.RelativesDiseasesData;
import com.br.healthCare.registrationService.infra.RegistrationDAO;
import com.br.healthCare.registrationService.infra.helpers.IterableHelper;
import com.br.healthCare.registrationService.infra.medicalHistoryDatabase.medicalHistoryRepositories.RelativesDiseasesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RelativesDiseasesDAO implements RegistrationDAO {
    private RelativesDiseasesData relativesDiseasesData;
    @Autowired
    private RelativesDiseasesRepository relativesDiseasesRepository;

    @Override
    public void insertData() {
        relativesDiseasesRepository.save(relativesDiseasesData);
    }

    @Override
    public List getData() {
        Iterable<RelativesDiseasesData> iterable = relativesDiseasesRepository.findAll();
        return new IterableHelper().toList(iterable);
    }

    @Override
    public void updateData() {
            relativesDiseasesRepository.save(relativesDiseasesData);
    }

    @Override
    public void deleteData() {
            relativesDiseasesRepository.delete(relativesDiseasesData);
    }

    public List<RelativesDiseasesData> findByPatientId(Integer medicalHistoryId) {
        List<RelativesDiseasesData> result = relativesDiseasesRepository.findByPatientId(medicalHistoryId);
        return result;
    }

    public void setRelativesDiseases(RelativesDiseasesData relativesDiseasesData) {
        this.relativesDiseasesData = relativesDiseasesData;
    }
}
