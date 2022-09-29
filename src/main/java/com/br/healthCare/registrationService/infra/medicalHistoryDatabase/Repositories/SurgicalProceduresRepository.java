package com.br.healthCare.registrationService.infra.medicalHistoryDatabase.Repositories;

import com.br.healthCare.registrationService.data.medicalHistoryData.SurgicalProcedures;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SurgicalProceduresRepository extends CrudRepository<SurgicalProcedures, Integer> {
    @Query(value = "SELECT * FROM surgicalProcedures WHERE medicalHistoryId = ?1", nativeQuery = true)
    List<SurgicalProcedures> findByMedicalHistoryId(int id);
}
