package com.br.healthCare.registrationService.infra.medicalHistoryDatabase.Repositories;

import com.br.healthCare.registrationService.data.medicalHistoryData.ContinuousUseMedications;
import org.springframework.data.repository.CrudRepository;

public interface ContinuousUseMedicationRepository extends CrudRepository<ContinuousUseMedications, Integer> {



}
