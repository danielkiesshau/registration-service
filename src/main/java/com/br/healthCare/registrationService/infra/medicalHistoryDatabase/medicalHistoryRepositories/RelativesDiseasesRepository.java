package com.br.healthCare.registrationService.infra.medicalHistoryDatabase.medicalHistoryRepositories;

import com.br.healthCare.registrationService.infra.data.medicalHistoryData.ContinuousUseMedicationsData;
import com.br.healthCare.registrationService.infra.data.medicalHistoryData.RelativesDiseasesData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RelativesDiseasesRepository extends CrudRepository<RelativesDiseasesData, Integer> {
    @Query(value = "SELECT * FROM relatives_diseases_data WHERE patient_data_id = ?1", nativeQuery = true)
    List<RelativesDiseasesData> findByPatientId(int id);
}
