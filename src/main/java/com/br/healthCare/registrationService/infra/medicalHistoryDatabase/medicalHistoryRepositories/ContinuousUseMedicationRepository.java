package com.br.healthCare.registrationService.infra.medicalHistoryDatabase.medicalHistoryRepositories;

import com.br.healthCare.registrationService.infra.data.medicalHistoryData.ContinuousUseMedicationsData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContinuousUseMedicationRepository extends CrudRepository<ContinuousUseMedicationsData, Integer> {

    @Query(value = "SELECT * FROM continuousUseMedications WHERE medicalHistoryId = ?1", nativeQuery = true)
    List<ContinuousUseMedicationsData> findByMedicalHistoryId(int id);

}
