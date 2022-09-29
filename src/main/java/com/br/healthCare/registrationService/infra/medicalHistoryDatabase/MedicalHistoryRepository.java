package com.br.healthCare.registrationService.infra.medicalHistoryDatabase;

import com.br.healthCare.registrationService.data.MedicalHistory;
import org.springframework.data.repository.CrudRepository;

public interface MedicalHistoryRepository extends CrudRepository<MedicalHistory, Integer> {


}
