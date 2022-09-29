package com.br.healthCare.registrationService.infra.medicalHistoryDatabase.Repositories;

import com.br.healthCare.registrationService.data.medicalHistoryData.ContinuousUseMedications;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContinuousUseMedicationRepository extends CrudRepository<ContinuousUseMedications, Integer> {

    @Query(value = "SELECT * FROM continuousUseMedications WHERE medicalHistoryId = ?1", nativeQuery = true)
    List<ContinuousUseMedications> findByMedicalHistoryId(int id);

}
