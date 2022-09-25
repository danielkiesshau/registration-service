package com.br.healthCare.registrationService.infra;

import com.br.healthCare.registrationService.data.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Integer> {
}
