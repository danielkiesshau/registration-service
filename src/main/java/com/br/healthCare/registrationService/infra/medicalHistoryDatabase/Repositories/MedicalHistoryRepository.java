package com.br.healthCare.registrationService.infra.medicalHistoryDatabase.Repositories;

import com.br.healthCare.registrationService.data.MedicalHistory;
import com.br.healthCare.registrationService.data.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalHistoryRepository extends CrudRepository<MedicalHistory, Integer> {
    @Query(value = "SELECT * FROM medicalHistory WHERE patientId = ?1", nativeQuery = true)
    MedicalHistory findByPatientId(int id);

}
