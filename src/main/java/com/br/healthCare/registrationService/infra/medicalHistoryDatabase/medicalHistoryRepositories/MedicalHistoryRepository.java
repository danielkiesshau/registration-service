package com.br.healthCare.registrationService.infra.medicalHistoryDatabase.medicalHistoryRepositories;

import com.br.healthCare.registrationService.infra.data.MedicalHistoryData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends CrudRepository<MedicalHistoryData, Integer> {
    @Query(value = "SELECT * FROM medical_history WHERE patient_id = ?1", nativeQuery = true)
    MedicalHistoryData findByPatientId(int id);

}
