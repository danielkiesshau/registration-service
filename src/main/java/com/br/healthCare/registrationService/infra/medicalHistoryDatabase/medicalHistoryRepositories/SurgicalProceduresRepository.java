package com.br.healthCare.registrationService.infra.medicalHistoryDatabase.medicalHistoryRepositories;

import com.br.healthCare.registrationService.infra.data.medicalHistoryData.ContinuousUseMedicationsData;
import com.br.healthCare.registrationService.infra.data.medicalHistoryData.SurgicalProceduresData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurgicalProceduresRepository extends CrudRepository<SurgicalProceduresData, Integer> {
    @Query(value = "SELECT * FROM surgical_procedures_data WHERE patient_data_id = ?1", nativeQuery = true)
    List<SurgicalProceduresData> findByPatientId(int id);
}
