package com.br.healthCare.registrationService.infra.medicalHistoryDatabase.medicalHistoryRepositories;

import com.br.healthCare.registrationService.infra.data.MedicalHistoryData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends CrudRepository<MedicalHistoryData, Integer> {
    @Query(value = "SELECT * FROM medical_history_data WHERE patient_data_id = ?1", nativeQuery = true)
    MedicalHistoryData findByPatientId(int id);

    @Modifying
    @Query(value = "DELETE FROM MedicalHistoryData m WHERE m.patient.id= ?1")
    MedicalHistoryData deleteByPatientId(int id);

}
